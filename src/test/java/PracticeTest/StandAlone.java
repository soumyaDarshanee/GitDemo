package PracticeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;



public class StandAlone {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productCode = "ZARA COAT 3";
		String countryName = "India";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage landingPage = new LandingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("soumyadarshanee@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Shaktiman@11");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productCode)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> CartItems = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = CartItems.stream().anyMatch(CartItem-> CartItem.getText().equalsIgnoreCase(productCode));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		driver.findElement(By.cssSelector(".form-group input")).sendKeys(countryName);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		/*
		 * List<WebElement> countryLists =
		 * driver.findElements(By.cssSelector(".form-group section")); WebElement
		 * country = countryLists.stream().filter(countryList->
		 * countryList.findElement(By.cssSelector("button")).getText().equals(
		 * countryName)).findFirst().orElse(null); country.click();
		 */
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".btnn")).click();
		
		String confirmationText = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmationText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
