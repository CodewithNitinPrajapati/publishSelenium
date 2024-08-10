package com.selenium.testcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pageObject.AbstractContent;
import com.selenium.pageObject.CustomerInfoPage;
import com.selenium.pageObject.HomePage;
import com.selenium.pageObject.LoginPage;
import com.selenium.pageObject.ReviewPage;
import com.selenium.pageObject.YourCartPage;
import com.selenium.utilities.DataProviders;
import com.selenium.utilities.ReadConfigFile;

public class TC_PlaceOrder_001 extends BaseTest{
 	
 	public String[] productForRemove = {"Sauce Labs Backpack"};
 	List removedProduct = Arrays.asList(productForRemove);
 	
 	String firstName = "nitin";
 	String lastName = "prajapati";
 	String zipCode =  "462030";	
 	
 	HomePage homePage;
	CustomerInfoPage customerInfoPage;
	ReviewPage reviewPage;
	YourCartPage yourCartPage;
	AbstractContent abstractContent;
	LoginPage loginPage;
 	
 	@BeforeMethod
 	public void setUp() {
 		invoke();
		homePage = PageFactory.initElements(driver, HomePage.class);
		customerInfoPage = PageFactory.initElements(driver, CustomerInfoPage.class);
		reviewPage = PageFactory.initElements(driver, ReviewPage.class);
		yourCartPage = PageFactory.initElements(driver, YourCartPage.class);
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		//abstractContent = PageFactory.initElements(driver, AbstractContent.class);
		loginPage.login(ReadConfigFile.prop.getProperty("username") , ReadConfigFile.prop.getProperty("password"));
 	}
 	
	@Test(priority = 0 , dataProvider = "AddProduct" , dataProviderClass = DataProviders.class)
	public void placeOrder(String[] product) {
		homePage.addProduct(product);
		homePage.goToCart();
		yourCartPage.checkOut();
		customerInfoPage.fillCustomerInfo(firstName, lastName, zipCode);
		customerInfoPage.clickContinue();
		reviewPage.placeOrder();
	}
	
	@Test(priority = 1 ,dataProvider = "AddProduct" , dataProviderClass = DataProviders.class)
	public void cancelOrderBeforePlace(String[] product) {
		homePage.addProduct(product);
		homePage.goToCart();
		yourCartPage.checkOut();
		customerInfoPage.fillCustomerInfo(firstName, lastName, zipCode);
		customerInfoPage.clickContinue();
		customerInfoPage.clickCancel();
	}
	
	@Test(priority = 2 ,dataProvider = "AddProduct" , dataProviderClass = DataProviders.class)
	public void addAndRemoveProduct(String [] product) {
		homePage.addProduct(product);
		homePage.removeProduct(removedProduct);
		homePage.goToCart();
		yourCartPage.checkOut();
		customerInfoPage.fillCustomerInfo(firstName, lastName, zipCode);
		customerInfoPage.clickContinue();
		reviewPage.placeOrder();
	}
	
	@Test(priority = 3)
	public void openDocumentation() {
		homePage.hamburger();
		homePage.about();
	}
	
	@Test(priority = 4)
	public void aboutNewTab() {
		homePage.hamburger();
		homePage.openAboutNewTab();
	}
	
	@Test(priority = 5)
	public void linkDinClick() {
		homePage.linkDin();
	}
	
	@Test(priority = 6)
	public void footerText() {
		homePage.getFooterText();
	}
	
	@Test(priority = 7)
	public void leastItem() {
		homePage.orderCheapestItem();
		homePage.goToCart();
		yourCartPage.checkOut();
		customerInfoPage.fillCustomerInfo(firstName, lastName, zipCode);
		customerInfoPage.clickContinue();
		reviewPage.placeOrder();	
	}
	
	@Test(priority = 8)
	public void lowToHigh() {
		Assert.assertTrue(homePage.comparePrice() , "test case failed");	
		System.out.println("price are sorted...");
	}
	

}
