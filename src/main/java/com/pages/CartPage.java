package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtility;

public class CartPage extends BrowserUtility {
  WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}

	@FindBy(xpath = "//div[@class=\"cartSection\"]/h3")
	List<WebElement> ProductListInCart;
	
	private static final By checkoutelement  = By.xpath( "//li[@class=\"totalRow\"]/button");
	
	
	@FindBy(xpath = "//li[@class=\"totalRow\"]/button")
	WebElement Checkout;
	
	public boolean verifyProductDisplayed(String productName ) {
		List<WebElement>ProductListInCart =   driver.findElements(By.xpath("//div[@class=\"cartSection\"]/h3"));   
	    Boolean match =   ProductListInCart.stream().anyMatch(cartlist -> cartlist.getText().equalsIgnoreCase(productName));
	    return match;
	}
	
	public CheckOutPage clickOnCheckOutPage() {
		waitForElementToAppear(checkoutelement);
		Checkout.click();
		return new CheckOutPage(driver);
	}
	
   
	
}
