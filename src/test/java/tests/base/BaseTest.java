package tests.base;

import common.CommonActions;
import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.base.BasePage;
import pages.features.FeaturesPage;
import pages.homepage.HomePage;
import pages.productsPage.ProductsPage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected ProductsPage productsPage = new ProductsPage(driver);
    protected FeaturesPage featuresPage = new FeaturesPage(driver);

    @BeforeMethod (alwaysRun = true)
    @Parameters({"homePageUrl", "productName", "productPrice"})
    public void setUp(String homePageUrl, String productName, String productPrice) {
        Constants.Urls.HOME_PAGE_URL = homePageUrl;
        Constants.Urls.FEATURE_PAGE_URL = homePageUrl + "idea/buy/#commercial";
        Constants.Urls.PRODUCT_NAME = productName;
        Constants.Urls.PRODUCT_PRICE = productPrice;
    }

    @AfterTest (alwaysRun = true)
    public void clearCookieAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE) {
            driver.manage().deleteAllCookies();
        }
    }

    @AfterSuite (alwaysRun = true)
    public void close() {
        if (HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
