package tests;

import org.testng.annotations.Test;

import pages.CartPageCheckout;
import utils.BaseClass;

public class CartTestCheckout extends BaseClass {
	@Test
	public void checkoutProduct() {
		CartPageCheckout cpc = new CartPageCheckout(driver);
		cpc.shoppingCart();
		cpc.fillBillingDetails("Meghana", "Sheela", "meghanasheela@gmail.com", "41", "Bengaluru",
				"Ashwath Nagar ,marathahalli", "560037", "9876543210");
		cpc.completeShipping();
		cpc.chooseShippingMethod();
		cpc.choosePaymentMethod();
		cpc.confirmPaymentInfo();
		cpc.confirmOrder();
	}

}