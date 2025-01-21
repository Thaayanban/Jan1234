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

	@CacheLookup
	@FindBys({ @FindBy(id = "username"), @FindBy(xpath = "//input[@id='username']") })
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindAll({ @FindBy(xpath = "//input[@id='password']"), @FindBy(id = "passsssword") })
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(id = "login")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(xpath = "//td[text()='Welcome to Adactin Group of Hotels']")
	private WebElement welcomeToAdactinText;
	
	public WebElement getWelcomeToAdactinText() {
		return welcomeToAdactinText;
	}

}
