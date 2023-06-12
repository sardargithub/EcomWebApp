package com.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.productCatalog;
import com.testComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

	
	@Test
	public void sumbitOrder() throws IOException {

		String productName = "ZARA COAT 3";
		productCatalog pc=landingPage.loginApplication("johnsmith123@gmail.com", "Test@12");
		String errorMessage=landingPage.getErrorMessage();
		System.out.println(errorMessage);
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	
		
		
	}

}
