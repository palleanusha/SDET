package com.Vtiger.POMclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.genericUtil.WebDriverUtil;

public class OrganPage {
WebDriver driver;
public OrganPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
//PLUS BUTTON
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createorgimg;
//SEARCH TEXT BOX
@FindBy(name="search_text")
private WebElement searchbox;
//SEARCH DROPDOWN
@FindBy(id="bas_searchfield")
private WebElement searchfororgDD;
//CLICKING on searchnowbutton
@FindBy(name="button")
private WebElement searchnowbtn;
//ACCOUNT DROPDOWN XPATH
@FindBy(name="accountname")
private WebElement enterorgName;

@FindBy(xpath="//img[@alt='Select']")
private WebElement select;
 

//CLICK ON SEARCH TEXT XPATH
 @FindBy(id="search_txt")
 private WebElement entersearchbuttontext;
 //CLICKING ON SAVE BUTTON
 @FindBy(name="button")
private WebElement clickingonsavebutton;
 //PHONE NUMBER XPATH
 @FindBy(xpath="//input[@id='phone']")
 private WebElement phonenumber;
//CLICKING ON INDUSTRY DROPDOWN
 @FindBy(name="industry")
 private WebElement industrydropdown;
 //CLICKING ON ACCOUNT DROPDOWN
 @FindBy(name="accounttype")
 private WebElement accountdropdown;
 //CLICKING ON RATING DROPDOWN
 @FindBy(name="rating")
 private WebElement ratingdropdown;
 //////////getters method///////////
public WebElement getIndustrydropdown() {
	return industrydropdown;
}



public WebElement getAccountdropdown() {
	return accountdropdown;
}



public WebElement getRatingdropdown() {
	return ratingdropdown;
}



public WebElement getPhonenumber() {
	return phonenumber;
}

//GETTERS METHOD
public WebElement getPhoneNumber() {
	return phonenumber;
}

public WebElement getClickingonsavebutton() {
	return clickingonsavebutton;
}




public WebElement getEntersearchbuttontext() {
	return entersearchbuttontext;
}






public WebDriver getDriver() {
	return driver;
}

public WebElement getSelect() {
	return select;
}



public WebElement getEnterorgName() {
	return enterorgName;
}



public WebElement getCreateorgimg() {
	return createorgimg;
}

public WebElement getSearchbox() {
	return searchbox;
}

public WebElement getSearchfororgDD() {
	return searchfororgDD;
}

public WebElement getSearchnowbtn() {
	return searchnowbtn;
}


public void searchForOrg(String orgnameforsearch,String text) {
searchbox.sendKeys(orgnameforsearch);
WebDriverUtil util=new WebDriverUtil(driver);
util.selectFromDropdownVisibleText(text,searchfororgDD);
searchnowbtn.click();
}
}






