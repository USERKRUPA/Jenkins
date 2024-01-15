package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilMethods {
	static WebDriver driver;
	public static WebDriver LaunchBrowser(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static void testTextBox(WebDriver driver, By locator, String value) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(value);
	}
	
	public static void selectDDByValue(WebDriver driver, By locator, String value) {
		WebElement element = driver.findElement(locator);
		Select ddlitems = new Select(element);
		List<WebElement> options = ddlitems.getOptions();
		for(WebElement option : options) {
			if(option.getAttribute("value").equalsIgnoreCase(value)) {
				ddlitems.selectByValue(value);
				break;
			}
		}
	}
	
	public static void selectDDByText(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		Select ddlitems = new Select(element);
		List<WebElement> options = ddlitems.getOptions();
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase(text)) {
				ddlitems.selectByVisibleText(text);
				break;
			}
		}
	}
	
	public static void selectRadio(WebDriver driver, By locator, String value) {
		List<WebElement> radios = driver.findElements(locator);
		for(WebElement radio : radios) {
			if(radio.getAttribute("value").equalsIgnoreCase(value)) {
				
				if (radio.isEnabled()) {
				    radio.click();
				} else {
				    System.out.println("Radio button is not enabled.");
				}

				System.out.println(radio.getAttribute("value"));
				//break;
			}
		}	
	}
	
	public static void clickButton(WebDriver driver, By locator, String text) {
		WebElement element = driver.findElement(locator);
		System.out.println(element.getText());
		element.click();
	}
	
	public static void closeResources() {
		driver.close();
	}
}
 