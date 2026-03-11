package PageObjects;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BasePage 
{

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator) 
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String value) 
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
            .sendKeys(value);
    }

    protected String getText(By locator) 
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
            .getText();
    }

    protected void acceptAlert() 
    {
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }
}