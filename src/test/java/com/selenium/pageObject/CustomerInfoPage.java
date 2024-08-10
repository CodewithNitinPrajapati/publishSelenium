package com.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPage {
//	WebDriver ldriver;
//	
//	public CustomerInfoPage(WebDriver rdriver) {
//		ldriver = rdriver;
//		//PageFactory.initElements(rdriver, this);
//	}
	
	@FindBy(how=How.NAME,using="firstName")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how=How.NAME,using="lastName")
	@CacheLookup
	WebElement lastName;

	@FindBy(how=How.CSS,using="input[name='postalCode']")
	@CacheLookup
	WebElement postalCode;
	
	@FindBy(how=How.XPATH,using="//input[@name='continue']")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(how=How.ID , using= "cancel")  //cssSelector = ('button[id="checkout"]')
	@CacheLookup
	WebElement cancel;
	

	public void fillCustomerInfo(String firstname , String lastname , String zipCode) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(zipCode);
	}
	
	public void clickContinue() {
		btnContinue.click();
	}
	
	public void clickCancel() {
		cancel.click();
		System.out.println("order canceled ......!");
	}
	
	
	
	
	
//	public void setFirstName(String name ) {
//		firstName.sendKeys(name);
//	}
//	
//	public void setLastName(String name ) {
//		lastName.sendKeys(name);
//	}
//	
//	public void setZipCode(String zipCode) {
//		postalCode.sendKeys(zipCode);
//	}
	
	

}
