package demoPkg;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo_SelectTag extends Utilities{	
	
	@BeforeClass
	public void BeforeClass() throws Exception
	{		
		initialize();
		openBrowser(prop.getProperty("browser"));
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(2000L);
		System.out.println(" browser opened & navigated to the url");
	}
	

	@AfterClass
	public void CloseBrowser(){
		teardown();
	}
	
	@Test
	public void Test1() throws Exception
	{
		sel = new Select(driver.findElement(By.xpath("//*[@id='continents']")));
		sel.selectByVisibleText("Australia");
		Thread.sleep(1000L);
		sel.selectByIndex(1);
		
		ele = sel.getFirstSelectedOption();
		System.out.println("Selected option is: "+ele.getText());
		
		List<WebElement> list = sel.getOptions();		
		for(WebElement wel:list)
		{
			String option = wel.getText();
			System.out.println("Options are: "+option);
		}
		
		// 
		sel = new Select(driver.findElement(By.xpath("//*[@id='selenium_commands']")));
		sel.selectByIndex(1);
		Thread.sleep(1000L);
		sel.deselectByIndex(1);
		Thread.sleep(1000L);
		System.out.println("deselected");
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
