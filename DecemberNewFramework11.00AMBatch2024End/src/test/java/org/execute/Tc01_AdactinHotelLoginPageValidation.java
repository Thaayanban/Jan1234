package org.execute;

import java.io.IOException;

import org.global.SeleniumBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.page.LoginPage;

public class Tc01_AdactinHotelLoginPageValidation extends SeleniumBase {

	public static SeleniumBase seleniumBase = new SeleniumBase();
	public static LoginPage loginPage;

	@BeforeClass
	public static void browserLaunch() throws IOException {

		seleniumBase.initDriver(getDataFromExcel("input", 2, 3));

	}

	@Before
	public void browserurlLaunch() throws IOException {

		seleniumBase.launchUrl(getDataFromProperties("browserUrl"));
		seleniumBase.windowMax();
	}

	@Test
	public void EnterLoginCrdentials() throws IOException {

		loginPage = new LoginPage();

		WebElement username = loginPage.getUsername();
		// WebElement username2 = driver.findElement(By.id("username"));
		seleniumBase.sendKeysByJS(username, getDataFromExcel("input", 1, 0));

		// WebElement password = driver.findElement(By.id("password"));
		WebElement password = loginPage.getPassword();
		seleniumBase.sendKeysByJava(password, getDataFromExcel("input", 1, 1));

	}

	@After
	public void ClickLoginButton() {

		loginPage = new LoginPage();

		// WebElement loginButton = driver.findElement(By.name("login"));
		WebElement loginButton = loginPage.getLoginButton();
		seleniumBase.clickByJava(loginButton);

	}

	@AfterClass
	public static void ValidateSuccessfullLogin() {

		loginPage = new LoginPage();
		
		// To Validate Adactin Hotel Welcome Text
		WebElement welcomeToAdactinText = loginPage.getWelcomeToAdactinText();
		
	    String textByJava = seleniumBase.getTextByJava(welcomeToAdactinText);
	    System.out.println(textByJava);
	    
	    boolean displayed = welcomeToAdactinText.isDisplayed();
	
	    if (displayed==true) {
			System.out.println("User successfully Logged In");
		}
	
	    if (loginPage.getWelcomeToAdactinText().isDisplayed()) {
			
	    	System.out.println("User successfully Logged In");
	    	
		}
	    
	
	}

}
