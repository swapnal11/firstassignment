package com.capco.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.capco.pageobjects.PracticePage;
import com.capco.runners.BrowserSelection;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PracticePageSteps {

	public static WebDriver driver;
	PracticePage practicePage=new PracticePage(driver);;

	@Given("^User launch Practice Page$")
	public void user_launch_Practice_Page() throws Throwable {	  
		driver=BrowserSelection.selectBrowser();		   
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://letskodeit.teachable.com/p/practice");	
	}

	@When("^User click on \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_click_on_and(String arg1, String arg2) throws Throwable {
		practicePage=new PracticePage(driver);
		practicePage.clickOn_RadioButtonAndCheckbox();		
	}

	@When("^User click on \"([^\"]*)\"$")
	public void user_click_on(String arg1) throws Throwable {
		practicePage.clickOn_DropDown();
	}

	@When("^User select \"([^\"]*)\"$")
	public void user_select(String arg1) throws Throwable {
		practicePage.select_MultipleExample();		
	}

	@When("^User click on Open Window$")
	public void user_click_on_Open_Window() throws Throwable {
		practicePage.clickOn_OpenWindow();	
	}

	@When("^User click on Open tab$")
	public void user_click_on_Open_tab() throws Throwable {
		practicePage.clickOn_OpenTab();			
	}

	@When("^User click on Confirm button$")
	public void user_click_on_Confirm_button() throws Throwable {
		practicePage.clickOn_Confirmbutton();	
	}

	@When("^User click on Alert button$")
	public boolean user_click_on_Alert_button() throws Throwable {
		return practicePage.clickOn_AlertButton();
	}

	@When("^User click on Show Button$")
	public void user_click_on_Show_Button() throws Throwable {	
		practicePage.clickOn_ShowButton();	
	}

	@When("^User click on Hide Button$")
	public void user_click_on_Hide_Button() throws Throwable {
		practicePage.clickOn_HideButton();
	}

	@When("^User click on \"([^\"]*)\" Example$")
	public void user_click_on_Example(String arg1) throws Throwable {
		practicePage.selectOn_WebTableExample();
	}

	@When("^User click on Mouse Hover$")
	public void user_click_on_Mouse_Hover() throws Throwable {
		practicePage.clickOn_MouseHover();
	}

	@Then("^User Click on \"([^\"]*)\"$")
	public void user_Click_on(String arg1) throws Throwable {
		practicePage.clickOn_iFrameExample();
	}
	@After()
	public void closeBrowser() {
		driver.quit();
	}

}




