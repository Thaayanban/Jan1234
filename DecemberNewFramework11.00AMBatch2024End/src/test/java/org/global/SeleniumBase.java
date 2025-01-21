package org.global;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBase {

	public static WebDriver driver;
	public static JavascriptExecutor javascriptExecutor;
	public Actions actions;

	public void initDriver(String browserTye) {

		switch (browserTye) {
		case "Chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "Edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("In Valid Browser Type");
			break;
		}

	}

	public void launchUrl(String url) {
		driver.get(url);

	}

	public void windowMax() {
		driver.manage().window().maximize();
	}

	public void sendKeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void sendKeysByJS(WebElement element, String keyToSend) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value' , '" + keyToSend + "')", element);

	}

	public void clickByJava(WebElement element) {
		element.click();
	}

	public void clickByJS(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);

	}

	public void scrollByJS(WebElement element, String scrollType) {

		javascriptExecutor = (JavascriptExecutor) driver;

		switch (scrollType) {

		case "Down":

			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
			break;

		case "Up":

			javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", element);
			break;

		default:
			break;
		}

	}

	// AccessSpecifier returnType methodName() { }
	public String getTextByJava(WebElement element) {

		String text = element.getText();
		return text;
	}

	public String getAttributeByJava(WebElement element) {

		String attribute = element.getAttribute("value");
		return attribute;

	}

	public Object getAttributeByJS(WebElement element) {

		javascriptExecutor = (JavascriptExecutor) driver;

		Object executeScript = javascriptExecutor.executeScript("return arguments[0].getAttribute('value')", element);

		return executeScript;
	}

	public void selectBy(WebElement element, String selectType, String value) {
		Select select = new Select(element);

		switch (selectType) {
		case "value":
			select.selectByValue(value);
			break;

		case "visibleText":
			select.selectByVisibleText(value);
			break;

		default:
			break;
		}

		select.selectByValue(value);
	}

	public void screenCapture() throws IOException {

		// Type Casting - Takescreenshot - webdriver
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("ErrorImages\\" + System.currentTimeMillis() + ".jpeg");

		FileUtils.copyFile(sourceFile, targetFile);

	}

	public void switchToframe(WebElement frameElement) {

		driver.switchTo().frame(frameElement);

	}

	public void switchToWindows(int windowsIndexNo) {

		String parentPageWindowsID = driver.getWindowHandle();

		Set<String> allWindowsID = driver.getWindowHandles();

		List<String> list = new LinkedList<String>();
		// Set to List
		list.addAll(allWindowsID);

		String requiredWindowsID = list.get(windowsIndexNo);

		// To Switch to required windows ID
		driver.switchTo().window(requiredWindowsID);

	}

	public String getWindowsID(int windowsIndexNo) {

		String parentPageWindowsID = driver.getWindowHandle();

		Set<String> allWindowsID = driver.getWindowHandles();

		List<String> list = new LinkedList<String>();

		// Set to List
		list.addAll(allWindowsID);

		String requiredWindowsID = list.get(windowsIndexNo);

		return requiredWindowsID;

	}

	public void switchToRequiredWindows(String requiredWindowsID) {
		driver.switchTo().window(requiredWindowsID);
	}

	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).build().perform();

	}

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}

	public void navigation(String commands) {

		switch (commands) {
		case "refresh":
			driver.navigate().refresh();
			break;

		case "forward":
			driver.navigate().forward();
			break;

		case "back":
			driver.navigate().back();
			break;

		default:

			break;
		}

	}

	public void switchToAlert(String accept_dismiss) {

		switch (accept_dismiss) {
		case "accept":
			driver.switchTo().alert().accept();
			break;

		case "dismiss":
			driver.switchTo().alert().dismiss();
			break;

		default:

			break;
		}
	}

	public void switchToPrompt(String accept_dismiss, String keysToSend) {

		driver.switchTo().alert().sendKeys(keysToSend);

		switch (accept_dismiss) {
		case "accept":
			driver.switchTo().alert().accept();
			break;

		case "dismiss":
			driver.switchTo().alert().dismiss();
			break;

		default:

			break;
		}
	}

	public static String getDataFromExcel(String sheetName, int rownum, int cellnum) throws IOException {

		// To LOcate where the file will be
		File file = new File("DataBase\\inputDatas.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

		Workbook book = new XSSFWorkbook(fileInputStream); // throws IOException

		// To get Sheet from book
		Sheet sheet = book.getSheet(sheetName);

		// To get particular data row from sheet
		Row row = sheet.getRow(rownum);

		// To get Cell from Row
		Cell cell = row.getCell(cellnum);

		// To derfine Cell format / Type
		CellType cellType = cell.getCellType();
		
		String value = null;

		switch (cellType) {
		case STRING:
			
			 value = cell.getStringCellValue();

			break;

		case NUMERIC:

			if (DateUtil.isCellDateFormatted(cell)) {

				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				 value = simpleDateFormat.format(dateCellValue);

			} else {

				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				 value = valueOf.toString();
			}

			break;

		default:
			break;
		}

		
		return value;
	}
	
	
	
	public static String getDataFromProperties(String propertyKey) throws IOException {

		// To Locate where the File will be 
		File file = new File("DataBase\\Config.properties");
		
		// It read the File from given location of file
		FileReader fileReader = new FileReader(file); // throws FileNotFoundException
		
		Properties properties = new Properties();
		
		// To load file to Properties Class
		properties.load(fileReader); //  throws IOException
		
		// To get Particular value from Properties file Based on Key ref
		String propertyValue = properties.getProperty(propertyKey);
		
		return propertyValue;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
