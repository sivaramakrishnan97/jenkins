package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.json.Output;

public class BaseClass {

	// Base class is used to maintain Reusable Selenium Methods

	public static WebDriver driver; // Global Variable
	Actions a; // Global Variable
	Alert al; // Global Variable
	Select s; // Global Variable
	// JavascriptExecutor js; //Global Variable

	public WebDriver launchBrowser(String browserName) {
		// WebDriverManager.chromedriver().setup(); //We used this method to launch the
		// browser
		// driver=new ChromeDriver(); //We don't need to declare WebDriver here because
		// we
		// already declared it in global level.
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			driver = new ChromeDriver();
		}

		else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}

	// Browser
	public void launchUrl(String url) { // To Launch URL
		driver.get(url); // 2 inputs= driver and String URL
	}

	public void maximizeWindow() { // To maximize the window
		driver.manage().window().maximize();
	}

	public WebElement findElementById(String data) { // find locator by Id
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findElementByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public void enterText(WebElement element, String data) {
		element.sendKeys(data); // To input values, 2 inputs webElement and value
	}

	public void btnclick(WebElement element) { // To perform btn click
		element.click(); // 1 input= WebElement(we declared it globally)
	}

	public void quitBrowser() {
		driver.quit(); // To close browser
	}

	public String getPageUrl() { // 1 input= WebDriver, 1 output=String Url(return)
		String pageurl = driver.getCurrentUrl();
		return pageurl;
	}

	public String getTheText(WebElement element) { // To get particular text from WebPage
		String pageText = element.getText(); // 1 input= WebDriver, 1 output=String Url(return)
		return pageText;
	}

	public String getPageTitle() { // To get title of the page
		String title = driver.getTitle(); // 1 input= WebDriver, 1 output=String Url(return)
		return title;
	}

	public String getPageAttribute(WebElement element) { // To get attribute from webElement
		String attribute = element.getAttribute("value"); // 1 input= WebDriver, 1 output=String Url(return)
		return attribute;
	}

	public void sendkeysViaActiveWebElement(String data) {
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys(data);
		// return activeElement;
	}

	// Actions
	public void mouseOverAction(WebElement element) { // To move mouse(cursor) on particular place
		a = new Actions(driver); // Action=a declared globally
		a.moveToElement(element).perform();
	}

	public void dragAndDropAction(WebElement e1, WebElement e2) { // To drag and Drop to text
		a = new Actions(driver);
		a.dragAndDrop(e1, e2);
	}

	public void doubleClickAction(WebElement element) { // To double click in mouse
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void contextClickAction(WebElement element) { // To right click in mouse
		a = new Actions(driver);
		a.contextClick(element).perform();
	}

	public void keyDownAndKeyUpaction(WebElement e1, Keys k1, String v1) {
		a = new Actions(driver);
		a.keyDown(e1, k1).sendKeys(e1, v1).keyUp(e1, k1);
	}

	// ScreenShot
	public void webPageSS(String ssName) throws IOException { // To take ss of WebPage
		TakesScreenshot ss = (TakesScreenshot) driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Dell\\eclipse-workspace2\\Framework\\lib\\" + ssName + ".png");
		FileUtils.copyFile(srcFile, dest);
	}

	public void webElementSS(WebElement element, String ssName) throws IOException { // to take ss of WebElement
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Dell\\eclipse-workspace2\\Framework\\lib" + ssName + ".png");
		FileUtils.copyFile(srcFile, dest);
	}

	// Drop Down Option
	public void selectByIndexOf(WebElement element, int i) {
		s = new Select(element);
		s.selectByIndex(i);
	}

	public void selectByValueOf(WebElement element, String i) {
		s = new Select(element);
		s.selectByValue(i);
	}

	public void selectByTextOf(WebElement element, String i) {
		s = new Select(element);
		s.selectByVisibleText(i);
	}

	public void seletismuliple(WebElement element) {
		s = new Select(element);
		boolean b = s.isMultiple();
	}

	public void getselectedOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> all = s.getAllSelectedOptions();
		for (int i = 0; i < all.size(); i++) {
			WebElement ele = all.get(i);
			String text = ele.getText();
			System.out.println(text);
		}
	}

	public void selectFirstSelectedOptions(WebElement element) {
		s = new Select(element);
		WebElement first = s.getFirstSelectedOption();
		System.out.println(first.getText());
	}

	public void deselectByIndexOf(WebElement element, int i) {
		s = new Select(element);
		s.deselectByIndex(i);
	}

	public void deselectByValueOf(WebElement element, String i) {
		s = new Select(element);
		s.deselectByValue(i);
	}

	public void deselectByTextOf(WebElement element, String i) {
		s = new Select(element);
		s.deselectByVisibleText(i);
	}

	// Alerts
	public TargetLocator switchToElement() {
		TargetLocator locator = driver.switchTo();
		return locator;
	}

	public Alert switchToAlert() {
		Alert al = switchToElement().alert();
		return al;
	}

	public void alertAccept() {
		switchToAlert().accept();
	}

	public void alertDismiss() {
		switchToAlert().dismiss();
	}

	// Navigate Methods
	public Navigation pageNavigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}

	public void navigateToUrl(String url) {
		pageNavigate().to(url);
	}

	public void navigateToFrontPage() {
		pageNavigate().forward();
	}

	public void navigateToBackPage() {
		pageNavigate().back();
	}

	public void pageRefresh() {
		pageNavigate().refresh();
	}

	// Is Methods
	public void displayed(WebElement element, String txt) {
		if (element.isDisplayed() == true) {
			element.sendKeys(txt);
		}
	}

	public void enabled(WebElement element, String txt) {
		if (element.isEnabled() == true) {
			element.sendKeys(txt);
		}
	}

	public void selected(WebElement element, String txt) {
		System.out.println(element.isSelected());
	}

	// JavaScriptExecutor
	public void jsInsert(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void jsGetAttributeValue(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object obj = js.executeScript("return arguments[0].getAttribute('value')", element);
		String s = (String) obj;
		System.out.println(s);
	}

	public void jsScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void jsScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// Windows Handling
	public String windowsHandle() {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		return parent;
	}

	public Set<String> windowHandles() {
		Set<String> allWind = driver.getWindowHandles();
		for (String x : allWind) {
			System.out.println(x);
		}
		return allWind;
	}

	public void switchtowindow() {
		String s1 = driver.getWindowHandle();
		Set<String> s2 = driver.getWindowHandles();
		for (String x : s2) {
			if (!s1.equals(s2)) {
				driver.switchTo().window(x);
			}
		}
	}

	// frames
	public void frameSwitchById(String id) {
		switchToElement().frame(id);
	}

	public void frameSwitchByName(String name) {
		switchToElement().frame(name);
	}

	public void frameSwitchByWebElement(String element) {
		switchToElement().frame(element);
	}

	public void frameSwitchByIndex(int i) {
		switchToElement().frame(i);
	}

	// Waits
	public void implicitWaits(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// Get Data from Excel Sheet

	// public String getDataFromExcel(String excelLoc, String sName, int sNo, int
	// rNo) throws IOException {

	/*
	 * String value = null; File loc = new File(excelLoc); FileInputStream fIn = new
	 * FileInputStream(loc); Workbook w = new XSSFWorkbook(fIn); Sheet s =
	 * w.getSheet(sName); Row r = s.getRow(sNo); Cell c = r.getCell(rNo);
	 * 
	 * int cType = c.getCellType(); // 1=String, 0=integer if (cType == 1) { value =
	 * c.getStringCellValue(); } else if (cType == 0) { if
	 * (DateUtil.isCellDateFormatted(c)) { Date dateCellValue =
	 * c.getDateCellValue(); SimpleDateFormat sDF = new
	 * SimpleDateFormat("dd/MM/yyy"); value = sDF.format(dateCellValue); } else {
	 * double d = c.getNumericCellValue(); long l = (long) d; value =
	 * String.valueOf(l); } } return value;
	 */
	// }
	public WebElement sendkeysViaActiveElement(String data) {
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys(data);
		return activeElement;
	}

	public void switchToFrame(WebElement element) {

		driver.switchTo().frame(element);

	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	public byte[] getScreenshot() {
		TakesScreenshot tk = (TakesScreenshot) driver;
		byte[] bs = tk.getScreenshotAs(OutputType.BYTES);
		return bs;
	}

	public String getDataFromDataTable(DataTable d, int index, String key) {
		List<Map<String, String>> list = d.asMaps();
		Map<String, String> map = list.get(index);
		String x = map.get(key);
		return x;
	}

	public void navigateRefresh() {
		driver.navigate().refresh();

	}

	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public WebDriverWait waitExplicitlyForVisibilityAll(int seconds, List<WebElement> list) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		eWait.until(ExpectedConditions.visibilityOfAllElements(list));
		return eWait;
	}

	public WebDriverWait waitExplicitlyForVisibility(int seconds, WebElement element) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		eWait.until(ExpectedConditions.visibilityOf(element));
		return eWait;
	}

	public WebElement waitExplicitlyForElementTobeClickable(WebElement element, int seconds) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		WebElement webElement = eWait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}

	public Boolean waitExplicitlyForElementSelectionStateToBe(WebElement element, int seconds) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		Boolean webElement = eWait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
		return webElement;
	}

	public Wait<WebDriver> waitFluent(int timeoutInSeconds, int pollingInSeconds, WebElement element) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofSeconds(pollingInSeconds))
				.ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
		return fWait;
	}

	public static String getProjectpath() {
		String path = System.getProperty("user.dir");
		return path;

	}

	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	
	/*public String getPropertyFileValue2(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\Users\\Dell\\eclipse-workspace2\\OMRBranchHotelAutomation\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;
	}*/

	public static void getDriver(String browserType) {
			switch (browserType) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				break;
			case "ie":
				WebDriverManager.iedriver().setup();
				driver= new InternetExplorerDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				break;

			default:
				break;
			}
		}

	public byte[] screeshot() {
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
		return bs;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
