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
import org.page.SearchHotelPage;

public class Tc02_AdactinHotelSearchHotelPageValidation extends SeleniumBase {

	public static SeleniumBase seleniumBase = new SeleniumBase();
	public static LoginPage loginPage;
	public static SearchHotelPage searchHotelPage;

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
	public void EnterLoginCrdentials_ClickLoginButton() throws IOException {

		loginPage = new LoginPage();

		WebElement username = loginPage.getUsername();
		// WebElement username2 = driver.findElement(By.id("username"));
		seleniumBase.sendKeysByJS(username, getDataFromExcel("input", 1, 0));

		// WebElement password = driver.findElement(By.id("password"));
		WebElement password = loginPage.getPassword();
		seleniumBase.sendKeysByJava(password, getDataFromExcel("input", 1, 1));

		// WebElement loginButton = driver.findElement(By.name("login"));
		WebElement loginButton = loginPage.getLoginButton();
		seleniumBase.clickByJava(loginButton);

	}

	@After
	public void ValidateUserIsInSearchHotel() {
		searchHotelPage = new SearchHotelPage();

		if (searchHotelPage.getSearchHotelText().isDisplayed()) {
			System.out.println("ValidateUserIsInSearchHotel");
		}

	}

	@AfterClass
	public static void EnterSearchHotelDetails() throws IOException {

		searchHotelPage = new SearchHotelPage();

		WebElement location = searchHotelPage.getLocation();
		seleniumBase.selectBy(location, "value", getDataFromExcel("input", 1, 4));

		// To Validate Search Button And Click
//		WebElement searchButton = searchHotelPage.getSearchButton();
//		
//		if (searchButton.isDisplayed()) {
//			
//			if (searchButton.isEnabled()) {
//				
//				seleniumBase.clickByJS(searchButton);
//				
//			}
//			
//		}
		
		// OR
		
		if (searchHotelPage.getSearchButton().isDisplayed()) {
			
			if (searchHotelPage.getSearchButton().isEnabled()) {
				
				seleniumBase.clickByJS(searchHotelPage.getSearchButton());
				
			}
			
		}
		
		
	}

}
