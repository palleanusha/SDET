package com.Vtiger.POMclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.FileUtil;

public class LoginPage {
	
	 WebDriver driver;
		@FindBy(name="user_name")
		private WebElement username;
		
		@FindBy(name="user_password")
		private WebElement password;
		
		@FindBy(id="submitButton")
		private WebElement login;
	
		
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}


public WebDriver getDriver() {
	return driver;
}


public WebElement getUsername() {
	return username;
}


public WebElement getPassword() {
	return password;
}


public WebElement getLogin() {
	return login;
}
public void logintoapp() throws Throwable 
{
username.sendKeys(FileUtil.objForFileUtil().readDataFromPropfile("username"));
password.sendKeys(FileUtil.objForFileUtil().readDataFromPropfile("password"));
login.click();
}
}





