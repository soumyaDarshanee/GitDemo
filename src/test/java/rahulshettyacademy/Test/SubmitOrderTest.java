package rahulshettyacademy.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;
import rahulshettyacademy.pageobjects.PlaceOrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String prodName = "ZARA COAT 3"; 
	@Test(dataProvider="getDatajson")//,groups= {"purchase"}
	public void SubmitOrder(HashMap<String,String> inPut) throws IOException //String eMail,String password,String prodName
	{
	
	
		String countryName = "India";
		//LandingPage landingPage = LaunchApplication();
		ProductCatalogue prodCatalogue=landingPage.loginApplication(inPut.get("email"), inPut.get("password"));//loginApplication(eMail, password)
		List<WebElement> productList = prodCatalogue.getProductList();
		prodCatalogue.addProdToCart(inPut.get("prodName"));
		CartPage Cartpage = prodCatalogue.goToCartPage();
		Boolean match = Cartpage.verifyCartItem(inPut.get("prodName"));
		Assert.assertTrue(match);
		PlaceOrderPage placeOrder = Cartpage.goToPlaceOrderPage();
		placeOrder.selectCountry(countryName);
		ConfirmationPage confirmPage = placeOrder.placeOrder();
		String confirmText = confirmPage.getConfirmationMessage();
		Assert.assertTrue(confirmText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));		
	} 
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue prodCatalogue=landingPage.loginApplication("soumyadarshanee@gmail.com","Shaktiman@11");
		OrderHistoryPage orderPage = prodCatalogue.gotoOrderHistoryPage();
		Boolean match = orderPage.verifyOrderDisplay(prodName);
		Assert.assertTrue(match);	
	}
	
	
	@DataProvider
	public Object[][] getDatajson() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][]{{data.get(0)},{data.get(1)}};
	}
}
	
	//using object 2D array as DataProvider
	/*
	 * @DataProvider public Object[][] getData() { return new Object[][]
	 * {{"soumyadarshanee@gmail.com","Shaktiman@11","ZARA COAT 3"},{
	 * "soumyadarshini15@gmail.com","Shaktiman@11","ADIDAS ORIGINAL"}}; }
	 */
	
	//using object 2D HashMap as DataProvider
	/*
	 * @DataProvider public Object[][] getDataHashMap() { HashMap<String,String>
	 * map=new HashMap<String,String>(); map.put("email",
	 * "soumyadarshanee@gmail.com"); map.put("password", "Shaktiman@11");
	 * map.put("prodName", "ZARA COAT 3");
	 * 
	 * HashMap<String,String> map1=new HashMap<String,String>(); map.put("email",
	 * "soumyadarshini15@gmail.com"); map.put("password", "Shaktiman@11");
	 * map.put("prodName", "ADIDAS ORIGINAL");
	 * 
	 * return new Object[][]{{map},{map1}}; }
	 */


/*
 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
 * ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 */
//LandingPage landingPage = new LandingPage(driver);
//landingPage.goTo();

	