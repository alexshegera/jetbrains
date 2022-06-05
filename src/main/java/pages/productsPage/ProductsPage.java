package pages.productsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By searchInput = By.xpath("//*[@id='react-collapsed-panel-0']/div/div/label/div/div/input");
    private By checkBox = By.xpath("//label[@class='_wt-list-item_1gxvy31_1 wt-list-item_placement_left _wt-list-item_mode_nude_1gxvy31_77 _wt-list-item_size_m_1gxvy31_65 _wt-list-item_theme_light_1gxvy31_25']");
    private By learnMoreLink = By.xpath("//a[@class='wt-col-inline wt-link wt-link_theme_light'][text()='Learn more']");

    public ProductsPage enter_Java_ToSearchInputField() {
        WebElement searchInputElement = driver.findElement(searchInput);
        waitElementIsVisible(searchInputElement);
        searchInputElement.sendKeys("java");
        return this;
    }

    public ProductsPage checkCheckboxWithValueJava() {
        WebElement checkBoxElement = driver.findElement(checkBox);
        waitElementIsVisible(checkBoxElement);
        checkBoxElement.click();
        return this;
    }

    public ProductsPage learnMoreLinkClick() {
        WebElement learnMoreLinkElement = driver.findElement(learnMoreLink);
        waitElementIsVisible(learnMoreLinkElement);
        learnMoreLinkElement.click();
        return this;
    }

}
