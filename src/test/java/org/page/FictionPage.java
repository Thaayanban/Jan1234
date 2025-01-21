package org.page;

import org.global.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionPage extends SeleniumBase {

	public FictionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//img[@alt='LEGO Gear Bots']")
	private WebElement clickLegoGearBots;

	public WebElement getClickLegoGearBots() {
		return clickLegoGearBots;
	}
	
	
}
