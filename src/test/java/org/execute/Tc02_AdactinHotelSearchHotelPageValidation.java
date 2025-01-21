package org.execute;

import java.io.IOException;

import org.global.SeleniumBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
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
		searchHotelPage = new SearchHotelPage();

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
		public void ClickAddressBook() throws InterruptedException {

			searchHotelPage = new SearchHotelPage();

			
			WebElement clickAddressBook = searchHotelPage.getClickAddressBook();
			seleniumBase.clickByJava(clickAddressBook);
			Thread.sleep(2000);
			seleniumBase.navigation("back");
			Thread.sleep(2000);
			seleniumBase.navigation("forward");
			Thread.sleep(1000);			
		
		}
		@After
		public void ClickNewAddress() throws InterruptedException {

			searchHotelPage = new SearchHotelPage();

			WebElement clickNewAddress = searchHotelPage.getClickNewAddress();
			seleniumBase.clickByJava(clickNewAddress);			
		
		}
		@After
		public void FirstName() throws InterruptedException, IOException {

			searchHotelPage = new SearchHotelPage();

			WebElement firstName = searchHotelPage.getFirstName();
			seleniumBase.sendKeysByJava(firstName, getDataFromExcel("input", 2, 0));			
		
		}
		@After
		public void LastName() throws InterruptedException, IOException {

			searchHotelPage = new SearchHotelPage();

			WebElement lastName = searchHotelPage.getLastName();
			seleniumBase.sendKeysByJava(lastName, getDataFromExcel("input", 3, 0));			
		
		}  

}
