package PageObjects;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoryPage extends BasePage 
 {  
    private By productCards = By.cssSelector(".card-block");
    private By productName  = By.cssSelector(".card-title");
    private By productPrice = By.cssSelector("h5");

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    // Step 4 & 5
    public List<Integer> captureAllPrices() 
    {
    	// Wait for products to load
    	wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productCards, 1));

        List<Integer> prices = new ArrayList<>();

        for (WebElement card : driver.findElements(productCards)) 
           {
            String priceText = card.findElement(productPrice).getText();
            prices.add(Integer.parseInt(priceText.replace("$", "")));
           }
        return prices;
    }

    // Step 6
    public void calculateStatistics(List<Integer> prices) 
    {

        int total = prices.stream().mapToInt(i -> i).sum();
        int min = Collections.min(prices);
        int max = Collections.max(prices);
        int avg = total / prices.size();
       
        
        System.out.println("Total Price: " + total);
        System.out.println("Average price: " + avg);
        System.out.println("Minimum price: " + min);
        System.out.println("Maximum price: " + max);
    }

    public int selectSecondMostExpensiveProduct() 
    {
      
    	 // Wait for products to load
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productCards, 1));
        
        List<WebElement> cards = driver.findElements(productCards);
        List<Integer> prices = new ArrayList<>();

        for (WebElement card : cards) 
        {
            int price = Integer.parseInt(card.findElement(productPrice).getText().replace("$", ""));
            prices.add(price);
        }

        prices.sort(Collections.reverseOrder());

        int secondHighest = prices.get(1);

        for (WebElement card : cards) 
        {
            int price = Integer.parseInt(card.findElement(productPrice).getText().replace("$", ""));
            if (price == secondHighest) 
               {
                card.findElement(productName).click();
                break;
               }
        }

        return secondHighest;
    }
}