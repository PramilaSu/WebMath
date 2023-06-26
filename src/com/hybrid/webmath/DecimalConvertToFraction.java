package com.hybrid.webmath;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DecimalConvertToFraction {

	public static void main(String[] args) {
		try {
			ChromeOptions options = new ChromeOptions();     
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\HybridFramework\\src\\com\\hybrid\\utils\\decimalconverttofraction.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String url= p.getProperty("Url");
			String mathoption= p.getProperty("choose_math_option");
			String GeneralMath= p.getProperty("GeneralMath_loc");
			String topicItem_loc= p.getProperty("topicItem_loc");
			String decimalnumber= p.getProperty("decimal_number");
			String decimal_numberloc= p.getProperty("decimal_number_loc");
			String convert_itloc= p.getProperty("convert_it_loc");
			
			driver.get(url);
			WebElement generalmathLink= driver.findElement(By.linkText(GeneralMath));
			 generalmathLink.click();
			 Thread.sleep(2000);
			WebElement topicItem = driver.findElement(By.id(topicItem_loc));
			 Select topicItemSelect = new Select(topicItem);
			 topicItemSelect.selectByVisibleText(mathoption);
			 Thread.sleep(2000);
			
			 WebElement decimalNumber = driver.findElement(By.cssSelector(decimal_numberloc));
			 decimalNumber.sendKeys(decimalnumber);
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(convert_itloc)).click();
		}
		
		catch(Exception e) {
			
		}
    }
}
