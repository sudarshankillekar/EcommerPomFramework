package com.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pages.LandingPage;

public class BaseTest {

	  public WebDriver driver;
	  public LandingPage landingPage;
	
	
	public WebDriver initializeDriver() throws IOException {
	
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\resources\\GlobalData.properties");
   		properties.load(fileInputStream);
   		String browserName =     System.getProperty("browser")!=null ?System.getProperty("browser") : properties.getProperty("browser");
   		
   		if(browserName.contains("chrome")) {
   			ChromeOptions options = new ChromeOptions();
   			if(browserName.contains("headless")) {
   				options.addArguments("headless");
   			}
   			driver = new ChromeDriver(options);
   			driver.manage().window().setSize(new Dimension(1440, 900));
   		}
   		else if(browserName.equalsIgnoreCase("Edge")) {
   			 driver = new EdgeDriver();
   		}
   		else if(browserName.equalsIgnoreCase("FireFox")) {
  			 driver = new FirefoxDriver();
  		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	    driver.manage().window().maximize();
	    return driver;
	}
	
	
	
public List<HashMap<String, String>> convertJsonDataToMap(String filename) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\TestData\\"+filename+""),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data	=	mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		
        return data;	
		
	}
	
    public String captureScreenShot(String testCaseName, WebDriver driver ) throws IOException {
	
    TakesScreenshot ts =  (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File file = new File(System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png");
    FileUtils.copyFile(source, file);
    return System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
	}	


	@BeforeMethod(alwaysRun =  true)
	public LandingPage launchApplication() throws IOException {
	    driver = initializeDriver();
	    landingPage = new LandingPage(driver);
		landingPage.goTo();
		return new LandingPage(driver);
	    
	}
	
	@AfterMethod(alwaysRun =  true)
	public void tearDown() {
		driver.close();
	}
	
}
