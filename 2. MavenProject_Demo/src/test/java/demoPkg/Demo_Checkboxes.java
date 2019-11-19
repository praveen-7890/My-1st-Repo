package demoPkg;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class Demo_Checkboxes extends Utilities{

	@AfterClass
	public void CloseBrowser(){
		teardown();
	}

	@Test(priority=1)
	public static void met1() throws Exception
	{
		/*try{

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"./Drivers/chromedriver41.exe");
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("useAutomationExtension", false);
			cOptions.addArguments("start-maximized");
			cOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(cOptions);
			//driver.manage().window().maximize();
			Thread.sleep(3000L);
			driver.get("//https://www.toolsqa.com/selenium-webdriver/checkbox-radio-button-operations/");
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}*/

		initialize();
		openBrowser(prop.getProperty("browser"));
		Thread.sleep(1000L);
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(2000L);
		System.out.println(" browser opened & navigated to the url");

		click("//*[@id='tool-0']", "1st checkbox");
		Thread.sleep(1000L);
		Boolean b = driver.findElement(By.xpath("//*[@id='tool-0']")).isEnabled();

		if(b){
			System.out.println("Enabled");
		}else{
			System.out.println("Not Enabled");
		}
		click("//*[@id='tool-1']", "2nd Radio");
		Thread.sleep(1000L);

	}

















}
