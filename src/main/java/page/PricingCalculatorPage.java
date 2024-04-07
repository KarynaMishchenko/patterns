package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage {
    protected WebDriver driver;
    public String string;
    public Integer integer;
    @FindBy(xpath = "//iframe[contains(@name,'goog_')]")
    private WebElement frameName;
    @FindBy(xpath ="//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']" )
    private WebElement numberOfInstancesField;
    @FindBy(xpath = "(//div[@class='md-text ng-binding'])[1]")
    private WebElement seriesField;
    @FindBy(id = "input_101")
    private WebElement theseInstancesField;
    @FindBy(xpath = "(//div[@class='md-text ng-binding'])[2]")
    private WebElement machineTypeField;
    @FindBy(xpath = "//*[contains(text(), 'Add GPUs')]")
    private WebElement addGPU;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeField;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement GPUNumberField;
    @FindBy(id = "select_option_520")
    private WebElement GPUNumberValue;
    @FindBy(xpath = "(//div[@class='md-text ng-binding'])[12]")
    private WebElement localSSDField;
    @FindBy(xpath = "(//div[@class='md-text ng-binding'])[13]")
    private WebElement DatacenterField;
    @FindBy(id = "select_option_338")
    private WebElement DatacenterValue;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
    @FindBy(xpath = "//md-option[@ng-value = '1']")
    private WebElement committedUsageValue;
    @FindBy(xpath = "(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")
    private WebElement addToEstimateField;
    @FindBy(xpath = "(//span[@class='google-symbols ng-scope'])[47]")
    private WebElement emailEstimateButton;

    public PricingCalculatorPage(WebDriver driver, String string, Integer integer) {
        this.driver = driver;
        this.string=string;
        this.integer=integer;
        PageFactory.initElements(driver,this);
    }

    public PricingCalculatorPage(WebDriver driver) {
    }

    public void enterNumberOfInstances(String keyForNumberOfInstances) {
        driver.switchTo().frame(waitForElementVisibility(frameName));
        driver.switchTo().frame("myFrame");
        waitForElementVisibility(numberOfInstancesField).sendKeys(keyForNumberOfInstances);
    }
    public PricingCalculatorPage clickOnSeries(){
        waitForElementVisibility(seriesField).click();
        return this;
    }
    public WebElement whatAreThereInstances(){
        return waitForElementVisibility(theseInstancesField);
    }
    public void selectSeries(String value){ // cannot create FindBy annotation because of variable in the xpath
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement seriesValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[contains(@value, '" + value + "')]")));
        seriesValue.click();
    }
    public PricingCalculatorPage clickOnMachineType(){
        waitForElementVisibility(machineTypeField).click();
        return this;
    }
    public void selectMachineType(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement machineTypeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        machineTypeValue.click();
    }
    public PricingCalculatorPage addGPU(){
        waitForElementVisibility(addGPU).click();
        return this;
    }
    public PricingCalculatorPage clickOnGPUType(){
       waitForElementVisibility(GPUTypeField).click();
        return this;
    }

    public PricingCalculatorPage selectGPUType(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GPUTypeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        GPUTypeValue.click();
        return this;
    }
    public PricingCalculatorPage clickOnGPUNumbers(){
        waitForElementVisibility(GPUNumberField).click();
        return this;
    }

    public PricingCalculatorPage selectGPUNumber(){
        waitForElementVisibility(GPUNumberValue).click();
        return this;
    }
    public PricingCalculatorPage clickOnLocalSSD(){
        waitForElementVisibility(localSSDField).click();
        return this;
    }
    public void selectLocalSSD(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement LocalSSDValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        LocalSSDValue.click();
    }

    public PricingCalculatorPage addToEstimate(){
       waitForElementVisibility(addToEstimateField).click();
        return this;
    }

    public void emailEstimateClick(){
        waitForElementVisibility(emailEstimateButton).click();
}
    private WebElement waitForElementVisibility(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return locator;
    }
}
