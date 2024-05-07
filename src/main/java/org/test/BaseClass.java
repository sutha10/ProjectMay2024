package org.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browserName) {

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new WebDriverException();

		}
		return driver;

	}

	public static String urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		return url;

	}

	public static void implicityWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}

	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
		

	}
	
	public static void sendKeys(WebElement e, String a) {
		e.sendKeys(a);// TODO Auto-generated method stub

	}

	public static void click(WebElement e) {
		e.click();
	}

	public static void refresh() {
	}
	
	public static void quit() {
		driver.quit();
	}
	

	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;

	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public static void dragAndDrop(WebElement Src, WebElement Tar) {
		Actions a = new Actions(driver);
		a.dragAndDrop(Src, Tar);
	}

	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);

	}

	public static void deselectByValue(WebElement e, String Value) {
		Select s = new Select(e);
		s.deselectByValue(Value);

	}

	
	
}
