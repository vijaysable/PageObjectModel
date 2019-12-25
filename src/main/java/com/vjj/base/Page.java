package com.vjj.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.vj.Utilities.CaptureScreenshot;
import com.vj.Utilities.ExcelReader;

public class Page {

	public static WebDriver driver;
	public static TopMenu menu; // topmenu will also be common throughout all the pages,so instead of
								// initializing it on every page we can initialize it here
	public static String browser;
	public static WebDriverWait wait;
	/*
	 * implementing the same data driven framework here
	 */
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			"C:\\Users\\Hole\\Desktop\\Vijay\\Eclipse\\PageObjectModelBasics\\src\\test\\resources\\com\\vjj\\excel\\Excel1.xlsx");
	//public static ExtentReports rep = ExtentManager.getInstance(filename);
	
	public Page() {

		if (driver == null) { // static will hold the value of the first time and this will validate if it is
								// not null then continue with the same driver
			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\vjj\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("Config file loaded");

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\vjj\\properties\\ObjectRepositories.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("OR file loaded");
			
			// for jenkins browser filter config
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
				
				browser = System.getenv("browser");
				
			} else {
				
				browser = Config.getProperty("browser");
				
			} Config.setProperty("browser", browser);
			

			if (Config.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.firefox.driver",
						"C:\\Users\\Hole\\Desktop\\Vijay\\Selenium Grid\\geckodriver.exe");
				driver = new FirefoxDriver();
				log.debug("Firefox Launched");

			} else if (Config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\vjj\\executables\\chromedriver.exe");
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");
				driver = new ChromeDriver(options);
				menu = new TopMenu(driver);
				log.debug("Chrome Launched");

			}
			
			driver.get(Config.getProperty("testsiteurl"));
			log.debug("Navigated to: " + Config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			//menu = new TopMenu(driver);
			
			
			
			/*
			 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
			 * + "\\src\\test\\resources\\com\\vjj\\executables\\chromedriver.exe");
			 * 
			 * Map<String, Object> prefs = new HashMap<String, Object>();
			 * prefs.put("profile.default_content_setting_values.notifications", 2);
			 * prefs.put("credentials_enable_service", false);
			 * prefs.put("profile.password_manager_enabled", false); ChromeOptions options =
			 * new ChromeOptions(); options.setExperimentalOption("prefs", prefs);
			 * options.addArguments("--disable-extensions");
			 * options.addArguments("--disable-infobars");
			 * 
			 * driver = new ChromeDriver(options); driver.get("http://zoho.com");
			 * driver.manage().window().maximize();
			 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); menu = new
			 * TopMenu(driver);
			 */
		}
	}
	
	public static void wait(By by) {
		
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	public static void click(String locator) {

		// making it more dynamic

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		log.debug("clicking on an element: " +locator);
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		log.debug("Typing in an element: " +locator+" as Value: "+value);
	}
	
	public static void verifyEquals(String expectedResult, String actualResult) throws IOException {
		
		try {
			Assert.assertEquals(actualResult, expectedResult);
			
		} catch (Exception e) {
			
			// for reportng
			org.testng.Reporter.log("<br>"+"Verification of failure: "+e.getMessage()+"<br>");
			CaptureScreenshot cap = new CaptureScreenshot();
			cap.capscreen();
			org.testng.Reporter.log("<br>");
			org.testng.Reporter.log("<br>");
			
			//for extent reports
			
			
		}
		
	}
	
	// for dropdowns
	static WebElement dropdown;
	public void select(String locator, String value) {
		
		if (locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		log.debug("Selecting from an element : "+locator+" value as : "+value);
	}
	
	public static void quit() {
		
		//driver.quit();
	}


	public static void main(String[] args) {

	}

}
