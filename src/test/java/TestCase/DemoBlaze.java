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
		// Initialize Home Page object
        HomePage home = new HomePage(driver);
        
        // Verify the page title contains "STORE" 
        Assert.assertTrue(home.verifyTitleContainsStore());
        
        //select category from properties file 
        home.selectCategory(prop.getProperty("expcategory"));
        
        // Initialize Category Page and capture all product prices
       CategoryPage categoryPage = new CategoryPage(driver);
       List<Integer> prices = categoryPage.captureAllPrices(); 
       
         // Validate that prices list is not empty
        Assert.assertFalse(prices.isEmpty());
        
        // Calculate and print statistics (Total, Avg, Min, Max)
       categoryPage.calculateStatistics(prices);
       
         // Select the second most expensive product
        int selectedPrice = categoryPage.selectSecondMostExpensiveProduct();
        System.out.println("secondmostexpensiveproduct:--"+selectedPrice);
        
         // Initialize Product Page and add the product to cart
        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        
         // Navigate to Cart page , waits for items and click place order btn
        CartPage cart = new CartPage(driver);
         cart.clickonCart();
         cart.waitForCartItems();
         cart.clickPlaceOrder();
        
         // Fill order form with random user details and click purchase btn
        OrderPage order = new OrderPage(driver);
        order.fillOrderDetailsWithRandomData();
        order.clickPurchase();
        
         //  Verify confirmation message
        Assert.assertTrue(order.getConfirmationMessage().contains("Thank you for your purchase!"));
        
         // Verify order amount matches cart total
        Assert.assertEquals(order.getConfirmationAmount(),cart.getCartTotal());
    }
	
}
