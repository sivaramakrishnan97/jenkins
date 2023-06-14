package com.baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OMRLibGlobal {

	public static WebDriver driver;

	public void launchChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	}

	public void launchUrlAndMax(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void waits(int i) {
		Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
	}

	public void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public WebElement sendkeysViaActiveElement(String data) {
		WebElement activeElement = driver.switchTo().activeElement();
		activeElement.sendKeys(data);
		return activeElement;
	}

}
