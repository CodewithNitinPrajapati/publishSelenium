package com.selenium.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AbstractContent {
	
	WebDriver driver;
	
	public AbstractContent(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.XPATH , using = "//input[@placeholder=\"Username\"]")
	@CacheLookup
	WebElement username;
	
	@FindBy(how = How.XPATH , using = "//input[@type=\'password\']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how = How.XPATH , using = "//input[@type=\'submit\']")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(how=How.XPATH,using="//footer/ul/li[3]")
	@CacheLookup
	WebElement linkDin;
	
	@FindBy(how=How.XPATH, using="//footer/div")
	@CacheLookup
	WebElement footerText;
	
	@FindBy(how = How.LINK_TEXT, using = "About")
	@CacheLookup
	WebElement aboutLink;
	
	@FindBy(how = How.XPATH, using = "//a[@class=\'shopping_cart_link\']")
	@CacheLookup
	WebElement cartIcon;
	
	@FindBy(how = How.CSS, using = "button#react-burger-menu-btn")
	@CacheLookup
	WebElement hamburger;
	
	@FindBy(how = How.CSS, using = "body > div:nth-child(2) > header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4)")
	@CacheLookup
	WebElement resources;
	
	@FindBy(how=How.CSS , using="body > div:nth-child(2) > header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
	@CacheLookup
	WebElement document;
	
	public void goToCart() {
		cartIcon.click();
	}
	
	public void hamburger() {
		hamburger.click();
	}
	
	public void about(){
		aboutLink.click();
		String windowHandle = driver.getWindowHandle();
		Actions actions = new Actions(driver);
		driver.switchTo().window(windowHandle);
		actions.moveToElement(resources).perform();
		document.click();
		System.out.println("documentation successfully.....!");
	}
	
	public void openAboutNewTab() {
		String windowHandle = driver.getWindowHandle();
		aboutLink.sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN)); 
		System.out.println("documentation open successfully.....!");
	}
	
	
	public void getFooterText() {
		System.out.println(footerText.getText());
	}
	
	
	public void linkDin() {
		linkDin.click();
		System.out.println("clicked on linkdin successfull........!");
	}
	
	
}
