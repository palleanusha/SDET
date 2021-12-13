package com.Vtiger.TC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.genericUtil.FileUtil;

public class TC_0004 { 


		 public static WebDriver driver;


	public static void main(String[] args) throws Throwable
	{

	String browser =FileUtil.objForFileUtil().readDataFromPropfile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		driver=new ChromeDriver();
		}
	else if(browser.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver(); 
	}
		else {
		driver=new SafariDriver();
	}
				
				driver.manage().window().maximize();
				driver.get("http://localhost:8888/");
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				driver.findElement(By.name("user_name")).sendKeys("admin");
				Thread.sleep(2000);
				driver.findElement(By.name("user_password")).sendKeys("12345");
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("graphics");
				//int day=15;
				
				driver.findElement(By.id("jscal_trigger_closingdate")).click();
				
				//Calendar calender=Calendar.getInstance();
			    	//String date ="2021-12-25";
			    	//SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
				     // Date formatteddate;
					////try {
						//formatteddate = dateformat.parse(date);
						//calender.setTime(formatteddate);
						//int targetyear=calender.get(Calendar.YEAR);
						//int targetmonth=calender.get(Calendar.MONTH);
						//int targetday=calender.get(Calendar.DAY_OF_MONTH);
						//clicking on the calendar
						//driver.findElement(By.id("jscal_trigger_closingdate")).click();
					
					//} catch (ParseException e)
					//{
						//throw new Exception("invalid date");
					//}
				
			    	//String calender = driver.findElement(By.id("jscal_trigger_closingdate")).click();
			    	//                String datemonth = driver.findElement(By.class("title")).click();
			    	String parent = driver.getWindowHandle();
					System.out.println(parent);
					driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']" )).click();
					Set<String> handles = driver.getWindowHandles();
				    int count = handles.size();
				    for(String child:handles)
				    {
					if(!parent.equalsIgnoreCase(child))
					{
						
					
					driver.switchTo().window(child);
					Thread.sleep(2000);
				 driver.findElement(By.name("search_text")).sendKeys("fff");
					Thread.sleep(2000);
					WebElement dd = driver.findElement(By.name("search_field"));
					Thread.sleep(2000);
					Select dropdown=new Select(dd);
					Thread.sleep(2000);
				
					dropdown.selectByVisibleText("Organization Name");
					Thread.sleep(2000);
					driver.findElement(By.name("search")).click();
					//validation
					
					}}}}
				    
	
					
			
					
					

					
					
					
			    	
					
			
			
					
					


			    


	


