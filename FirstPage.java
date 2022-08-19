package org.geo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstPage {
	public static WebDriver driver;

	@BeforeClass
	public static void ChromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterTest()
	public static void getURL(String url) {
		driver.get(url);

	}

	@AfterTest
	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void values(WebElement e, String s) {
		e.sendKeys(s);

	}

}
