package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
public class DriverSingleton {

    private static WebDriver driver;

    public DriverSingleton(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", ""); // Default to Chrome if property is not set
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }
}
