 package com.demoshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.demoshop.verify.BaseClass;
import com.demoshop.verify.TestClass;

public class RegisterPage extends BaseClass 
{

	public WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how = How.LINK_TEXT,using = "Register")
	WebElement registerclick;
	
	@FindBy(how = How.ID,using = "gender-male")
	WebElement gender;
	
	@FindBy(how = How.ID,using = "FirstName")
	WebElement Name;
	
	@FindBy(how = How.ID,using = "LastName")
	WebElement surname;
	
	@FindBy(how = How.ID,using = "Email")
	WebElement email;
	
	@FindBy(how = How.ID,using = "Password")
	WebElement pass;
	
	@FindBy(how = How.ID,using = "ConfirmPassword")
	WebElement confirmpass;
	
	@FindBy(how = How.ID,using = "register-button")
	WebElement registerbutton;
	
	@FindBy(how = How.LINK_TEXT,using = "Log out")
	WebElement logout;
	
	
	
	public void register(String firstname, String lastname, String emailid, String password, String cpass)
	{		
		registerclick.click();
		
		gender.click();
		Name.sendKeys(firstname);
		surname.sendKeys(lastname);
		email.sendKeys(emailid);
		pass.sendKeys(password);
		confirmpass.sendKeys(cpass);
		registerbutton.click();
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
