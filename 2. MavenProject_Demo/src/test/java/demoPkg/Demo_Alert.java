package demoPkg;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo_Alert extends Utilities{
	
	public static Alert alert;
	

	@BeforeClass
	public void BeforeClass() throws Exception
	{		
		initialize();
		openBrowser(prop.getProperty("browser"));
		driver.get("file:///C:/Users/pbukkapatnam/Desktop/demo.htm");
		Thread.sleep(2000L);
		System.out.println("Browser opened & navigated to the url");
	}
	

	@AfterClass
	public void CloseBrowser(){
		teardown();
	}
	
	@Test
	public void Test1() throws Exception
	{
		
		
		click("//*[@id='selectTable']/tbody/tr[2]/td/button", " alert");
		alert = driver.switchTo().alert();
		Thread.sleep(1000L);
		alert.accept();		
		System.out.println(" Alert accepted");
		
		click("//*[@id='selectTable']/tbody/tr[2]/td/button", " alert");		
		Thread.sleep(1000L);
		alert.dismiss();;		
		System.out.println(" Alert dismissed");		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
