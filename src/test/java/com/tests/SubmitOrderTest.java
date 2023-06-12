package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageObjects.CartPage;
import com.pageObjects.CheckOutPage;
import com.pageObjects.ConfirmationPage;
import com.pageObjects.OrdersPage;
import com.pageObjects.productCatalog;
import com.testComponents.BaseTest;
import com.testComponents.RetryTest;

public class SubmitOrderTest extends BaseTest{

	
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	//public void sumbitOrder(String email,String password) throws IOException, InterruptedException {
	public void sumbitOrder(HashMap<String,String> input) throws InterruptedException {

		productCatalog pc=landingPage.loginApplication(input.get("email"),input.get("password"));
		//productCatalog pc=landingPage.loginApplication(email,password);
		List<WebElement> products = pc.getProducts();
		pc.addProductToCart(productName);
		CartPage cartPage=pc.goToCartPage();
		//CartPage cartPage = new CartPage(driver);
		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();		
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		//checkOutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkOutPage.submitOrder();
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		

	}
	
	@Test(dependsOnMethods= {"sumbitOrder"},retryAnalyzer=RetryTest.class)
	public void orderHistory() {
		productCatalog pc=landingPage.loginApplication("johnsmith123@gmail.com", "Test@123");
		OrdersPage orderPage=pc.goToOrdersPage();
		Assert.assertFalse(orderPage.verifyOrderDisplay(productName));
	}

	/*
	 * @DataProvider public Object[][] getData() { return new Object[][]
	 * {{"johnsmith123@gmail.com","Test@123"},{"anshika@gmail.com","Iamking@000"}};
	 * }
	 */
	
	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "johnsmith123@gmail.com");
		map.put("password", "Test@123");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "anshika@gmail.com");
		map1.put("password", "Iamking@000");

		return new Object[][] { { map }, { map1 } };

	}
}
