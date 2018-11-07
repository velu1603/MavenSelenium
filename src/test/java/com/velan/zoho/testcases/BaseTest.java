package com.velan.zoho.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.log4testng.Logger;

import com.velan.zoho.ExtendListeners.ExtentListeners;
import com.velan.zoho.utilities.DriverFactory;
import com.velan.zoho.utilities.DriverManager;

public class BaseTest {

	private WebDriver driver;

	private Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseTest.class);
	
	public boolean grid=false;
	
	private String defaultUsername;
	private String defaultPassword;
	

	public String getDefaultUsername() {
		return defaultUsername;
	}






	public void setDefaultUsername(String defaultUsername) {
		this.defaultUsername = defaultUsername;
	}






	public String getDefaultPassword() {
		return defaultPassword;
	}






	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}






	@BeforeMethod
	public void setpUpFramework() {

		configureLogging();// intitate the logs

		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropetyFile(
				System.getProperty("user.dir") + "//src//test//resources//properties//config.properties");
		DriverFactory.setChromeDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//excecutables//chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(
				System.getProperty("user.dir") + "//src//test//resources//excecutables//geckodriver.exe");

		try {
			fis = new FileInputStream(DriverFactory.getConfigPropetyFile());
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

		try {
			config.load(fis);
			log.info("Configuration file loaded");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public void loginfo(String message) {
		
		
		ExtentListeners.testReport.get().info(message);
		
		
	}

	public void configureLogging() {

		String log4jConfigFile = System.getProperty("user.dir")+ "//src//test//resources//properties//log4j.properties";
		
		PropertyConfigurator.configure(log4jConfigFile);
	}

			
		public void openBrowser(String browser) {
			
			if(System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")) {
				
				grid=true;
			}


		DriverFactory.setRemote(grid);

		if (DriverFactory.isRemote()) {

			DesiredCapabilities cap = null;

			if (browser.equalsIgnoreCase("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equalsIgnoreCase("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equals("ie")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplorer");
				cap.setPlatform(Platform.WINDOWS);
			}

			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				log.info("Starting the session on Grid!!");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			if (browser.equals("chrome")) {

				System.out.println("Lunching  " + browser);

				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());

				driver = new ChromeDriver();
				log.info("Chrome browser launched !!");

			} else if (browser.equals("firefox")) {

				System.out.println("Lunching  " + browser);

				System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverExePath());

				driver = new FirefoxDriver();
				log.info("Firefox browser launched !!");


			}

		}

		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		setDefaultUsername(config.getProperty("defaultUserName"));
		setDefaultPassword(config.getProperty("defaultPassword"));
	}

	public void quit() {
		DriverManager.getDriver().quit();
	}

}
