package tests;

import org.testng.annotations.Test;

import pages.ClearCartPage;

import utils.BaseClass;

public class ClearCartTest extends BaseClass {
	@Test
	public void removeProductsFromCart() {
		ClearCartPage ccp = new ClearCartPage(driver);
		ccp.clearCart();
	}

}
