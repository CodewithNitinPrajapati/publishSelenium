package com.selenium.pageObject;

import javax.annotation.CheckForNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {
//	WebDriver ldriver;
//	
//	public ReviewPage(WebDriver rdriver) {
//		ldriver =  rdriver;
//		//PageFactory.initElements(rdriver, this);
//	}
	
	@FindBy(how=How.XPATH , using="//button[@id='finish']")
	@CacheLookup
	WebElement finish;
	
	public void placeOrder() {
		finish.click();
		System.out.println("place order successfully.....!");
	}
	
	

}
