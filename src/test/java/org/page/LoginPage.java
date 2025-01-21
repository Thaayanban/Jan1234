package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends SeleniumBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	 @FindBy (id="input-email")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='input-password']"), @FindBy(id = "passsssword") })
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
	


}
