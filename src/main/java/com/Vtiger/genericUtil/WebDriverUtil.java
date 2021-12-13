package com.Vtiger.genericUtil;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtil {
	public WebDriver driver;
	public WebDriverUtil(WebDriver driver) {
		this.driver=driver;
	}
public void maximisewindow(WebDriver driver) {
		driver.manage().window().maximize();
} 
public void refresh() {
	driver.manage().window().maximize();
}
public void pageloadWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
	public void movetoelement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
 public void selectFromDropdownIndex(WebElement element,int index) {
	 Select select=new Select(element);
	 select.selectByIndex(index);
 }

 public void selectFromDropdownVisibleText( String text,WebElement element) {
	 Select select=new Select(element);
	 select.selectByVisibleText(text);
 }
 public void selectFromDropdownValue(WebElement element,String value) {
	 Select select=new Select(element);
	 select.selectByVisibleText(value);
 }
 public void mouseHover(WebElement element) {
	 Actions actions=new Actions(driver);
	 actions.moveToElement(element).build().perform();
 }
	
 public void rightclick() {
		Actions act = new Actions(driver);
		act.contextClick();
	}
 public void clickByOffset(WebElement element,int Xoofset,int Yoffset)
 {
	 Actions actions = new Actions(driver);
	 actions.moveByOffset(Xoofset, Yoffset).click();
 }

	public void rightclick(WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick();
	}

	public void dissmissalert() {
		driver.switchTo().alert().dismiss();
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0]scrollIntoView();", element);
	}

	public void scrollbyposition(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

	public void switchToFrames(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrames(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrames(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToWindow(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToWindow(String name) {
		driver.switchTo().frame(name);
	}
	public void acceptAlertPopups()
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlertPopups()
	{
		driver.switchTo().alert().dismiss();
	
	}
	public void sendKeys1(WebElement element,String keysToSend)
	{
		element.sendKeys(keysToSend);
	}
	public void sendKeys(WebElement element,String keysToSend)
	{
		element.sendKeys(keysToSend);
	}
	public void switchwindowhandles( String title)
	{
		Set<String>allwnds=driver.getWindowHandles();
		for(String id:allwnds)
		{
			String currenttitle=driver.switchTo().window(id).getTitle();
			if(currenttitle.contains(title))
			{
				break;
			}
			}
		}}
	




