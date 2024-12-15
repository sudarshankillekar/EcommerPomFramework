package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtility;

public class Orderpage extends BrowserUtility {
	  WebDriver driver;
		
		public  Orderpage(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver,this);	
		}

		public boolean verifyOrderDisplayed(String productName ) {
			List<WebElement>ProductListInCart =   driver.findElements(By.xpath("//tbody/tr/td[2]"));   
		    Boolean match =   ProductListInCart.stream().anyMatch(cartlist -> cartlist.getText().equalsIgnoreCase(productName));
		    return match;
		}
		
		
}


