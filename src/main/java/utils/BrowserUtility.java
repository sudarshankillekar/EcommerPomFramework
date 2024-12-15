package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.pages.Orderpage;

public class BrowserUtility {

	WebDriver driver;
	
	public BrowserUtility(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath  =  "//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath  =  "//button[@routerlink='/dashboard/myorders']")
	WebElement ORDERSHeader;
	
	public void waitForElementToAppear(By locator) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	     wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
	}
	
	public void clickOn(By locator) {
		 driver.findElement(locator).click();
	 }
	
	public void waitForElementToDissappear(By locator) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	     wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		
	}
	
	public String getvisibleText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public CartPage  goToCartPage() {
		cartHeader.click();
		return  new CartPage(driver);
	}
	
	public Orderpage  goToORDERSPage() {
		ORDERSHeader.click();
		return  new Orderpage(driver);
	}
}
