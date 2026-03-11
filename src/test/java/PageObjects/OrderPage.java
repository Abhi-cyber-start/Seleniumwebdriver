package PageObjects;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderPage extends BasePage 
{

    private By name=By.xpath("//input[@id='name']");
    private By country= By.xpath("//input[@id='city']");
    private By city= By.xpath("//input[@id='city']");
    private By card= By.xpath("//input[@id='card']");
    private By month=By.xpath("//input[@id='month']");
    private By year=By.xpath("//input[@id='year']");
    private By purchaseBtn=By.xpath("//button[text()='Purchase']");
    private By confirmationMsg=By.xpath("//*[text()='Thank you for your purchase!']");
    private By confirmationAmount=By.xpath("//p[@class='lead text-muted ']"); 

    public OrderPage(WebDriver driver) 
    {
        super(driver);
    }

    // Step 16
    public void fillOrderDetailsWithRandomData() 
    {

        type(name, "User_" + UUID.randomUUID().toString().substring(0, 5));
        type(country, "User_" + UUID.randomUUID().toString().substring(0, 5));
        type(city, "User_" + UUID.randomUUID().toString().substring(0, 5));
        type(card, String.valueOf(System.currentTimeMillis()).substring(0, 10));
        type(month, "3");
        type(year, "2026");
    }

    public void clickPurchase() 
    {
        click(purchaseBtn);
    }

    public String getConfirmationMessage() 
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg));
        return driver.findElement(confirmationMsg).getText();
    }

    public int getConfirmationAmount() 
    {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationAmount));
        String text = getText(confirmationAmount);

        return Integer.parseInt(text.split("Amount: ")[1].split(" ")[0]);
    }
  
}

