package com.Vtiger.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class HomePage {
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;
//ORGANISATION NAME
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orglinks;
//CONTACTS LINK
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactslink;
//OPPURTUNITIES LINK
	@FindBy(xpath = "//a[text()='Oppurtunities']")
	private WebElement oppurtunitieslink;
//LOGOUT 
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutimg;
	// SIGNOUT
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutlink;

	//GETTERS METHOD
	public WebElement getOrglinks() {
		return orglinks;
	}

	public WebElement getContactslink() {
		return contactslink;
	}

	public WebElement getLogoutimg() {
		return logoutimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public void logoutFromApp1()

	{
		WebDriverUtil util = new WebDriverUtil(driver);
		util.movetoelement(logoutimg);
		signoutlink.click();
	}

}
