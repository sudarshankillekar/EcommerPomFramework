package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtility;

public class productCatalogePage extends BrowserUtility {

WebDriver driver;
	
	public productCatalogePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);	
	}
    
	private static final By ProductList = By.cssSelector(".mb-3");
	private static final By toastMessage = By.xpath("//div[contains(text(),\" Product Added To Cart \")]");
	private static final By loadingicon = By.xpath("//div[@class=\"ng-tns-c31-0 la-3x la-ball-scale-multiple ng-star-inserted\"]");
	@FindBy(css  = ".mb-3")
    List< WebElement> Products ;
	
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(ProductList);
		return Products ;
	}
	
	public WebElement getProductByName(String ProductName) {
		    WebElement prod =  getProductList().stream().filter(product -> 
	        product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		    return prod;
	}
	
	public void AddProductToCart(String ProductName) {
	WebElement prod	= getProductByName(ProductName);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	waitForElementToAppear(toastMessage);
	waitForElementToDissappear(loadingicon);
	}
	
	
	
	
	
//	   List<WebElement> ProdList  =  driver.findElements(By.cssSelector(".mb-3"));
//       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
//       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//button[@class=\"btn btn-custom\"])[4]")));
//       WebElement prod =  ProdList.stream().filter(product -> 
//       product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//       prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
}
