package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AddressPage {
	WebDriver driver;
	 WebDriverWait wait;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
        // Explicit wait with 10 seconds timeout
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(xpath="//a[text()='My account']")
	WebElement myACCOUNT;
	
	@FindBy(linkText="Addresses")
	WebElement address;
	@FindBy(xpath="//input[@value='Delete']")
	List<WebElement> deleteBtn;
	
	// ----- Methods -----
	public void removeAddress()   {
		myACCOUNT.click();
		address.click();
		Reporter.log("Navigated to Address page succesffully ",true);
		
		if (deleteBtn.size() > 0) {
            for (WebElement deleteBotton : deleteBtn) {
            	deleteBotton.click();
                Reporter.log("Clicked delete button for an address", true);

               
              
                // Handle alert pop up
               driver.switchTo().alert().accept();
                Reporter.log("Confirmed delete alert", true);
                // Wait until page reloads or delete button list updates
                wait.withTimeout(Duration.ofSeconds(5));
                driver.navigate().back();

                
            }
        } else {
            Reporter.log("No saved addresses found to delete", true);
        }
    }

		
	}
