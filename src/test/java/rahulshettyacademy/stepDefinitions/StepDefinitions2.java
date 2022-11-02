package rahulshettyacademy.stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PlaceOrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitions2 extends BaseTest{
	LandingPage landingPage;
	ProductCatalogue prodCatalogue;
	
    @Given("^I landed on ECommerce page $")
    public void i_landed_on_ecommerce_page() throws Throwable {
    	landingPage = LaunchApplication();
    }

    @When("^Trying to Log in with wrong (.+) and (.+)$")
    public void trying_to_log_in_with_wrong_and(String username, String password) throws Throwable {
    	prodCatalogue=landingPage.loginApplication(username, password);
    }

   


	}


