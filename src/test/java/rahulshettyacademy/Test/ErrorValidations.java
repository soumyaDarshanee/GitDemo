package rahulshettyacademy.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.junit.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.RetryTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.PlaceOrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test//(groups= {"ErrorHandling"})this assigns test cases to groups, a group of test cases can run together
	public void SubmitOrderError() throws IOException //public static void main(String[] args)
	{
	
		String productCode = "ZARA COAT 3";
		String countryName = "India";
		//LandingPage landingPage = LaunchApplication();
		ProductCatalogue prodCatalogue=landingPage.loginApplication("soumyadarshanee@gmail.com", "Shaktiman@111");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	} 
	
	
	@Test(retryAnalyzer=RetryTest.class)
	public void ProductErrorValidation() 
	{
		String productCode = "ZARA COAT 3";
		String countryName = "India";
		//LandingPage landingPage = LaunchApplication();
		ProductCatalogue prodCatalogue=landingPage.loginApplication("soumyadarshanee@gmail.com", "Shaktiman@11");
		List<WebElement> productList = prodCatalogue.getProductList();
		prodCatalogue.addProdToCart(productCode);
		CartPage Cartpage = prodCatalogue.goToCartPage();
		Boolean match = Cartpage.verifyCartItem(productCode);
		Assert.assertTrue(match);
	}

}

/*
 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
 * ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 */
//LandingPage landingPage = new LandingPage(driver);
//landingPage.goTo();

	