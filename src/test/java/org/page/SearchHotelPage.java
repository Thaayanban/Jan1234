package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends SeleniumBase {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//a[text()='Address Book']")
	private WebElement clickAddressBook;

	public WebElement getClickAddressBook() {
		return clickAddressBook;
	}

	@FindBy(xpath="//a[text()='New Address']")
	private WebElement clickNewAddress;

	public WebElement getClickNewAddress() {
		return clickNewAddress;
	}
	
	 @FindBy (id="input-firstname")
		private WebElement firstName;

		public WebElement getFirstName() {
			return firstName;
		}
		
		@FindBy (id="input-lastname")
		private WebElement lastName;

		public WebElement getLastName() {
			return lastName;
		}

}
