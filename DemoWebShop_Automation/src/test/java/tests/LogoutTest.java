package tests;

import org.testng.annotations.Test;

import pages.LogoutPage;
import utils.BaseClass;

public class LogoutTest extends BaseClass {
@Test
public void logout() {
	LogoutPage lop=new LogoutPage(driver);
	lop.toLogout();
	
}
}
