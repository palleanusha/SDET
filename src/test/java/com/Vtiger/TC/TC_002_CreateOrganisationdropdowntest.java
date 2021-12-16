package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.OrganPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtility;
import com.Vtiger.genericUtil.WebDriverUtil;

import junit.framework.Assert;

public class TC_002_CreateOrganisationdropdowntest extends BaseClass 
{
@Test(groups= "smoke")
	public void createOrganisationDropdown() throws IOException, InterruptedException
	{
		//CLICKING ON ORGANISATION LINK
		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();
		
		//CLICK ON PLUS BUTTON
		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		or.getCreateorgimg().click();
		Thread.sleep(3000);
		
		//ENTER ORGANISATION NAME
String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		//CLICK ON INDUSTRY DROPDOWN
		or.getIndustrydropdown();
		WebElement dropdown =or.getIndustrydropdown();
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",6,0),dropdown);
        //CLICK ON ACCOUNT DROPDOWN
		WebElement dd =or.getAccountdropdown();
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",3,1),dd);
		
		//CLICK ON RATING DROPDOWN
		WebElement dd1 =or.getRatingdropdown();
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",2,2),dd1);
		
         //CLICK ON SAVE BUTTON
		or.getSearchnowbtn().click();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		oh.getOrglinks().click();
		
		
		or.getSearchbox().sendKeys(org);
		
		//CLICKING ON DROPDOWN BUTTON
		WebElement dd2=or.getSearchfororgDD();
Thread.sleep(3000);
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),dd2);
		driver.findElement(By.name("submit")).click();
String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
		


			System.out.println(true);
	}}



