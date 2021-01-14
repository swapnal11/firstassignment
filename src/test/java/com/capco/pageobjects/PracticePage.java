package com.capco.pageobjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PracticePage {

	WebDriver driver;
	JavascriptExecutor jse;
	WebElement element;
	Select select;

	public PracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOn_RadioButtonAndCheckbox() {
		element = driver.findElement(By.id("benzradio"));
		element.click();				
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		bmwCheckBox.click();		
	}

	public void clickOn_DropDown() {
		element = driver.findElement(By.id("carselect"));
		select = new Select(element);	
		select.selectByValue("benz");
		select.selectByIndex(2);	
		select.selectByVisibleText("BMW");			
		List<WebElement> options = select.getOptions();
		int size = options.size();	
		for (int i=0; i<size; i++) {
			String optionName = options.get(i).getText();
		}
	}

	public void select_MultipleExample() throws InterruptedException {
		element = driver.findElement(By.id("multiple-select-example"));
		select = new Select(element);	
		select.selectByValue("orange");	
		select.deselectByValue("orange");	
		select.selectByIndex(2);	
		select.selectByVisibleText("Apple");	
		Thread.sleep(2000);
		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
		}	
		select.deselectAll();
	}

	public void  clickOn_OpenWindow(){
		String parentHandle = driver.getWindowHandle();	
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle: handles) {
		}
		driver.switchTo().window(parentHandle);	
	}

	public void  clickOn_OpenTab() throws InterruptedException{
		String parentHandle = driver.getWindowHandle();
		WebElement opentab= driver.findElement(By.id("opentab"));
		opentab.click();
		Thread.sleep(20);
		String currenturl = driver.getCurrentUrl();
		String expectedurl = "https://letskodeit.teachable.com/courses";
		if(currenturl == expectedurl)
		{
			System.out.println("New tab is opened");
		}
		driver.navigate().to("https://letskodeit.teachable.com/p/practice");
		driver.switchTo().window(parentHandle);
	}

	public void  clickOn_Confirmbutton() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Demo");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public boolean  clickOn_AlertButton() throws InterruptedException{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public void  clickOn_ShowButton()
	{
		element = driver.findElement(By.id("displayed-text"));	
	}

	public void  clickOn_HideButton()
	{
		element = driver.findElement(By.id("hide-textbox"));
		element.click();	
	}

	public void selectOn_WebTableExample() {
		element = driver.findElement(By.xpath("//*[@id='product']")); 
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rnum = 0; rnum < rows.size(); rnum++) {
			System.out.println("Showing of Rows Values :" + rows.get(rnum).getText());
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("th"));
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				System.out.println("Showing of Coloumns Values "+columns.get(cnum).getText());
			}
		}

	}
	public void  clickOn_MouseHover() throws InterruptedException
	{
		jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, 600)");
		WebElement mainElement = driver.findElement(By.id("mousehover"));	
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(2000);	
		element = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']"));
		action.moveToElement(element).click().perform();

	}

	public void  clickOn_iFrameExample() throws InterruptedException
	{
		driver.switchTo().frame("courses-iframe");
		element = driver.findElement(By.id("search-courses"));
		element.sendKeys("python");		
		element.click();
		driver.switchTo().defaultContent();
		Thread.sleep(6000);		
	}






}

