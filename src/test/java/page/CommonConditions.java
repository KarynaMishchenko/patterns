package page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions{

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected HomePage homePage;
    protected PricingCalculatorPage pricingCalculatorPage;

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
        } else {
            test.log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }
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

