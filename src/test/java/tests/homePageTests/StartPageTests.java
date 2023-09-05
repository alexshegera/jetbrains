package tests.homePageTests;


import org.junit.jupiter.api.*;
import tests.steps.StartPageSteps;

public class StartPageTests {

    private static StartPageSteps startPageSteps;

    @BeforeEach
    public void setUp() {
        startPageSteps = new StartPageSteps();
    }

    @Test
    public void checkIsOpenStartPage_VerifyOpenedURLTest() {
        startPageSteps.openStartPageStep();
    }

    @Test
    public void checkIsOpenedAndLoadedStartPage_FindFiveButtonsAndPageBackgroundTest() {
        startPageSteps.checkFiveElementsOnStartPage();
    }

    @AfterEach
    public void done() {
        startPageSteps.closeBrowserStep();
    }
}