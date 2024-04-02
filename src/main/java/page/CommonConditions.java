package page;

import builder.HomePageBuilder;
import builder.PricingCalculatorBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import factory.DriverFactory;
import utils.ExtentManager;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions{

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected HomePage homePage;
    protected PricingCalculatorPage pricingCalculatorPage;

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result != null) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, "Test Failed: " + result.getName());
                test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            } else if (result.getStatus() == ITestResult.SUCCESS) {
                test.log(Status.PASS, "Test Passed: " + result.getName());
            } else {
                test.log(Status.SKIP, "Test Skipped: " + result.getName());
            }
        }

        closeDriver();
    }
    @BeforeMethod()
    public void setUp()
    {
        driver = DriverFactory.getDriver();

        pricingCalculatorPage = new PricingCalculatorBuilder() //builder design pattern
                .setDriver(driver)
                .setString("Pricing test")
                .setInteger(1)
                .createPricingCalculatorPage();
        homePage = new HomePageBuilder() //builder design pattern
                .setDriver(driver)
                .setString("Example String")
                .setInteger(123)
                .createHomePage();
    }
    @AfterSuite
    public void tearDownExtentReports() {
        extent.flush();
    }

    @BeforeSuite
    public void setUpExtentReports() {
        extent = ExtentManager.getInstance();
    }

    public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
}

