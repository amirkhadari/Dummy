package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchWD {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "/home/innoraft/Amir/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void getUrl() {
		driver.get("https://www.hcltech.com/");
		String title = driver.getTitle();
		System.out.println(title);
	}
	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
}
