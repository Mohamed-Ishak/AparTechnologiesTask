package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestPage {
	protected static WebDriver driver;

    // Constructor to accept WebDriver instance

    @BeforeTest
    public WebDriver getDriver() {
    	  if (driver == null) {
    		  driver = new ChromeDriver();
    		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    		  driver.manage().window().maximize();
    	  } 
    	
    	return driver ;
	}

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
    
    By subcriptionType = By.cssSelector("#name-classic");
    By price = By.cssSelector("#currency-classic b");
    By countryDropdownList = By.xpath("//div[@class='country-current']");
    public By egyptCountryName = By.xpath("//span[@id='eg-contry-lable']");

    // Method to get the text of a web element
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Method to select country
    public void selectCountry() {
        driver.findElement(countryDropdownList).click();
    }
}