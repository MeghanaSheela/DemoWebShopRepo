package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductSearchPage {
	WebDriver driver;

	public ProductSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "small-searchterms")
	WebElement searchBox;
	@FindBy(xpath = "//input[@value='Search']")
	WebElement searchBtn;
	@FindBy(xpath = "//img[@alt='Picture of Build your own expensive computer']")
	WebElement img;
	@FindBy(id = "add-to-cart-button-74")
	WebElement addtocart;
	@FindBy(xpath = "//img[@title='Show details for Health Book']")
	WebElement img2;
	@FindBy(id = "add-to-cart-button-22")
	WebElement addToCart2;

	public void searchAndAddProduct(String productName) {
		searchBox.clear();
		searchBox.sendKeys(productName);
		searchBtn.click();
		img.click();
		addtocart.click();
		Reporter.log("Product added to the cart successfully",true);

	}

	public void searchAndAddProduct2(String productName2) {
		searchBox.clear();
		searchBox.sendKeys(productName2);
		searchBtn.click();
		img2.click();
		addToCart2.click();
		Reporter.log("second product added to the cart successfuly",true);
	}

}
