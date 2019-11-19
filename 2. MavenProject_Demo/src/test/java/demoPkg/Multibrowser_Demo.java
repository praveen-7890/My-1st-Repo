package demoPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Multibrowser_Demo extends Utilities{

	@Parameters("browserName")
	@BeforeClass
	public void Setup(String browserName) throws Exception
	{
		initialize();
		openBrowser(browserName);
	}	
	
	@AfterClass
	public void tearDown1()
	{
		teardown();
	}

	@Test
	public static void Search_Cucumber() throws Exception
	{
		
		driver.findElement(By.name("q")).sendKeys("cucumber");
		Thread.sleep(1000L);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(3000L);
		System.out.println("Search done, Browser closed");

	}

	
	
	
}
