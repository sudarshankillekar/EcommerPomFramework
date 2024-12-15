package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utils.BrowserUtility;

public class confirmationPage extends BrowserUtility {

	WebDriver driver;
	
	public confirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}

	private static final By elementpresent = By.cssSelector(".hero-primary");
	
	@FindBy(css = ".hero-primary")
	WebElement elepresent;
	
	
	public String verifyiforderplcaed() {
		 waitForElementToAppear(elementpresent);
		 return elepresent.getText();
		
	}
	
	 
	
}	

