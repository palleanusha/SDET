package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.POMclasses.ContactPage;
import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.OrganPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtility;
import com.Vtiger.genericUtil.WebDriverUtil;

import junit.framework.Assert;
@Listeners(com.Vtiger.genericUtil.Listernersimplementation.class)
public class TC001_Createorganisationtest extends BaseClass
{
	
	
	
	
	@Test(groups= "smoke")
	public void createOrganisationLink() throws InterruptedException, IOException
	{
		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();
		
		//click on the plus button;
		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		or.getCreateorgimg().click();
		Thread.sleep(3000);
		
		//enter the organisation name
		WebDriverUtil util=new WebDriverUtil(driver);
		String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		
		//click on save button
		or.getSearchnowbtn().click();
		//driver.findElement(By.name("button")).click();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		
        //clicking on organisation link
		oh.getOrglinks().click();
		
		//click on search button
		or.getSearchbox().sendKeys(org);
		
		//clicking on droppdown button
		WebElement dd = or.getSearchfororgDD();
		
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),dd);
        //clickink on searchnow button
		driver.findElement(By.name("submit")).click();

		//validation

		String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
	}
	@Test
	public void createorganisationphonenumber() throws InterruptedException, IOException
	{
      //clicking on organisation link
		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();
     //clicking on plus button
		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		or.getCreateorgimg().click();
		Thread.sleep(3000);

       //enter organization name,Phone number
		WebDriverUtil util=new WebDriverUtil(driver);
		String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		String ph=JavaUtility.objForJavaUtility().getphonenumber();
		Thread.sleep(2000);

		or.getPhoneNumber().sendKeys(ph);

		or.getClickingonsavebutton().click();


		Thread.sleep(2000);
		driver.navigate().refresh();

		//entering organisation page

		oh.getOrglinks().click();
		or.getSearchbox().sendKeys(org);
       //selecting organisation dropdown
		WebElement ddr= or.getSearchfororgDD();

		Thread.sleep(3000);

		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),ddr);
		 ContactPage con=new ContactPage(driver);
         con.getSearchtextboxbutton().click();
		//validating organization page
		String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
		
		}
	}



