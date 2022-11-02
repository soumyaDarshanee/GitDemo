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

public class StepDefinitions extends BaseTest{
	LandingPage landingPage;
	ProductCatalogue prodCatalogue;
	
	ConfirmationPage confirmPage;
	
	 @Given("I landed on ECommerce page")
	    public void i_landed_on_ecommerce_page() throws Throwable {
		 landingPage = LaunchApplication();
	    }

	    @Given("^Logeed in with (.+) and (.+)$")
	    public void logeed_in_with_and(String username, String password) throws Throwable {
	    	prodCatalogue=landingPage.loginApplication(username, password); 
	    }

	    @When("^I add (.+) to cart$")
	    public void i_add_to_cart(String productname) throws Throwable {
	    	List<WebElement> productList = prodCatalogue.getProductList();
			prodCatalogue.addProdToCart(productname);
	    }

	    @And("^Checkout (.+) is added to the cart and submit the order$")
	    public void checkout_is_added_to_the_cart_and_submit_the_order(String productname) throws Throwable {
	    	CartPage Cartpage = prodCatalogue.goToCartPage();
			Boolean match = Cartpage.verifyCartItem(productname);
			Assert.assertTrue(match);
			PlaceOrderPage placeOrder = Cartpage.goToPlaceOrderPage();
			placeOrder.selectCountry("India");
			confirmPage = placeOrder.placeOrder();
	    }

	    @Then("I validate the {string} message is displayed")
	    public void i_validate_the_something_message_is_displayed(String string) throws Throwable {
	    	String confirmText = confirmPage.getConfirmationMessage();
			Assert.assertTrue(confirmText.equalsIgnoreCase(string));
			driver.close();
	    }
	    @Then("{string} Error Message is displayed")
	    public void something_error_message_is_displayed(String string) throws Throwable {
	    	Assert.assertEquals(string, landingPage.getErrorMessage());
	    	driver.close();
	    }
	}


