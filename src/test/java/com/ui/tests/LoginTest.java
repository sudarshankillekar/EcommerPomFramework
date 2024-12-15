package com.ui.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestComponents.BaseTest;
import com.TestComponents.Retry;
import com.pages.CartPage;
import com.pages.CheckOutPage;
import com.pages.Orderpage;
import com.pages.confirmationPage;
import com.pages.productCatalogePage;

public class LoginTest extends BaseTest {
  
	String productName = "ADIDAS ORIGINAL";
	
	@Test(dataProvider = "submitorderData",retryAnalyzer = Retry.class)
	public void submitOrder(HashMap<String, String> input) throws IOException  {
		
		

		productCatalogePage productCatalogePage =	landingPage.loginWithUserIdPassWord( input.get("email"), input.get("password"));
		productCatalogePage.AddProductToCart(input.get("product"));
		CartPage cartPage =  productCatalogePage.goToCartPage();
		
		
     	Boolean match =	cartPage.verifyProductDisplayed(input.get("product"));
        Assert.assertTrue(match);
        CheckOutPage checkOutPage =   cartPage.clickOnCheckOutPage();
        checkOutPage.selectCountry("India");
        confirmationPage confirmationPage =   checkOutPage.submitOrder();
        
        String actualText =   confirmationPage.verifyiforderplcaed();
        String ExpectedText = "THANKYOU FOR THE ORDER.";
        Assert.assertEquals(actualText,ExpectedText);
        
        System.out.println(actualText);
	  }
	
	
	
	@Test(dependsOnMethods = "submitOrder",enabled =  true)
	public void verifyorderHistory() {
		productCatalogePage productCatalogePage =	landingPage.loginWithUserIdPassWord("sudarshankillekar1998@gmail.com","98@Sudarshan98");
		Orderpage orderpage  = productCatalogePage.goToORDERSPage();
		Assert.assertTrue(orderpage.verifyOrderDisplayed(productName));	
	}
	
	
	public String captureScreenShot(String testCaseName ) throws IOException {
		
     TakesScreenshot ts =  (TakesScreenshot)driver;
     File source = ts.getScreenshotAs(OutputType.FILE);
     File file = new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
     FileUtils.copyFile(source, file);
     return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
	}
	
	@DataProvider
	public Object[][] submitorderData() throws IOException {
		 List<HashMap<String,String>>  data = convertJsonDataToMap("PurchaseOrder.json");
		 return new Object [] [] {{data.get(0)},{data.get(1)}};
	}

	
}
