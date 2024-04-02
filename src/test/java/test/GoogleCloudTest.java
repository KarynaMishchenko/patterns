package test;

import com.aventstack.extentreports.ExtentTest;
import decorator.LoggingHomePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.CommonConditions;
import page.HomePage;
import page.PricingCalculatorPage;

public class GoogleCloudTest extends CommonConditions {

    @Test(description = "Test case №123")
    public void googleCloudTest() {
        test = extent.createTest("Google Cloud Test");
        // Use the decorated HomePage
        HomePage decoratedHomePage = new LoggingHomePage(driver, "Example String", 123);

        decoratedHomePage.openGoogleCloud().clickOnSearch();
        decoratedHomePage.enterTextInSearchBar("Google Cloud Platform Pricing Calculator").submitSearch();
        decoratedHomePage.selectCalculator();
        // End of the decorated using

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
