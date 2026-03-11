package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class HomePage extends BasePage 
{

    
    private By phonesLink   =By.linkText("Phones"); //can also use xpath("//*[contains(text(),'Phones')]")
    private By laptopsLink  = By.linkText("Laptops"); //can also use xpath("//*[contains(text(),'Laptops')]")
    private By monitorsLink = By.linkText("Monitors"); //can also use xpath("//*[contains(text(),'Monitors')]")

    public HomePage(WebDriver driver) 
    {
        super(driver);
    }

    
    public boolean verifyTitleContainsStore() 
    {
        return driver.getTitle().contains("STORE");
    }

    
    public void selectCategory(String category) 
    {
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cat")));
        if (category.equalsIgnoreCase("Phones")) 
        {
            click(phonesLink);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung galaxy s6")));
        } 
        else if (category.equalsIgnoreCase("laptops")) 
        {
              click(laptopsLink);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sony vaio i5")));
            
        }
        else if (category.equalsIgnoreCase("Monitors")) 
        {
            click(monitorsLink);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple monitor 24")));
        }
    }
}