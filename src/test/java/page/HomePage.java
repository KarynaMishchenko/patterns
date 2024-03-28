package page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class HomePage {
    protected WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage openGoogleCloud(){
            driver.get("https://cloud.google.com/");
            return this;
    }
    public void clickOnSearch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.KKOy5d")));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchButton).click().perform();
    }
    public HomePage enterTestInSearchBar(String string){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='i5']")));
        searchBar.sendKeys(string);
        return this;
    }
    public void submitSearch(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='i5']")));
        // Press Enter key to submit the search
        searchBar.sendKeys(Keys.ENTER);
    }
    public void selectCalculator(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement calculatorResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@track-name='google cloud pricing calculator'])[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(calculatorResult).click().perform();
    }
}
