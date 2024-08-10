package com.selenium.testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.selenium.pageObject.CustomerInfoPage;
import com.selenium.pageObject.HomePage;
import com.selenium.pageObject.LoginPage;
import com.selenium.pageObject.ReviewPage;
import com.selenium.pageObject.YourCartPage;
import com.selenium.utilities.ReadConfigFile;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest extends ReadConfigFile{
	public String baseUrl = prop.getProperty("url");
	public String browser = prop.getProperty("browser");
	public static WebDriver driver; // need to use window handle
	

	public void invoke() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		}
		
		driver.navigate().to(baseUrl);	
	}

	

}
