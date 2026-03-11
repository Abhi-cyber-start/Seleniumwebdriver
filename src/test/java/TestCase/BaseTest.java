package TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest 
{

    protected WebDriver driver;
    protected Properties prop;

    @BeforeMethod
    @Parameters({"browser"})
	public void setup(String br) throws InterruptedException, IOException 
	{

        prop = new Properties();
        prop.load(new FileInputStream("./src/test/resources/properties"));  //  ./ represents current project)
        
        switch(br.toLowerCase())
		{ 
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" :  driver=new EdgeDriver(); break;
		default :System.out.println("invaild broweser name..");return;
		}

        //driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(prop.getProperty("url"));
    }

    public void takeScreenshot(String testName) 
    {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try 
        {
            FileUtils.copyFile(src, new File("Screenshots/" + testName + ".png"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    @AfterMethod
    public void captureFailure(ITestResult result) 
    {
    	if (result.getStatus() == ITestResult.FAILURE) 
    	{
              takeScreenshot(result.getName());

        }
    }
    
    @AfterMethod
    public void tearDown() 
    {
        if (driver != null) 
        {
            driver.quit();
        }
    }
}