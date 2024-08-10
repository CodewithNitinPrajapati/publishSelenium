package com.selenium.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
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
	
	public void login(String userName , String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		btnsubmit.click();
	}
	
//	public void setUsername(String name) {
//		//System.out.println(username.getText() + "this is username");
//		username.sendKeys(name);
//	}
//	public void setPassword(String pass) {
//		password.sendKeys(pass);
//	}
//	public void clickBtn() {
//		btnsubmit.click();
//	}


}
