package com.Vtiger.POMclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
	this.driver=driver;
PageFactory.initElements(driver,this);
	}
	//create contact link
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement createcontactlink;
	//create plus button
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contacts;
	//firstname textbox xpath
@FindBy(xpath="//input[@class='detailedViewTextBox']")
	private WebElement enterFirstName;
//lastname text box xpath
	@FindBy(name="lastname")
	private WebElement enterlastname;
	//searchdropdown xpath
	@FindBy(name="search_field")
	private  WebElement Searchdropdown ;
	//searchtextbox xpath
	@FindBy(name="search_text")
	private WebElement searchtextbox;
	//clicking on search button
	@FindBy(name="submit")
	private WebElement searchtextboxbutton;
	//clicking on save button
	@FindBy(name="button")
	private WebElement clickingonsearchnowbutton;
	//clicking on 
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement clickingonchildwindowplusbutton;
	@FindBy(name="search")
	private WebElement searchnowbutton;
	//////////getters method////////////////
	public WebElement getClickingonchildwindowplusbutton() {
		return clickingonchildwindowplusbutton;
	}
   public WebElement getSearchnowbutton() {
		return searchnowbutton;
	}
   public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getCreatecontactlink() {
		return createcontactlink;
	}
	
	public WebElement getContacts() {
		return contacts;
	}
	
	public WebElement getEnterFirstName() {
		return enterFirstName;
	}
	
	public WebElement getEnterlastname() {
		return enterlastname;
	}
	
	public WebElement getSearchdropdown() {
		return Searchdropdown;
	}
	
	public WebElement getSearchtextbox() {
		return searchtextbox;
	}
	
	public WebElement getSearchtextboxbutton() {
		return searchtextboxbutton;
	}
	
	
	}
	
	
	
	


