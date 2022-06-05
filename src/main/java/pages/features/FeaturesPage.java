package pages.features;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

import static constants.Constants.Urls.PRODUCT_NAME;

public class FeaturesPage extends BasePage {


    private final String CARD_XPATH = "//div[@class='_wt-card_ru6f9_1 _wt-card_theme_light_ru6f9_15 buy-card']";
    private final String PRICE_XPATH = ".//div[@data-test='buy-card-body']/div/div[@data-test='buy-page-price']";

    private By pricingBtn = By.xpath("//a[@class='wt-col-inline wt-button wt-button_size_s wt-button_mode_outline']");
    private By pricingCards = By.xpath(CARD_XPATH);


    public FeaturesPage(WebDriver driver) {
        super(driver);
    }

    public FeaturesPage clickToPricingButton() {
        WebElement pricingBtnElement = driver.findElement(pricingBtn);
        waitElementIsVisible(pricingBtnElement);
        pricingBtnElement.click();
        return this;
    }

    public String getPriceForProduct() {
        List<WebElement> cards = driver.findElements(pricingCards);

        WebElement ourCard = null;
        for (WebElement card: cards) {
            if (card.findElement(By.xpath(".//div/h3")).getText().contains(PRODUCT_NAME)) {
                ourCard = card;
                break;
            }
        }

        Assert.assertTrue("Element Card not found!", ourCard != null);

        WebElement price = ourCard.findElement(By.xpath(PRICE_XPATH));
        return price.getAttribute("textContent");
    }
}
