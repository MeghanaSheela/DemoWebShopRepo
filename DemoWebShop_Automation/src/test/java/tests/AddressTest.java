package tests;

import org.testng.annotations.Test;

import pages.AddressPage;
import utils.BaseClass;

public class AddressTest extends BaseClass{
 @Test
 public void AddressRemove()  {
	 AddressPage ap=new AddressPage(driver);
	 ap.removeAddress();
 }
}
