package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.ProductSearchPage;
import utils.BaseClass;

public class ProductSearchTest extends BaseClass {
	@Test
	public void addProductsToCart() {
		ProductSearchPage psp = new ProductSearchPage(driver);
		psp.searchAndAddProduct("computer");
		psp.searchAndAddProduct2("book");
	}

}
