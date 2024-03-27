package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.HomePage;
import page.PricingCalculatorPage;
import utils.ExtentManager;

public class GoogleCloudTest {
    private static ExtentReports extent;
    private static ExtentTest test;
    private static WebDriver driver;
    private HomePage homePage;
    private PricingCalculatorPage pricingCalculatorPage;

    @BeforeSuite
    public void setUpExtentReports() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);
    }

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
        driver.quit();
    }

    @AfterSuite
    public void tearDownExtentReports() {
        extent.flush();
    }

    @Test(description = "Test case №123")
    public void GoogleCloudTest() {
        test = extent.createTest("Google Cloud Test");
        homePage.openGoogleCloud().clickOnSearch();
        homePage.enterTestInSearchBar("Google Cloud Platform Pricing Calculator").submitSearch();
        homePage.selectCalculator();
        pricingCalculatorPage.enterNumberOfInstances("4");
        Assert.assertEquals(pricingCalculatorPage.whatAreThereInstances().getText(), "");
        pricingCalculatorPage.clickOnSeries().selectSeries("n1");
        pricingCalculatorPage.clickOnMachineType().selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)");
        pricingCalculatorPage
                .addGPU()
                .clickOnGPUType()
                .selectGPUType("NVIDIA Tesla V100")
                .clickOnGPUNumbers()
                .selectGPUNumber();
        pricingCalculatorPage.clickOnLocalSSD().selectLocalSSD("2x375 GB");
        pricingCalculatorPage.addToEstimate().emailEstimateClick();
    }
}
