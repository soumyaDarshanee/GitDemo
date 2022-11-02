package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractClass.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		// IntialiseDriver
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3") // List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	List<WebElement> products;
	@FindBy(css = ".ng-animating")//By.cssSelector(".ng-animating");
	WebElement pageSpinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitForElementToAppearBy(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productCode) {
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productCode)).findFirst()
				.orElse(null);
		return prod;
	}
	public void addProdToCart(String productCode)
	{
		WebElement prod = getProductByName(productCode);
		prod.findElement(addToCart).click();
		waitForElementToAppearBy(toastMessage);
		waitForElementToDisappear(pageSpinner);
	}

}
