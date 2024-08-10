package com.selenium.pageObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

public class HomePage extends AbstractContent {

	//WebDriver ldriver;

	public HomePage(WebDriver rdriver) {
		super(rdriver);
		//ldriver = rdriver;
		//PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = " //div[@class='inventory_item']")
	@CacheLookup
	List<WebElement> wholeProduct;

	@FindBy(how = How.XPATH, using = "//div[@class='inventory_item_name']")
	@CacheLookup
	List<WebElement> products;

	@FindBy(how = How.XPATH, using = "//button[@class=\'btn btn_primary btn_small btn_inventory\']")
	@CacheLookup
	List<WebElement> addToCardItems;

	@FindBy(how = How.XPATH, using = "//button[@class=\'btn btn_secondary btn_small btn_inventory\']")
	@CacheLookup
	List<WebElement> removeToCardItems;

	@FindBy(how = How.XPATH, using = "//div[@class=\"inventory_item_price\"]")
	@CacheLookup
	List<WebElement> price;

	@FindBy(how = How.CSS, using = ".product_sort_container")
	@CacheLookup
	WebElement filter;

	public void addProduct(String[] list) {
		List itemNestedList = Arrays.asList(list);
		for (int i = 0; i < products.size(); i++) {
			String formattedName = products.get(i).getText();
			if (itemNestedList.contains(formattedName)) {
				addToCardItems.get(i).click();
				System.out.println(formattedName + " ******* has added successfully....!");
			}
		}
	}

	public void removeProduct(List removedProduct) {
		for (int i = 0; i < products.size(); i++) {
			String formattedName = products.get(i).getText();
			if (removedProduct.contains(formattedName)) {
				removeToCardItems.get(i).click();
				System.out.println(formattedName + " ******* has removed successfully....!");
			}
		}
	}

	public boolean comparePrice() {
		List<Float> prices = getSortedList();
		List<Float> sortedPrice = new ArrayList<Float>(prices);
		Collections.sort(sortedPrice);
		if (sortedPrice.equals(prices)) {
			return true;
		} else {
			return false;
		}
	}

	public void orderCheapestItem() {
		List<Float> priceList = getSortedList();
		for (int i = 0; i < wholeProduct.size(); i++) {
			String val = wholeProduct.get(i).findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
			Float res = Float.parseFloat(val.split("\\$")[1]);
			if (res.equals(priceList.get(i))) {
				wholeProduct.get(i).findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"))
						.click();
				System.out.println(wholeProduct.get(i).getText());
				break;
			}

		}
	}

	public List<Float> getSortedList() {
		Select select = new Select(filter);
		select.selectByVisibleText("Price (low to high)");
		List<Float> prices = new ArrayList<Float>();
		for (WebElement e : price) {
			prices.add(Float.parseFloat(e.getText().split("\\$")[1]));
		}
		return prices;
	}

}
