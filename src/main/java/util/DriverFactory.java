package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;
    Properties properties;
    DesiredCapabilities desiredCapabilities;

    public WebDriver initializeDriver(String browser) {
        if (browser == null) browser = "Chrome";
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);

            if (properties == null) {
                driver.get("https://www.a101.com.tr/");
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else {
                String url = properties.getProperty("url");
                //Properties properties
                driver.get(url);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("implicityWait")), TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);

            }
        }
        return getDriver();
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
}

