package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscriptionPage {

	WebDriver driver;
	private By countryDropdownList = By.xpath("//div[@class='country-current']");
	private By liteSubscriptionType = By.id("name-lite");
	private By classicSubscriptionType = By.id("name-classic");
	private By premiumSubscriptionType = By.id("name-premium");
	private By litePrice = By.cssSelector("#currency-lite b");
	private By classicPrice = By.cssSelector("#currency-classic b");
	private By premiumPrice = By.cssSelector("#currency-premium b");

//	public SubscriptionPage(WebDriver driver) {
//		this.driver = driver;
//	}

public SubscriptionPage(WebDriver driver) {
		this.driver = driver ;
	}

	//Select the country from the dropdown
	public void selectCountry(String country) {
		driver.findElement(countryDropdownList).click();
		By countryOption = By.xpath("//a/span[contains(text(),'" + country + "')]");
		driver.findElement(countryOption).click();
	}
	
	public String getLiteSubscriptionType() {
		return driver.findElement(liteSubscriptionType).getText();
	}
	
	public String getClassicSubscriptionType() {
		return driver.findElement(classicSubscriptionType).getText();
	}
	
	public String getPremiumSubscriptionType() {
		return driver.findElement(premiumSubscriptionType).getText();
	}

	public String getLitePrice() {
		return driver.findElement(litePrice).getText();
	}

	public String getClassicPrice() {
		return driver.findElement(classicPrice).getText();
	}

	public String getPremiumPrice() {
		return driver.findElement(premiumPrice).getText();
	}
}
