package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.abstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement enterCountry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results= By.cssSelector(".ta-results");

	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry,country).build().perform();
		waitForElementToAppear(results);
		enterCountry.click();
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Scroll on page
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		submit.click();
		return new ConfirmationPage(driver);
	}
}
