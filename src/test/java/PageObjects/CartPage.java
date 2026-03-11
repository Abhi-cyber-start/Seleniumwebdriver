package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage 
{

    private By clickcart =By.linkText("Cart");
    private By cartTotalAmount = By.id("totalp");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) 
    {
        super(driver);
    }
    
    public void clickonCart() 
    {
    	click(clickcart);
    }
    
    public void waitForCartItems() 
    {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//tbody[@id='tbodyid']/tr"), 0));
    }

    public int getCartTotal() 
    {
        return Integer.parseInt(getText(cartTotalAmount));
    }

    public void clickPlaceOrder() 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        click(placeOrderBtn);
    }
}