package tests.steps;

import org.junit.Assert;
import tests.base.BaseTest;

import static constants.Constants.Urls.*;

public class Steps extends BaseTest {

    public void openHomePageStep() {
        basePage.open(HOME_PAGE_URL);
        Assert.assertEquals(HOME_PAGE_URL, basePage.getActualPage());
    }

    public void closeBrowsersStep() throws InterruptedException {
        driver.quit();
    }

    public void clickToLink_ChooseYourTool_And_RedirectToProductsPageStep() {
        homePage.ChooseYourTool_Link_Click();
    }

    public void enterJavaTextToInputFieldAndPressEnterStep() {
        productsPage.enter_Java_ToSearchInputField();
    }

    public void clickToCheckboxAndCheckStep() {
        productsPage.checkCheckboxWithValueJava();
    }

    public void clickToLearnMoreLinkAndRedirectToFeaturesPageStep() {
        productsPage.learnMoreLinkClick();
    }

    public void clickToPricingButtonAndDisplayProductCardsStep() {
        featuresPage.clickToPricingButton();
        Assert.assertEquals(FEATURE_PAGE_URL, featuresPage.getActualPage());
    }

    public void findCardWhereProductNameIsCorrectAndGettingProductPriceStep() {
        String ourPrice = featuresPage.getPriceForProduct();

        Assert.assertTrue("Product with specified price not found!", ourPrice.contains(PRODUCT_PRICE));
    }

    public void getIndividualUsageMonthlyPriceStep() throws InterruptedException {
        openHomePageStep();
        clickToLink_ChooseYourTool_And_RedirectToProductsPageStep();
        enterJavaTextToInputFieldAndPressEnterStep();
        clickToCheckboxAndCheckStep();
        clickToLearnMoreLinkAndRedirectToFeaturesPageStep();
        clickToPricingButtonAndDisplayProductCardsStep();
        findCardWhereProductNameIsCorrectAndGettingProductPriceStep();
        closeBrowsersStep();
    }
}
