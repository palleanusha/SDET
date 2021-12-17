package com.Vtiger.genericUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Vtiger.POMclasses.HomePage;
import com.Vtiger.POMclasses.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public static WebDriver sdriver;

	@BeforeSuite(groups={"smoke","sanity"})
	public void connectDatabase() {
		System.out.println("connectdatabase");

	}

	//@Parameters("BROWSER")
	@BeforeTest
	// public void openBrowser() throws Throwable
	public void openBrowser() throws Throwable {
		//String browser = FileUtil.objForFileUtil().readDataFromPropfile("browser");
		String browser=System.getProperty("BROWSER");
		System.out.println("Chrome");
		if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new SafariDriver();
		}
		driver.get(FileUtil.objForFileUtil().readDataFromPropfile("url"));
		// maximize the browser
		WebDriverUtil util = new WebDriverUtil(driver);
	
		util.maximisewindow(driver);
		util.refresh();

		util.pageloadWait(driver);
		sdriver = driver;
	}

	@BeforeMethod(groups={"smoke","sanity"})

	public void logintoapp() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.logintoapp();
	}

	@AfterMethod
	(groups={"smoke","sanity"})
	public void logoutFromApp() throws  InterruptedException   
	{
		HomePage oh = new HomePage(driver);
		oh.logoutFromApp1();
	}

	@AfterClass(groups={"smoke","sanity"})
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

	@AfterSuite(groups={"smoke","sanity"})
	public void disconnectfromDb() {
		System.out.println("disconnect");
	}

	public static void takescreenshot(String name) throws IOException {
		File srcFile = ((TakesScreenshot) sdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/Screenshots/" + name + ".png";

		File finaldest = new File(destfile);
		FileUtils.copyFile(srcFile, finaldest);
	}

}