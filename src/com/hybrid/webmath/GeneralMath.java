package com.hybrid.webmath;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

 public class GeneralMath {

	public static void main(String[] args) {
				try {
						ChromeOptions options = new ChromeOptions();     
						options.addArguments("--remote-allow-origins=*");
						ChromeDriver driver = new ChromeDriver(options);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						FileInputStream fis = new FileInputStream("D:\\ExcelR\\Selenium 4Jan Batch\\HybridFramework\\src\\com\\hybrid\\utils\\general_math.properties");
						Properties p = new Properties();
						p.load(fis);
						String url= p.getProperty("Url");
						String mathoption= p.getProperty("choose_math_option");
						String principalamt= p.getProperty("principal_amount");
						String rateofinterest= p.getProperty("interest_rate");
						String desiredtime= p.getProperty("desired_time");
						String interestUnitOptionIndex= p.getProperty("interest_units_index");
						String desiredTimeOptionIndex= p.getProperty("desired_time_units_index");
						
						String GeneralMath= p.getProperty("GeneralMath_loc");
						String topicItem_loc= p.getProperty("topicItem_loc");
						String Principal= p.getProperty("Principal_loc");
						String interest_loc= p.getProperty("interest_loc");
						String interestunits= p.getProperty("interestunits_loc");
						String desiredtime_loc= p.getProperty("desiredtime_loc");
						String desiredtimeunits= p.getProperty("desiredtimeunits_loc");
						String amountofinterest= p.getProperty("amountofinterest_loc");
						
						
						driver.get(url);
						WebElement generalmathLink= driver.findElement(By.linkText(GeneralMath));
						 generalmathLink.click();
						 Thread.sleep(2000);
						WebElement topicItem = driver.findElement(By.id(topicItem_loc));
						 Select topicItemSelect = new Select(topicItem);
						 topicItemSelect.selectByVisibleText(mathoption);
						 Thread.sleep(2000);
						 WebElement principalAmount = driver.findElement(By.cssSelector(Principal));
						 principalAmount.sendKeys(principalamt);
						 Thread.sleep(2000);
						 WebElement interest = driver.findElement(By.cssSelector(interest_loc));
								 interest.sendKeys(rateofinterest);
								 Thread.sleep(2000);
								 
						 WebElement interestSelect = driver.findElement(By.cssSelector(interestunits));	
							  Select interestSelectItem = new Select(interestSelect);
					//	Integer.parseInt(desiredtimeoptionindex) this line will convert string to integer	 
							  interestSelectItem.selectByIndex(Integer.parseInt(interestUnitOptionIndex));
							  Thread.sleep(2000);
							  
						  WebElement interestSelect1 = driver.findElement(By.cssSelector(interestunits));	
							  Select interestSelectItem1 = new Select(interestSelect1);
							  interestSelectItem1.selectByIndex(Integer.parseInt(interestUnitOptionIndex));
							  Thread.sleep(2000);
						   
						//	WebElement desired_time = driver.findElement(By.cssSelector("input[name='desired_time']"));
						//	desired_time.sendKeys("10");
							  
						   driver.findElement(By.cssSelector(desiredtime_loc)).sendKeys(desiredtime);
							Thread.sleep(2000);
							
							WebElement desired_time_units = driver.findElement(By.cssSelector(desiredtimeunits));
							Select desired_time_unitsSelect = new Select(desired_time_units);
							desired_time_unitsSelect.selectByIndex(Integer.parseInt(desiredTimeOptionIndex));
							Thread.sleep(2000);
							
							driver.findElement(By.cssSelector(amountofinterest)).click();
					}
					catch(Exception e) {
						
					}
		     }
		}

