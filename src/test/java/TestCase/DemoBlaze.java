package TestCase;

import java.util.List;

import org.testng.Assert;

import org.testng.annotations.Test;

import PageObjects.*;

public class DemoBlaze extends BaseTest 
{

	@Test
	public void verifyDemoblazeEndToEndFlow() throws InterruptedException 
	{

     
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.verifyTitleContainsStore());

        
        home.selectCategory(prop.getProperty("expcategory"));
   

        
       CategoryPage categoryPage = new CategoryPage(driver);
       List<Integer> prices = categoryPage.captureAllPrices();
        
        Assert.assertFalse(prices.isEmpty());

        
       categoryPage.calculateStatistics(prices);

        
        int selectedPrice = categoryPage.selectSecondMostExpensiveProduct();
        System.out.println("secondmostexpensiveproduct:--"+selectedPrice);

       
        ProductPage product = new ProductPage(driver);
        product.addProductToCart();

        
       CartPage cart = new CartPage(driver);
        cart.clickonCart();
        cart.waitForCartItems();
        cart.clickPlaceOrder();

        
        OrderPage order = new OrderPage(driver);
        order.fillOrderDetailsWithRandomData();
        order.clickPurchase();
       

        Assert.assertTrue(order.getConfirmationMessage().contains("Thank you for your purchase!"));

        Assert.assertEquals(order.getConfirmationAmount(),cart.getCartTotal());
    }
	
}
