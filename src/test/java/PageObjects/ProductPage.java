package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage 
{
    private By addToCartBtn = By.xpath("//*[@class='btn btn-success btn-lg']");

    public ProductPage(WebDriver driver) 
    {
        super(driver);
    }

    public void addProductToCart() 
    {
        click(addToCartBtn);
        acceptAlert();
    }
}
