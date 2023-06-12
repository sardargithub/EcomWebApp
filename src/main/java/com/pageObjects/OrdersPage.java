package com.pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abstractComponent.AbstractComponent;

public class OrdersPage extends AbstractComponent{

	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> productNames;
	
	public Boolean verifyOrderDisplay(String productName) {
		Boolean match = cartProducts.stream()
				.anyMatch(cartProducts -> cartProducts.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
