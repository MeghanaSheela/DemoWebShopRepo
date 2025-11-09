package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CartPageCheckout {
	WebDriver driver;

	public CartPageCheckout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// --- Cart / Terms / Checkout ---
	@FindBy(xpath = "//span[text()='Shopping cart']")
	WebElement shoppingCart;

	@FindBy(id = "termsofservice")
	WebElement button;
	@FindBy(id = "checkout")
	WebElement checkoutBTN;
	// --- Billing Address ---

	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstname;
	@FindBy(id = "BillingNewAddress_LastName")
	WebElement lastname;
	@FindBy(id = "BillingNewAddress_Email")
	WebElement email;
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryDropDown;
	@FindBy(id = "BillingNewAddress_City")
	WebElement city;
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement address1;
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phoneNo;

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement billingContinue;
	// --- Shipping Address ---
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement shippingcontinue;
	// --- Shipping Method ---
	@FindBy(id = "shippingoption_0")
	WebElement shippingOption;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	WebElement shippingMethodContinue;
	// --- Payment Method ---
	@FindBy(id = "paymentmethod_0")
	WebElement cashonDeliveryOption;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	WebElement paymentMethodcontinue;
	// --- Payment Info ---
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	WebElement paymentInfoContinue;
// --- Confirm Order ---
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	WebElement confirmOrderButton;
	@FindBy(xpath = "//div[@class='title']")
	WebElement confirmMessage;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

// ===== Methods =====

	public void shoppingCart() {
		shoppingCart.click();
Reporter.log("Navigated to shooping cart page successfully",true);
		button.click();
		checkoutBTN.click();
	}

	public void fillBillingDetails(String fName, String lName, String mail, String country, String cityname,
			String address, String zipcode, String phonenum) {

		firstname.clear();
		firstname.sendKeys(fName);
		lastname.clear();
		lastname.sendKeys(lName);
		email.clear();
		email.sendKeys(mail);

		Select countryselect = new Select(countryDropDown);
		countryselect.selectByValue(country);

		city.sendKeys(cityname);
		address1.sendKeys(address);
		zipCode.sendKeys(zipcode);
		phoneNo.sendKeys(phonenum);

		billingContinue.click();
		Reporter.log("Address Details enterd successfully",true);
	}

	public void completeShipping() {
		shippingcontinue.click();
		Reporter.log("shipping Address entered successfully",true);
	}

	public void chooseShippingMethod() {
		shippingOption.click();
		shippingMethodContinue.click();
		Reporter.log("Shipping Method Selected successfully",true);

	}

	public void choosePaymentMethod() {
		cashonDeliveryOption.click();
		paymentMethodcontinue.click();
		Reporter.log("Payment Method selected successfully",true);
	}

	public void confirmPaymentInfo() {
		paymentInfoContinue.click();
		Reporter.log("Successfully continue the payment information",true);
	}

	public void confirmOrder() {
		confirmOrderButton.click();
		confirmMessage.getText();
		continueButton.click();
		Reporter.log("Order confirm successfully",true);
	}

}
