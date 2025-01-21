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
		
		seleniumBase.sendKeysByJS(username, getDataFromExcel("input", 1, 0));

		WebElement password = loginPage.getPassword();
		seleniumBase.sendKeysByJava(password, getDataFromExcel("input", 1, 1));

	}

	@After
	public void ClickLoginButton() {

		loginPage = new LoginPage();

		
		WebElement loginButton = loginPage.getLoginButton();
		seleniumBase.clickByJava(loginButton);
		System.out.println("Login");

	}


	
	}

