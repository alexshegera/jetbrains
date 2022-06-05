package tests.homePageTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.steps.Steps;

public class clickToChooseYourToolTest extends BaseTest {

    Steps steps;

    @BeforeMethod
    public void setUp() {
        steps = new Steps();
    }

    @Test
    public void checkIsRedirectTo_FindTheRightToolPage() throws InterruptedException {
        steps.getIndividualUsageMonthlyPriceStep();
    }
}
