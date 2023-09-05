package tests.base;

import common.CommonActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.homepage.StartPage;


public class BaseTests {
    protected WebDriver driver = CommonActions.createDriver();
    protected static final Logger LOG = LogManager.getLogger(BaseTests.class);

    protected BasePage basePage = new BasePage(driver);
    protected StartPage startPage = new StartPage(driver);
}