package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractClass.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// IntialiseDriver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// pageFactory

	@FindBy(id = "userEmail") // WebElement userEmail = driver.findElement(By.id("userEmail"));
	WebElement userEmail;
	@FindBy(id = "userPassword") // WebElement userEmail = driver.findElement(By.id("userPassword"));
	WebElement userPassword;
	@FindBy(id = "login") // WebElement userEmail = driver.findElement(By.id("login"));
	WebElement submit;
	@FindBy(css="[class*= 'flyInOut']") 
	WebElement errorMessage;
	

	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue prodCatalogue  = new ProductCatalogue(driver);
		return prodCatalogue;
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppear(errorMessage);
		String errorText = errorMessage.getText();
		return errorText;
		
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	

}
