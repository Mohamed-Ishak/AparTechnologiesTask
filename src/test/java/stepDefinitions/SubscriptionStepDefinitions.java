package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.SubscriptionPage;
import base.TestPage;


public class SubscriptionStepDefinitions extends TestPage {


	WebDriver driver;
    SubscriptionPage subscriptionPage;

    @Given("I am on the subscription page")
    public void i_am_on_the_subscription_page() {
        driver = getDriver();  // Assuming TestPage contains the WebDriver setup
        subscriptionPage = new SubscriptionPage(driver);
        driver.get("https://subscribe.jawwy.tv/eg-en");
    }

    @When("I select {string}")
    public void i_select_country(String country) {
        subscriptionPage.selectCountry(country);
    }

    @Then("the lite subscription price should be {string}")
    public void the_lite_subscription_price_should_be(String expectedPrice) {
    	Assert.assertEquals("LITE", subscriptionPage.getLiteSubscriptionType());
        String litePrice = subscriptionPage.getLitePrice();
        Assert.assertEquals(litePrice, expectedPrice);
    }

    @Then("the classic subscription price should be {string}")
    public void the_classic_subscription_price_should_be(String expectedPrice) {
    	Assert.assertEquals("CLASSIC", subscriptionPage.getClassicSubscriptionType());
        String classicPrice = subscriptionPage.getClassicPrice();
        Assert.assertEquals(classicPrice, expectedPrice);
    }

    @Then("the premium subscription price should be {string}")
    public void the_premium_subscription_price_should_be(String expectedPrice) {
    	Assert.assertEquals("PREMIUM", subscriptionPage.getPremiumSubscriptionType());
        String premiumPrice = subscriptionPage.getPremiumPrice();
        Assert.assertEquals(premiumPrice, expectedPrice);
        
    }
}