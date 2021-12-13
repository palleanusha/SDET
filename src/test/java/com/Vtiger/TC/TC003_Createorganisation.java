package com.Vtiger.TC;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Vtiger.POMclasses.ContactPage;
import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.OrganPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.JavaUtility;
import com.Vtiger.genericUtil.WebDriverUtil;

public class TC003_Createorganisation extends BaseClass {

	// CLICK ON CONTACTS LINK
	@Test(groups = { "smoke" })
	public void createContacts() throws InterruptedException {
		// CLICK ON CONTACTS LINK
		ContactPage con=new ContactPage(driver);
		con.getCreatecontactlink().click();
		
		// CLICK ON PLUS BUTTON
		con.getContacts().click();
		
		// ENTER THE MANDATORY FIELD
		Thread.sleep(3000);
		WebDriverUtil util = new WebDriverUtil(driver);
		String lname = JavaUtility.objForJavaUtility().getLastName()+ JavaUtility.objForJavaUtility().generateRandomNumber();
		con.getEnterlastname().sendKeys(lname);

		// Click ONWINDOW HANDLE

		// CLICK ON A BUTTON(CHILD WINDOW)

		con.getClickingonchildwindowplusbutton().click();
		
		// SWITCH ON TO NEXT WINDOW
		Thread.sleep(3000);
		String parentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		itr.next();
		String child = itr.next();

		driver.switchTo().window(child);
		// or.getEntersearchbuttontext()
		// ENTER DETAILS IN SEARCH IN TEXT BOX
		Thread.sleep(3000);
		con.getSearchtextbox().sendKeys("fff");
		Thread.sleep(3000);

		
		con.getSearchnowbutton();

		// SWITCHING TO THE CHILD WINDOW
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='1']")).click();
		// driver.close();
		driver.switchTo().window(parentHandle);
        con.getCreatecontactlink().click();
        con.getContacts().click();
       // con.getSearchtextbox().sendKeys(lname);
	   // con.getSearchdropdown();
	   // Select ind=new Select(dropdown);
		//ind.selectByVisibleText("Last Name");
		//CLICK ON ACCOUNT DROPDOWN
		
		
		//con.getSearchnowbutton();
		//Thread.sleep(6000);
		 
		//WebElement addr = driver.findElement(By.xpath("//a[@title='Contacts' and text()='" + lname + "']"));
       // Assert.assertEquals(addr,lname);
		//System.out.println(true);
}}
	

		