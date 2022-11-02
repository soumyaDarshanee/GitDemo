package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractClass.AbstractComponent;

public class PlaceOrderPage extends AbstractComponent {

	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		// IntialiseDriver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".form-group input")
	WebElement countryInput;
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement country;
	@FindBy(css = ".btnn")
	WebElement placeOrderButton;

	By countryTable = By.cssSelector(".ta-results");
	By countryButton = By.cssSelector("button");

	public void selectCountry(String countryName) {

		countryInput.sendKeys(countryName);
		waitForElementToAppearBy(countryTable);
		country.click();
	}

	public ConfirmationPage placeOrder() {
		placeOrderButton.click();
		return new ConfirmationPage(driver);

	}

}
