package com.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
//	WebDriver ldriver;
//	public YourCartPage(WebDriver rdriver) {
//		ldriver=rdriver;
//		//PageFactory.initElements(rdriver, this);
//	}
	
	@FindBy(how=How.CSS , using= "button[id=\'checkout\']")
	@CacheLookup
	WebElement checkOut;
	
	public void checkOut() {
		checkOut.click();
		
	}
}
