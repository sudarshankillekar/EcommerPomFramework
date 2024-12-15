package com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtility;

public class CheckOutPage extends BrowserUtility {
  
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
	private static final By clickOnPlaceorder  =  By.xpath("//a[normalize-space()='Place Order']");
	private static final By sselectCountry = By.xpath("(//button[@class=\"ta-item list-group-item ng-star-inserted\"])[2]");
	//private static final By sselectCountry = By.xpath("(//button[@class=\"ta-item list-group-item ng-star-inserted\"])[2]");
	
	@FindBy(xpath =  "//input[@placeholder=\"Select Country\"]")
	WebElement Country;
	
	@FindBy(xpath = "//button[@class=\"ta-item list-group-item ng-star-inserted\"])[2]")
	WebElement selectcountry;
	
	@FindBy(css = ".action__submit")
	WebElement Submit;
	
	public void selectCountry(String country) {
	
		  Actions a = new Actions(driver); 
	      a.sendKeys(Country, country).build().perform();
	      waitForElementToAppear(sselectCountry);
	      clickOn(sselectCountry);
	}
	 
	public confirmationPage submitOrder() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0,450)");
		
		clickOn(clickOnPlaceorder);
		 return new confirmationPage(driver);
	}
	

	
	
}
