 package com.demoshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class ProductBooking 
{

   public WebDriver driver;

   public ProductBooking(WebDriver driver)
   {
	   this.driver=driver;
   }
   
   @FindBy(how = How.LINK_TEXT,using = "Books")
   WebElement books;
   
   @FindBy(how = How.LINK_TEXT,using = "Computing and Internet")
   WebElement selectbook;
   
   @FindBy(how = How.CLASS_NAME,using = "qty-input valid")
   WebElement quantity;
 
   @FindBy(how = How.ID,using = "add-to-cart-button-13")
   WebElement addtocart;
   
   @FindBy(how = How.LINK_TEXT,using = "Shopping cart")
   WebElement shoppingcart;
   
   
   
   
   public void addproducts()
   {
	   books.click();
	   selectbook.click();
	   addtocart.click();
	   shoppingcart.click();
   }
   
   
   
}
