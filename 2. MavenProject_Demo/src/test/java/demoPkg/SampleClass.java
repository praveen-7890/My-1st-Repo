package demoPkg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SampleClass extends Utilities{

	@BeforeClass
	public void demo() throws Exception
	{
		initialize();
		openBrowser(prop.getProperty("browser"), prop.getProperty("URL").trim());
	}
	
	@AfterClass
	public void tearDown1()
	{
		teardown();
	}

	@Test
	public static void Search_Cucumber() throws Exception
	{
		System.out.println("hello world");
		driver.findElement(By.name("q")).sendKeys("cucumber");
		Thread.sleep(1000L);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(3000L);
		System.out.println("Search done, Browser closed");
	}

	@Test
	public void dd(){
		tt();
	}





























}
