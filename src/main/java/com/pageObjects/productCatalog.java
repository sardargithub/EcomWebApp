package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponent.AbstractComponent;

public class productCatalog extends AbstractComponent{

	WebDriver dirver;
	public productCatalog(WebDriver driver) {
		super(driver);
		this.dirver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By prodBy =By.cssSelector(".mb-3");
	By addToCartBy = By.cssSelector(".card-body button:last-of-type");
	By toastedMessage=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProducts() {
		waitForElementToAppear(prodBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		WebElement prod = getProducts().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) {
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCartBy).click();
		waitForElementToAppear(toastedMessage);
		waitForElementToDisappear(spinner);
		
		
	}
}
