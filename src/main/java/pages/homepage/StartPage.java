package pages.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    private final By BACKGROUND_PHOTO_XPATH = By.xpath("//img[@alt='background']");
    private final By GREY_FRAME_XPATH = By.xpath("/html/body/div[1]/div[1]/div[2]");
    private final By REGISTER_BUTTON_XPATH = By.xpath("//button[contains(@class,'MuiButton-primaryContained')]");


    public WebElement getBackgroundPhoto() {
        return findElementLocator(BACKGROUND_PHOTO_XPATH);
    }

    public WebElement getGreyFrame() {
        return findElementLocator(GREY_FRAME_XPATH);
    }

    public WebElement getRegisterButton() {
        return findElementLocator(REGISTER_BUTTON_XPATH);
    }
}
