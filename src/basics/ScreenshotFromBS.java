package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScreenshotFromBS {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/innoraft/Amir/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.browserstack.com/users/sign_in");
		
//		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//input[@name='user[login]']")).sendKeys("mukesh.agarwal@innoraft.com");
		driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys("myfriends");
		
		driver.findElement(By.xpath("//input[@value='Sign me in']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Close']")).click();
		
		driver.findElement(By.xpath("//a[@id='skip-local-installation']")).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[@id='product-menu-toggle']"))).build().perform();
		
		driver.findElement(By.xpath("//div[@class='col-xs-2']//child::li//child::a[text()='Screenshots']")).click();
		
		WebElement urlentry = driver.findElement(By.xpath("//input[@name='screenshots']"));
		
		urlentry.clear();
		urlentry.sendKeys("https://straighttalk.hcltech.com/");
		
		driver.findElement(By.xpath("//span[@class='browser-count__reset']")).click();
//		driver.findElement(By.xpath("//div[@class='browser-list__toggle browser-list--hidden']")).click();
		
		WebElement winchrome71 = driver.findElement(By.xpath("//div[@class='browser-vendor-box Windows-10']//"
				+ "child::li[@class='browser-versions chrome-versions']//child::li[text()=71]"));
		winchrome71.click();
		
		WebElement winff63 = driver.findElement(By.xpath("//div[@class='browser-vendor-box Windows-10']//"
				+ "child::li[@class='browser-versions firefox-versions']//child::li[text()=63]"));
		winff63.click();
		
		driver.findElement(By.xpath("//a[text()='Generate Screenshots']")).click();
	}

}
