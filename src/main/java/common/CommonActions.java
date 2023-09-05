package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CommonActions {
    public static WebDriver createDriver() {
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) {
            case "win_chrome":
                WebDriverManager.chromedriver().setup();

                Map<String, Object> deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", 375);
                deviceMetrics.put("height", 667);
                deviceMetrics.put("pixelRatio", 1.0);

                Map<String, Object> clientHints = new HashMap<>();
                clientHints.put("platform", "Android");
                clientHints.put("mobile", true);

                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                mobileEmulation.put("clientHints", clientHints);
                mobileEmulation.put("userAgent", "Mozilla/5.0 " +
                        "(Linux; Android 9; Pixel 3 XL Build/PD1A.180621.003) AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/67.0.3396.87 Mobile Safari/537.36");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                chromeOptions.setHeadless(false);
                chromeOptions.addArguments("--disable-gpu"); // applicable to Windows os only
                chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                chromeOptions.addArguments("--disable-in-process-stack-traces");
                chromeOptions.addArguments("--disable-logging");
                chromeOptions.addArguments("--log-level=3");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--enable-touch-events");
                chromeOptions.addArguments("--windows-size=667,375");
                driver = new ChromeDriver(chromeOptions);
                break;
            default:
                assertFalse(Boolean.parseBoolean("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER));
        }

        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        return driver;
    }
}
