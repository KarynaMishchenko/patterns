package page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    protected WebDriver driver;
    private By searchButton  = By.cssSelector("div.KKOy5d");
    private By searchBar = By.cssSelector("[id='i5']");
    private By calculatorResult = By.xpath("(//a[@track-name='google cloud pricing calculator'])[2]");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage openGoogleCloud(){
        driver.get("https://cloud.google.com/");
        return this;
    }
    public void clickOnSearch(){
        WebElement button = waitForElementVisibility(searchButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().perform();
    }
    public HomePage enterTextInSearchBar(String string){
        waitForElementVisibility(searchBar);
        driver.findElement(searchBar).sendKeys(string);
        return this;
    }
    public void submitSearch(){
        waitForElementVisibility(searchBar);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }
    public void selectCalculator(){
        WebElement calculator = waitForElementVisibility(calculatorResult);
        Actions actions = new Actions(driver);
        actions.moveToElement(calculator).click().perform();
    }

    private WebElement waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
