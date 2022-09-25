package util;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static WebDriver initializeDriver(String browser) {
        if (browser == null)
            browser = "Chrome";
        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            driver = new ChromeDriver(options);
            if (properties == null) {
                driver.get("https://www.a101.com.tr");
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            } else {
                String url = properties.getProperty("url");
                //Properties properties
                driver.get(url);
                driver.manage().window().maximize();
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(properties.getProperty("implicityWait"))));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(properties.getProperty("pageLoadTimeout"))));

            }
        }


        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
