package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	String expectedHomepageTitle = "Demo Web Shop";

	@Parameters("browser")

	@BeforeSuite

	public void toLaunch(@Optional("chrome") String bname) {
		if (bname.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (bname.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (bname.equals("edge")) {
			driver = new EdgeDriver();
		}

		Reporter.log("Broswer got launched", true);
		driver.manage().window().maximize();
		Reporter.log("Broswer got maximized", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		String actualHomepageTitle = driver.getTitle();
		if (actualHomepageTitle.equals(expectedHomepageTitle)) {
			Reporter.log("Successfully navigated to Demo Web Shop", true);

		} else {
			Reporter.log("Failed to navigate to Demo Web Shop", true);
		}
	}

	@AfterSuite
	public void toClose() {
		Reporter.log("Broswer got Closed", true);
		driver.quit();
	}

}
