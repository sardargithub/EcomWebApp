package com.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageObjects.CartPage;
import com.pageObjects.CheckOutPage;
import com.pageObjects.ConfirmationPage;
import com.pageObjects.LandingPage;
import com.pageObjects.productCatalog;
import com.testComponents.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	public productCatalog pc;
	public ConfirmationPage confirmationPage;
	@Given("landed on Ecommerce page")
	public void landed_on_Ecommerce_page() throws IOException {
		landingPage=launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_In_With_Username_And_Password(String userName,String password) {
		pc=landingPage.loginApplication(userName,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void I_added_Product_To_Cart(String productName) {
		List<WebElement> products = pc.getProducts();
		pc.addProductToCart(productName);
	}
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_And_Submit_Order(String productName) throws InterruptedException {
		CartPage cartPage=pc.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		confirmationPage = checkOutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on the Confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string) {
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
}
