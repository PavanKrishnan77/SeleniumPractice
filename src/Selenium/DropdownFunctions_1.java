package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownFunctions_1 
{
	@Test
	public void dropDownSelectFunction() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		driver.get("http://www.facebook.com");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));

//		Below is a Repetative Task - If we have more than 10 dropdowns - It is not approached
//		Select select = new Select(day);
//		select.selectByVisibleText("10");
//		
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("May");
//		
//		Select select2 = new Select(year);
//		select2.selectByVisibleText("1990");
		
//		1st Way
//		selectValueFromDropDown(day, "10");
//		selectValueFromDropDown(month, "May");
//		selectValueFromDropDown(year, "1995");
	
//		2nd Second Way
		String dob = "10-May-1995";
		String dobArray[] = dob.split("-");
		
		selectValueFromDropDown(day, dobArray[0]);
		selectValueFromDropDown(month, dobArray[1]);
		selectValueFromDropDown(year, dobArray[2]);	
	}
	
	public static void selectValueFromDropDown(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
}