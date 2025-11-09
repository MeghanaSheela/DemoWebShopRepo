package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ClearCartPage {
	WebDriver driver;

	public ClearCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCartLink;
	@FindBy(xpath="//input[@type='checkbox'and@value='5883017']")
	WebElement removeFromCart;

	@FindBy(name = "updatecart")
	WebElement updateCartButton;

	public void clearCart() {
		shoppingCartLink.click();
		removeFromCart.click();
		updateCartButton.click();
		Reporter.log("All products removed successfully from the cart", true);

	}
}
