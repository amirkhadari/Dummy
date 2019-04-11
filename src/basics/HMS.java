package basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.test.Xls_Reader1;

public class HMS {
	WebDriver driver;
	Properties prop;
	Xls_Reader1 reader;
	String SheetName ="Sheet1";
	
	@BeforeMethod
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "/home/innoraft/Amir/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		prop = new Properties();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			FileInputStream fis = new FileInputStream("/home/innoraft/Amir/eclipse-oxygen-workspace"
					+ "/Dummy/src/config.properties");
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("url"));
	}
	
	@Test()
	public void LoginTest() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		WebElement firstname = driver.findElement(By.xpath("//input[@name='PNT_NAME']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='LAST_NAME']"));
		
		reader = new Xls_Reader1("/home/innoraft/Amir/eclipse-oxygen-workspace/"
				+ "Dummy/src/com/qa/testdata/hmstestdata.xlsx");
		
		int rowcount = reader.getRowCount(SheetName);
		
		for(int row=2; row<=rowcount;row++) {
			
			String first = reader.getCellData(SheetName, "firstName", row);
			String last =reader.getCellData(SheetName, "lastName", row);
			
			firstname.clear();
			firstname.sendKeys(first);
			lastname.clear();
			lastname.sendKeys(last);
			
		}
		
	}

}
