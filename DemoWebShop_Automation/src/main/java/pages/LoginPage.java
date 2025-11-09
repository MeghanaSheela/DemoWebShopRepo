package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Log in")
	WebElement loginLink;
	@FindBy(id="Email")
	WebElement email;
	@FindBy(id="Password")
	WebElement password;
	@FindBy(id="RememberMe")
	WebElement rememberMe;
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginBtn;
	
	public void toLogin(String mail,String pwd) {
		loginLink.click();
		email.sendKeys(mail);
		password.sendKeys(pwd);
		rememberMe.click();
		loginBtn.click();
		Reporter.log("Logged to Successfully", true);
	}
	
}
