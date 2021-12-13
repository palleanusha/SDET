package com.Vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.OrganPage;
import com.Vtiger.genericUtil.BaseClass;
import com.Vtiger.genericUtil.ExcelUtil;
import com.Vtiger.genericUtil.JavaUtility;
import com.Vtiger.genericUtil.WebDriverUtil;

import junit.framework.Assert;

public class TC_001 {@Listeners(com.Vtiger.genericUtil.Listernersimplementation.class)
public class TC001_Createorganisationtest extends BaseClass
{
	//public static WebDriver driver;


	//public static void main(String[] args) throws Throwable
	//{

	//String browser =FileUtil.objForFileUtil().readDataFromPropfile("browser");
	//if(browser.equalsIgnoreCase("chrome"))
	//{
	//	driver=new ChromeDriver();
	//}
	//else if(browser.equalsIgnoreCase("firefox"))
	//{
	//	driver=new FirefoxDriver(); 
	//}
	//else {
	//	driver=new SafariDriver();
	//}
	//enter the url
	//driver.get("http://localhost:8888/");
	//driver.get(FileUtil.objForFileUtil().readDataFromPropfile("url"));
	//maximize the browser
	//WebDriverUtil util=new WebDriverUtil(driver);
	//util.maximisewindow(driver);
	//util.refresh();
	//driver.manage().window().maximize();
	//using implicitly wait

	//util.pageloadWait(driver);
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	// enter the username
	//driver.findElement(By.name("user_name")).sendKeys(FileUtil.objForFileUtil().readDataFromPropfile("username"));
	//LoginPage lp= new LoginPage(driver);
	//lp.logintoapp();
	//enter the password
	//driver.findElement(By.name("user_password")).sendKeys(FileUtil.objForFileUtil().readDataFromPropfile("password"));
	//nter the submit button
	//driver.findElement(By.id("submitButton")).click();
	//click on the organisation link
	//Thread.sleep(3000);
	@Test(groups= "smokeTest")
	public void createOrganisationLink() throws InterruptedException, IOException
	{
		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();
		//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//click on the plus button;
		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		//or.getCreateorgimg().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//enter the organisation name
		WebDriverUtil util=new WebDriverUtil(driver);
		String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		//driver.findElement(By.name("accountname")).sendKeys(org);
		//click on save button
		driver.findElement(By.name("button")).click();
		//or.getEnterorgName().sendKeys(org);
		Thread.sleep(2000);
		driver.navigate().refresh();
		//validating the organisation

		oh.getOrglinks().click();
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//or.getSearchbox().sendKeys(org);
		driver.findElement(By.name("search_text")).sendKeys(org);
		//WebElement dd=or.getSearchfororgDD();1
		WebElement dd=driver.findElement(By.id("bas_searchfield"));


		//Select mm=new Select(dd);
		//mm.selectByVisibleText("Organization Name");
		Thread.sleep(3000);
		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),dd);

		driver.findElement(By.name("submit")).click();

		//or..click();

		String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
		//if(value.getText().equalsIgnoreCase(org))
		//{
		//	System.out.println(true);
		//}
		//else {
		//	System.out.println(false);
		//}
		//Actions act = new Actions(driver);
		//WebElement signout=oh.getLogoutimg();
		//WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//act.moveToElement(signout).perform();

		//util.mouseHover(signout);
		//oh.getSignoutlink().click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
	@Test(groups= {"smokeTest"})
	public void createorganisationphonenumber() throws InterruptedException, IOException
	{

		HomePage oh= new HomePage(driver);
		Thread.sleep(3000);
		oh.getOrglinks().click();

		Thread.sleep(3000);
		OrganPage or=new OrganPage(driver);
		or.getCreateorgimg().click();
		Thread.sleep(3000);


		WebDriverUtil util=new WebDriverUtil(driver);
		String org=JavaUtility.objForJavaUtility().getFullName()+JavaUtility.objForJavaUtility().generateRandomNumber();
		or.getEnterorgName().sendKeys(org);
		String ph=JavaUtility.objForJavaUtility().getphonenumber();
		Thread.sleep(2000);

		or.getPhoneNumber().sendKeys(ph);

		or.getClickingonsavebutton().click();


		Thread.sleep(2000);
		driver.navigate().refresh();

		//validating the phone number

		oh.getOrglinks().click();
		or.getSearchbox().sendKeys(org);

		WebElement ddr= or.getSearchfororgDD();

		Thread.sleep(3000);

		util.selectFromDropdownVisibleText(ExcelUtil.objForExceleUtil().readDataFromExcelFile("Sheet2",1,1),ddr);
		or.getSearchnowbtn().click();
		String value = driver.findElement(By.xpath("//a[@title='Organizations' and text()='"+org+"']")).getText();
		Assert.assertEquals(value,org);
		//if(value.getText().equalsIgnoreCase(org))
		//{
			//System.out.println(true);
		//}
		//else {
			//System.out.println(false);
		}
	}





}
