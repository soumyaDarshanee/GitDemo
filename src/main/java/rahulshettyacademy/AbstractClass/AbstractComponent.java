package rahulshettyacademy.AbstractClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartLink;
	@FindBy(css = "[routerlink*='myorders']")//button[routerlink='/dashboard/myorders']
	WebElement OrderHistoryPageLink;

	public void waitForElementToAppearBy(By findElementBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findElementBy));
	}
	public void waitForElementToAppear(WebElement findElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findElement));
	}

	public void waitForElementToDisappear(WebElement findElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findElement));
	}

	public CartPage goToCartPage() {
		cartLink.click();
		CartPage Cartpage = new CartPage(driver);
		return Cartpage;
	}
	public OrderHistoryPage gotoOrderHistoryPage() 
	{
		OrderHistoryPageLink.click();
		OrderHistoryPage orderPage = new OrderHistoryPage(driver);
		return orderPage;
	}

}
