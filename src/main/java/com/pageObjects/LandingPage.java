package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//WebElement password = driver.findElement(By.id("userPassword"));
	@FindBy(id="userPassword")
	WebElement password;
	
	//WebElement login = driver.findElement(By.id("login"));
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	WebElement errorMessage;
	
	
	public productCatalog loginApplication(String email,String pass) {
		userEmail.sendKeys(email);
		password.sendKeys(pass);
		submit.click();
		return new productCatalog(driver);
		
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
