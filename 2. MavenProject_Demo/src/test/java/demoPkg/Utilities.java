package demoPkg;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**initialize
 * openBrowser
 * teardown
 * click
 *
 *
 *
 *	File file = new File("/path");
	InputStream ips = new FileInputStream(file);
	Properties prop = new Properties();
	prop.load(ips);

 */


public class Utilities {

	public static WebDriver 	driver 	= null;
	public static WebDriverWait wait 	;
	// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("some id")));
	public static WebElement 	ele		= null;
	public static File 			file 	= new File("./config.properties");
	public static InputStream 	ips		;
	public static Properties 	prop	= new Properties(); 
	public static Select 		sel		= null;
	public static Alert 		alert	= null;			

	public static String folderName 	= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	public static String fileName 		= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss'.html'").format(new Date());





	public static void tt(){
		System.out.println("folder Name is : "+folderName);
		System.out.println("file Name is: "+fileName);
	}


	public static void initialize()
	{	
		try{
			ips = new FileInputStream(file);
			prop.load(ips);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void openBrowser(String browser, String url) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"./Drivers/chromedriver41.exe");
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("useAutomationExtension", false);
			cOptions.addArguments("start-maximized");
			cOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(cOptions);
			driver.manage().window().maximize();
			Thread.sleep(3000L);
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			/*	WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("--start-maximized");			
			driver = new FirefoxDriver(foptions);*/
			System.setProperty("webdriver.gecko.driver","D:\\AUTOMATION\\2. MavenProject_Demo\\Drivers\\geckodriver.exe");	
			/*DesiredCapabilities capabilities = DesiredCapabilities.firefox();  
            capabilities.setCapability("marionette",true); */
			
			WebDriver driver = new FirefoxDriver();
			//driver = new FirefoxDriver();			
			Thread.sleep(3000L);
			driver.manage().window().maximize();
			driver.get("https://www.google.co.in/");
		}
		else 
		{
			System.out.println("This browser is not supported.");
		}		
		System.out.println(browser+" browser is opened & passed url: "+url);
		Thread.sleep(2000L);

	}

	public static void teardown()
	{
		driver.close();
		//driver.quit();
		System.out.println("Browser closed");
	}


	public static void openBrowser(String browserName) throws Exception
	{
		if(browserName.trim().equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"./Drivers/chromedriver41.exe");
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.setExperimentalOption("useAutomationExtension", false);
			cOptions.addArguments("start-maximized");
			cOptions.addArguments("disable-infobars");

			driver = new ChromeDriver(cOptions);
		}
		else if(browserName.trim().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.trim().equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		else {
			System.out.println("This browser is not supported.");
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

	}




	public static WebElement click(String xpath, String elem)
	{

		try {
			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			ele = driver.findElement(By.xpath(xpath));
			ele.click();
			System.out.println("Clicked "+elem);

		} catch (Exception e) {
			System.out.println("Failed to click on element: "+elem);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			e.printStackTrace();			
		}
		return ele;


	}

	public void scrollIntoView(String xpath,String elementName)
	{
		try {
			//ewait(xpath);
			WebElement element = driver.findElement(By.xpath(xpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			//logger.log(LogStatus.INFO, elementName+" should be scrolled into view", elementName+" is scrolled into view");
			System.out.println("Scrolled into view");
		} catch (Exception e) {
			//logger.log(LogStatus.WARNING, "exception while scrolling "+elementName+" into view is due to <br/>"+e, logger.addScreenCapture(tearDown(driver)));
			System.out.println("NOT Scrolled into view");
		}
	}



























}
