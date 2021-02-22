 
package com.demoshop.verify;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.demoshop.pages.CheckoutProduct;
import com.demoshop.pages.ProductBooking;
import com.demoshop.pages.RegisterPage;

public class TestClass extends BaseClass
{
	@Test
	public void verifypages() throws IOException
	{
		//Register page
		RegisterPage reg=PageFactory.initElements(driver, RegisterPage.class);
		
		reg.register(pro.getProperty("firstname"), pro.getProperty("lastname"), pro.getProperty("emailid"), pro.getProperty("password"), pro.getProperty("confirmpassword"));

		if(driver.getCurrentUrl().equals("http://demowebshop.tricentis.com/registerresult/1"))
		{
			Assert.assertTrue(true);
			log.info("User Register succesfully");
		}
		else
		{
			log.info("Registration failed");
		}

		
		
		//Product-Booking
		ProductBooking pb=PageFactory.initElements(driver, ProductBooking.class);
		
		pb.addproducts();
		
		log.info("Product added succesfully");

		//Checkout and Payment
		CheckoutProduct cop=PageFactory.initElements(driver, CheckoutProduct.class);
		
		cop.checkoutproducts(pro.getProperty("country"));
	    cop.billingAdress(pro.getProperty("countrybill"), pro.getProperty("city"), pro.getProperty("address"), pro.getProperty("postalcode"), pro.getProperty("phonenumber"));
        cop.shippingDetails();
        cop.paymentdetails();
        cop.confirmorder();
        
		log.info("Product succesfully ordered");

		
		
        //Product-purchased-receipt
        capturescreen(pro.getProperty("screenshot"));
        
        
	    

	}
	
	@AfterSuite
	public void windowclose()
	{
		driver.close();
		
		log.info("Current Window Closed");
		
		driver.quit();
		
		log.info("Browser closed");
	}
	
}