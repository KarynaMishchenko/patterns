package test;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import page.CommonPage;
import page.HomePage;
import page.PricingCalculatorPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoogleCloudTest {
    private static final Logger logger = LogManager.getLogger(GoogleCloudTest.class);
    //WebDriver driver = new ChromeDriver();
    private static WebDriver driver;

    HomePage homePage;
    PricingCalculatorPage pricingCalculatorPage;

    @BeforeMethod
    public void setUp(){
        //driver = DriverSingleton.getDriver();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        pricingCalculatorPage = new PricingCalculatorPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser(){
        driver.quit();
    }

    @Test(description = "Test case №123")
    public void NavigationGoogleCloudTest() {
        homePage.openGoogleCloud().clickOnSearch();
        logger.info("Search bar is opened");
        homePage.enterTestInSearchBar("Google Cloud Platform Pricing Calculator").submitSearch();
        logger.info("Search is performed");
        homePage.selectCalculator();
        logger.info("Calculator page is opened");
        pricingCalculatorPage.enterNumberOfInstances("4");
        pricingCalculatorPage.clickOnSeries().selectSeries("n1");
        pricingCalculatorPage.clickOnMachineType().selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)");
        pricingCalculatorPage
                .addGPU()
                .clickOnGPUType()
                .selectGPUType("NVIDIA Tesla V100")
                .clickOnGPUNumbers()
                .selectGPUNumber();
        pricingCalculatorPage.clickOnLocalSSD().selectLocalSSD("2x375 GB");
        //pricingCalculatorPage.clickOnDatacenter().selectDatacenter();
        //pricingCalculatorPage.clickOnCommittedUsage().selectCommittedUsage();
        pricingCalculatorPage.addToEstimate().emailEstimateClick();
        logger.info("Email Estimate dindow is opened");
        stopBrowser();
    }
}
