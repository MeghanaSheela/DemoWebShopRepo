package tests;

import org.testng.annotations.Test;

import pages.LoginPage;
import utils.BaseClass;

public class LoginTest extends BaseClass {
	@Test
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.toLogin("meghanasheela@gmail.com", "Selenium@123");

	}

}
