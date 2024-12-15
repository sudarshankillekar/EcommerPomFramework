package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtility;

public class LandingPage extends BrowserUtility {

	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
    
	private static final By invalidToastMessage = By.xpath("//div[contains(text(),\" Incorrect email or password. \")]");
	
	@FindBy(id = "userEmail")
    WebElement emailAddress;
	
	@FindBy(id = "userPassword")
    WebElement Password;
	
	@FindBy(id = "login")
    WebElement login;
	
	public  productCatalogePage  loginWithUserIdPassWord(String email,String password) {
		emailAddress.sendKeys(email);
		Password.sendKeys(password);
		login.click();
		return new productCatalogePage(driver);
	}
	
	public String getErrorToastMessage() {
		waitForElementToAppear(invalidToastMessage);
		return getvisibleText(invalidToastMessage);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
