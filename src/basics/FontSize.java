package basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FontSize {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
		System.setProperty("webdriver.chome.driver", "/home/innoraft/Amir/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.innoraft.com/");
		
		
	}
	
	@Test
	public void HeaderTagFontValidation() {
		List<WebElement> H1Tag = driver.findElements(By.tagName("h1"));
		int h1size = H1Tag.size();
		System.out.println("FontSize of H1");
		for(int i=0; i<h1size; i++) {
			String fontsize = H1Tag.get(i).getCssValue("font-size");
			System.out.println(fontsize);
		}
		List<WebElement> H2Tag = driver.findElements(By.tagName("h2"));
		int h2size = H2Tag.size();
		System.out.println("FontSize of H2");
		for(int i=0; i<h2size; i++) {
			String fontsize = H2Tag.get(i).getCssValue("font-size");
			System.out.println(fontsize);
		}
		List<WebElement> H3Tag = driver.findElements(By.tagName("h3"));
		int h3size = H3Tag.size();
		System.out.println("FontSize of H3");
		for(int i=0; i<h3size; i++) {
			String fontsize = H3Tag.get(i).getCssValue("font-size");
			System.out.println(fontsize);
		}
		List<WebElement> H4Tag = driver.findElements(By.tagName("h4"));
		int h4size = H4Tag.size();
		System.out.println("FontSize of H4");
		for(int i=0; i<h4size; i++) {
			String fontsize = H4Tag.get(i).getCssValue("font-size");
			System.out.println(fontsize);
		}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
