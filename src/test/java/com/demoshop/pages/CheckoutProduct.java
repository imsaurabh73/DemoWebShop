package com.demoshop.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CheckoutProduct 
{

	public WebDriver driver;
	
	public CheckoutProduct(WebDriver driver)
	{
		this.driver=driver; 
	}
	
	//CHECKOUT
	 @FindBy(how = How.ID,using = "CountryId")
	   WebElement country;
	 
	 @FindBy(how = How.NAME,using = "estimateshipping")
	   WebElement estimate;
	 
	 @FindBy(how = How.ID,using = "termsofservice")
	   WebElement toscheckbox;
	 
	 @FindBy(how = How.ID,using = "checkout")
	   WebElement checkoutbutton;
	 
	//BILLING
	 @FindBy(how = How.ID,using = "BillingNewAddress_CountryId")
	   WebElement countrybilling;
	 
	 @FindBy(how = How.ID,using = "BillingNewAddress_City")
	   WebElement citybilling;
	 
	 @FindBy(how = How.NAME,using = "BillingNewAddress.Address1")
	   WebElement address;
	 
	 @FindBy(how = How.ID,using = "BillingNewAddress_ZipPostalCode")
	   WebElement postalcode;
	 
	 @FindBy(how = How.ID,using = "BillingNewAddress_PhoneNumber")
	   WebElement phonenumber;
	 
	 @FindBy(how = How.CSS,using = "input[onclick=\"Billing.save()\"]")
	   WebElement billingnext;
	 
	 //SHIPPING
	 @FindBy(how = How.CSS,using = "input[onclick=\"Shipping.save()\"]")
	   WebElement shippingnext;
	 
	 @FindBy(how = How.CSS,using = "input[onclick=\"ShippingMethod.save()\"]")
	   WebElement shippingmethod;
	 
	 //PAYMENT
	 @FindBy(how = How.CSS,using = "input[onclick=\"PaymentMethod.save()\"]")
	   WebElement paymentmethod;
	 
	 @FindBy(how = How.ID,using = "paymentmethod_0")
	   WebElement cod;
	 
	 @FindBy(how = How.CSS,using = "input[onclick=\"PaymentInfo.save()\"]")
	   WebElement paymentinfo;
	 
	 //CONFIRM-ORDER
	 @FindBy(how = How.CSS,using = "input[onclick=\"ConfirmOrder.save()\"]")
	   WebElement confirm;
	 
	 @FindBy(how = How.LINK_TEXT,using = "Click here for order details.")
		WebElement orderdetails;
	 public void checkoutproducts(String countries)
	 
	 {
		 
		 Select s=new Select(country);
		 s.selectByVisibleText(countries);
		 
		 estimate.click();
		 toscheckbox.click();
		 checkoutbutton.click();
			
		 
	 }
	 
	 public void billingAdress(String countrybillings, String city, String add, String post, String mobile)
	 {
		 Select s1=new Select(countrybilling);
		 s1.selectByVisibleText(countrybillings);
		 
		 citybilling.sendKeys(city);
		 address.sendKeys(add);
		 postalcode.sendKeys(post);
		 phonenumber.sendKeys(mobile);
		 billingnext.click();
	 }
	 
	 public void shippingDetails()
	 {
		 shippingnext.click();
		 shippingmethod.click();
		 
	 }
	 
	 public void paymentdetails()
	 {
		 
	     boolean c=cod.isSelected();
	     System.out.println("Cash on delivery is selected= "+c);
	     
	     paymentmethod.click();
	     paymentinfo.click();
	     
	 }
	 
	 public void confirmorder() throws IOException
	 {
		 confirm.click();
		 orderdetails.click();
		 	 
		 
	 }
	 
}
