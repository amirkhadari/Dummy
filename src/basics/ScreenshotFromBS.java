package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ScreenshotFromBS {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/innoraft/Amir/chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.browserstack.com/");
		
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//input[@name='user[login]']")).sendKeys("mukesh.agarwal@innoraft.com");
		driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys("myfriends");
		
		driver.findElement(By.xpath("//input[@value='Sign me in']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Close']")).click();
		
		driver.findElement(By.xpath("//a[@id='skip-local-installation']")).click();
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[@id='product-menu-toggle']"))).build().perform();
	}

}
