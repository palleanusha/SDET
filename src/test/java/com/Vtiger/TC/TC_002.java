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

public class TC_002 extends BaseClass {
	
	@Test(groups= {"smokeTest"})
	public void createOrganisationDropdown() throws IOException, InterruptedException
	{
		//CLICKING ON ORGANISATION LINK
		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();
		//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//CLICK ON PLUS BUTTON
		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		or.getCreateorgimg().click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//ENTER ORGANISATION NAME

		String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		//driver.findElement(By.name("accountname")).sendKeys(org);
		//CLICK ON INDUSTRY DROPDOWN
		driver.findElement(By.name("industry"));
		WebElement dropdown = driver.findElement(By.name("industry"));
		WebDriverUtil util=new WebDriverUtil(driver);
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",6,0),dropdown);

		//Select ind=new Select(dropdown);
		//ind.selectByVisibleText("Construction");
		//CLICK ON ACCOUNT DROPDOWN
		WebElement dd = driver.findElement(By.name("accounttype"));
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",3,1),dd);
		//Select acc=new Select(dd);
		//acc.selectByVisibleText("Customer");
		//CLICK ON RATING DROPDOWN
		WebElement dd1 = driver.findElement(By.name("rating"));
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("sheet1",2,2),dd1);
		//Select rat=new Select(dd1);
		//rat.selectByVisibleText("Active");
       //CLICK ON SAVE BUTTON
		driver.findElement(By.name("button")).click();
		//or.getEnterorgName().sendKeys(org);
		Thread.sleep(2000);
		driver.navigate().refresh();
		//VALIDATING THE ORGANISATION NAME
      //ENTER PREVIOUS ORGANISATION NAME
		oh.getOrglinks().click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//or.getSearchbox().sendKeys(org);
		driver.findElement(By.name("search_text")).sendKeys(org);
		//WebElement dd=or.getSearchfororgDD();
		//CLICKING ON DROPDOWN BUTTON
		WebElement dd2=driver.findElement(By.id("bas_searchfield"));


		//Select mm=new Select(dd);
		//mm.selectByVisibleText("Organization Name");
		Thread.sleep(3000);
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),dd2);
		//or.getClickingonsavebutton().click();
		driver.findElement(By.name("submit")).click();

		//or.getSearchnowbtn().click();

		String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
		
		//if(value.getText().equalsIgnoreCase(org))
		//{
			System.out.println(true);
		//}
		//else {
			//System.out.println(false);
		//}
		//Actions act = new Actions(driver);
		//WebElement signout=oh.getLogoutimg();
		//WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//act.moveToElement(signout).perform();

		//util.mouseHover(signout);
		//oh.getSignoutlink().click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}


