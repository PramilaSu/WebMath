package com.hybrid.webmath;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class NumbersFactor {

	public static void main(String[] args) {
		try {
			ChromeOptions options = new ChromeOptions();     
			options.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\HybridFramework\\src\\com\\hybrid\\utils\\numberfactors.properties");
			Properties p = new Properties();
			p.load(fis);
			
			String url= p.getProperty("Url");
			String GeneralMath= p.getProperty("GeneralMath_loc");
			String factorlinkloc= p.getProperty("factor_link_loc");
			String FactorofNumber= p.getProperty("factorofnumber");
			String factorofnumberloc= p.getProperty("factorofnumber_loc");
			String Factoritloc= p.getProperty("Factorit_loc");
		
			
			driver.get(url);
			WebElement generalmathLink= driver.findElement(By.linkText(GeneralMath));
			 generalmathLink.click();
			 Thread.sleep(2000);
	        
			driver.findElement(By.linkText(factorlinkloc)).click();
			Thread.sleep(2000);
			
			 WebElement factorofNum = driver.findElement(By.cssSelector(factorofnumberloc));
		     factorofNum.sendKeys(FactorofNumber);
			 Thread.sleep(2000);
			 
			 driver.findElement(By.cssSelector(Factoritloc)).click();
		}
		
		catch(Exception e) {
			
		}
    }
}