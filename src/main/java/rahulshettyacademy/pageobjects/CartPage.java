package rahulshettyacademy.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractClass.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// IntialiseDriver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;
	@FindBy(css = ".totalRow button")
	WebElement checkOutButton;
	

	public Boolean verifyCartItem(String productCode) {
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productCode));
		return match;
	}

	public PlaceOrderPage goToPlaceOrderPage() {
		checkOutButton.click();
		return new PlaceOrderPage(driver);
	}
}
