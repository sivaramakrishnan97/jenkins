package com.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.pages.BookHotelPage;
import com.pages.ExploreHotel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HotelBookingModify {
Select s;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		BookHotelPage b= new BookHotelPage();
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://omrbranch.com/");
		driver.manage().window().maximize();
		//WebDriverWait w=new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait w= new WebDriverWait(driver,10);
		
		driver.findElement(By.id("email")).sendKeys("sivaraman.drs@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("9677569677@Siva");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h3[@class='mt-4'])[2]")).click();
		//1
		WebElement state = driver.findElement(By.id("state"));
		Select s= new Select(state);
		s.selectByValue("Tamil Nadu");
		//Thread.sleep(3000);
		//driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//span[text()='Select City *']")).click();
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		// Thread.sleep(3000);
		//WebElement sel = driver.findElement(By.xpath("//textarea[@type='search']"));
		//driver.findElement(By.xpath("//li[text()='Luxury']")).click();
		//driver.findElement(By.xpath("//textarea[@type='search']")).click();
		//driver.findElement(By.xpath("//li[text()='Deluxe']")).click();
		driver.findElement(By.xpath("//textarea[@type='search']")).click();
		driver.findElement(By.xpath("//li[text()='Suite']")).click();
		
		WebElement checkIn = driver.findElement(By.name("check_in"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','2023-05-19')",checkIn);
		
		WebElement checkOut = driver.findElement(By.name("check_out"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].setAttribute('value','2023-05-22')",checkOut);

		WebElement rooms = driver.findElement(By.id("no_rooms"));
		s=new Select(rooms);
		s.selectByVisibleText("1-One");
		WebElement adults = driver.findElement(By.id("no_adults"));
		s=new Select(adults);
		s.selectByVisibleText("1-One");
		driver.findElement(By.id("no_child")).sendKeys("3");
		driver.switchTo().frame("hotelsearch_iframe");
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		//2
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		driver.switchTo().alert().accept();
		
		//3 
		//Thread.sleep(3000);
		driver.findElement(By.id("own")).click();
		WebElement select = driver.findElement(By.id("user_title"));
		s=new Select(select);
		s.selectByVisibleText("Mr.");
		driver.findElement(By.id("first_name")).sendKeys("siva");
		driver.findElement(By.id("last_name")).sendKeys("kumar");
		driver.findElement(By.id("user_phone")).sendKeys("9216549871");
		driver.findElement(By.id("user_email")).sendKeys("siva@gmail.com");
		driver.findElement(By.id("step1next")).click();
		
		//4 
		driver.findElement(By.id("high")).click();
		driver.findElement(By.id("other_request")).sendKeys("With valet parking");
		driver.findElement(By.id("step2next")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//p[text()='Visa, MasterCard, Amex, Discover']")).click();
		Thread.sleep(4000);
		b.enterCardDetails("Credit Card", "Visa", "5555555555552223", "si", "January", "2023", "123");
		
		//5 
		driver.findElement(By.xpath("//h5[text()='UPI']")).click();
		
		WebElement pay = driver.findElement(By.id("payment_type"));
		s=new Select(pay);
		s.selectByVisibleText("Debit Card");
		WebElement cardType = driver.findElement(By.id("card_type"));
		s=new Select(cardType);
		s.selectByVisibleText("Visa");
		driver.findElement(By.id("card_no")).sendKeys("5555555555552222");
		driver.findElement(By.id("card_name")).sendKeys("siva");
		WebElement cardMon = driver.findElement(By.id("card_month"));
		s=new Select(cardMon);
		s.selectByVisibleText("February");
		WebElement cardYear = driver.findElement(By.id("card_year"));
		s=new Select(cardYear);
		s.selectByVisibleText("2024");
		driver.findElement(By.id("cvv")).sendKeys("123");
		driver.findElement(By.id("submitBtn")).click();
		
		WebElement orderId = driver.findElement(By.xpath("//strong[contains(text(),'#')]"));
		String bookingId = orderId.getText();
		System.out.println("Booking Id"+bookingId);
		
		
		driver.findElement(By.xpath("//a[@data-testid='username']")).click();
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
		String substring = bookingId.substring(1, bookingId.length()-1);
		driver.findElement(By.name("search")).sendKeys(substring);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	//	WebElement edit = w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]")));
	//	edit.click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		WebElement checkInup = driver.findElement(By.name("check_in"));
		JavascriptExecutor jsup=(JavascriptExecutor)driver;
		jsup.executeScript("arguments[0].setAttribute('value','2023-04-20')",checkInup);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		WebElement alertmsg = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String text = alertmsg.getText();
		System.out.println(text);
		
		driver.findElement(By.name("search")).sendKeys(substring);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Cancel'])[1]")).click();
		driver.switchTo().alert().accept();
		WebElement cancel = driver.findElement(By.xpath("//li[@class='alertMsg']"));
		String cancelText = cancel.getText();
		System.out.println(cancelText);
		
		
		
		
		
	}

	
	
	
	
	


}
