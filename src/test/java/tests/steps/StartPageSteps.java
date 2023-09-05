package tests.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import tests.base.BaseSteps;

import static constants.Constants.Urls.HOME_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartPageSteps extends BaseSteps {

    public void openStartPageStep() {
        basePage.open(HOME_PAGE_URL);
        assertEquals(HOME_PAGE_URL, basePage.getActualPage());
    }

    public void selectBackgroundPhotoStep() {
        LOG.info("Check background photo for styles");
        WebElement backgroundPhoto = startPage.getBackgroundPhoto();

        Assertions.assertEquals("375", backgroundPhoto.getAttribute("offsetWidth"));
        Assertions.assertEquals("667", backgroundPhoto.getAttribute("offsetHeight"));
        Assertions.assertTrue(backgroundPhoto.getAttribute("currentSrc").contains("/static/media/cropped."));
        Assertions.assertEquals("true", backgroundPhoto.getAttribute("isConnected"));
        Assertions.assertEquals("auto", backgroundPhoto.getAttribute("loading"));
    }

    public void selectGrayFrameStep() {
        LOG.info("Check grey frame for styles");

        WebElement greyFrame = startPage.getGreyFrame();

        Assertions.assertEquals("667", greyFrame.getAttribute("clientHeight"));
        Assertions.assertEquals("375", greyFrame.getAttribute("clientWidth"));
        Assertions.assertEquals("false", greyFrame.getAttribute("draggable"));
        Assertions.assertEquals("667", greyFrame.getAttribute("scrollHeight"));
        Assertions.assertEquals("375", greyFrame.getAttribute("scrollWidth"));
    }

    public void selectRegisterButtonStep() {
        LOG.info("Check 'Register' button for styles");

        WebElement registerButton = startPage.getRegisterButton();

        Assertions.assertEquals("36", registerButton.getAttribute("scrollHeight"));
        Assertions.assertEquals("191", registerButton.getAttribute("scrollWidth"));
        Assertions.assertEquals("Зареєструватися", registerButton.getAttribute("textContent"));
        Assertions.assertEquals("ЗАРЕЄСТРУВАТИСЯ", registerButton.getAccessibleName());
        Assertions.assertEquals("4px", registerButton.getCssValue("border-radius"));
        Assertions.assertEquals("500", registerButton.getCssValue("font-weight"));
        Assertions.assertEquals("14px", registerButton.getCssValue("font-size"));
        Assertions.assertEquals("24.5px", registerButton.getCssValue("line-height"));
        Assertions.assertEquals("Roboto, Helvetica, Arial, sans-serif",
                registerButton.getCssValue("font-family"));
        Assertions.assertEquals("4px", registerButton.getCssValue("background"));

    }

    public void checkFiveElementsOnStartPage() {
        openStartPageStep();
        selectBackgroundPhotoStep();
        selectGrayFrameStep();
        selectRegisterButtonStep();
    }
}
