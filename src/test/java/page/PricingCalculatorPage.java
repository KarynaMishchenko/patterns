package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PricingCalculatorPage {
    protected WebDriver driver;

    public PricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterNumberOfInstances(String keyForNumberOfInstances) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement frameName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@name,'goog_')]")));
        driver.switchTo().frame(frameName);
        driver.switchTo().frame("myFrame");
        WebElement numberOfInstancesField = driver.findElement(By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']"));
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
    }
    public PricingCalculatorPage clickOnSeries(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement seriesField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='md-text ng-binding'])[1]")));
        seriesField.click();
        return this;
    }
    public WebElement whatAreThereInstances(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement theseInstancesField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input_101")));
        return theseInstancesField;
    }
    public void selectSeries(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement seriesValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[contains(@value, '" + value + "')]")));
        seriesValue.click();
    }
    public PricingCalculatorPage clickOnMachineType(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement machineTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='md-text ng-binding'])[2]")));
        machineTypeField.click();
        return this;
    }
    public void selectMachineType(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement machineTypeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        machineTypeValue.click();
    }
    public PricingCalculatorPage addGPU(){
        WebElement addGPU = driver.findElement(By.xpath("//*[contains(text(), 'Add GPUs')]"));
        addGPU.click();
        return this;
    }
    public PricingCalculatorPage clickOnGPUType(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GPUTypeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder='GPU type']")));
        GPUTypeField.click();
        return this;
    }

    public PricingCalculatorPage selectGPUType(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GPUTypeValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        GPUTypeValue.click();
        return this;
    }
    public PricingCalculatorPage clickOnGPUNumbers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GPUNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder='Number of GPUs']")));
        GPUNumberField.click();
        return this;
    }

    public PricingCalculatorPage selectGPUNumber(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement GPUNumberValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select_option_520")));
        GPUNumberValue.click();
        return this;
    }
    public PricingCalculatorPage clickOnLocalSSD(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement localSSDField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='md-text ng-binding'])[12]")));
        localSSDField.click();
        return this;
    }
    public void selectLocalSSD(String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement LocalSSDValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" +  value + "')]")));
        LocalSSDValue.click();
    }

    public PricingCalculatorPage clickOnDatacenter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement DatacenterField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='md-text ng-binding'])[13]")));
        DatacenterField.click();
        return this;
    }

    public void selectDatacenter(){
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement LocalSSDValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select_option_338")));
        LocalSSDValue.click();
    }

    public PricingCalculatorPage clickOnCommittedUsage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement DatacenterField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-select[@placeholder='Committed usage']")));
        DatacenterField.click();
        return this;
    }
    public void selectCommittedUsage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement committedUsageValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-option[@ng-value = '1']")));
        committedUsageValue.click();
    }
    public PricingCalculatorPage addToEstimate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToEstimateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple'])[1]")));
        addToEstimateField.click();
        return this;
    }

    public void emailEstimateClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement emailEstimateButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='google-symbols ng-scope'])[47]")));
        emailEstimateButton.click();
}
}
