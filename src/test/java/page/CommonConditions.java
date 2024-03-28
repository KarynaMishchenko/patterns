package page;

import com.aventstack.extentreports.ExtentReports;
import driver.DriverSingleton;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions{

    protected WebDriver driver;
    private HomePage homePage;
    private PricingCalculatorPage pricingCalculatorPage;
    protected static ExtentReports extent;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
        homePage = new HomePage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);

    }
    @AfterSuite
    public void tearDownExtentReports() {
        extent.flush();
    }

    @BeforeSuite
    public void setUpExtentReports() {
        extent = ExtentManager.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

}

