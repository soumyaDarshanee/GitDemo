package rahulshettyacademy.pageobjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractClass.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {

	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		// IntialiseDriver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "table[class*='table'] td:nth-of-type(2)")
	List<WebElement> OrderedProducts;
	@FindBy(css = ".totalRow button")
	WebElement checkOutButton;
	

	public Boolean verifyOrderDisplay(String productCode) {
		Boolean match = OrderedProducts.stream()
				.anyMatch(OrderedProduct -> OrderedProduct.getText().equalsIgnoreCase(productCode));
		return match;
	}

}
