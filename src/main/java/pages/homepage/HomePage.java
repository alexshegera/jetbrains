package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By chooseYourToolLink = By.xpath("//a[@class='wt-link wt-link_theme_dark'][text()='Choose your tool']");

    public HomePage ChooseYourTool_Link_Click() {
        WebElement chooseYourToolLinkElement = driver.findElement(chooseYourToolLink);
        waitElementIsVisible(chooseYourToolLinkElement).click();
        return this;
    }
}
