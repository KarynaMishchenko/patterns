/*package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private DriverSingleton(){
        //in order to not have ability to create instance of DriverSingleton object
    }
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "");
           if(browser.equals("edge")) {
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
           }
           else if(browser.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
           else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

}
*/