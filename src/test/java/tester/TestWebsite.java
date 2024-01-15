package tester;

import static utils.UtilMethods.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestWebsite {
	
	@Test
	public void test() {
		WebDriver driver = LaunchBrowser("https://mytestingthoughts.com/Sample/home.html");
		testTextBox(driver, By.cssSelector("input[name='first_name']"), "ABC");
		//last_name
		testTextBox(driver, By.cssSelector("input[name='last_name']"), "ABC");
		testTextBox(driver, By.name("user_name"), "abcdefghi");
		testTextBox(driver, By.name("user_password"), "123456789");
		testTextBox(driver, By.name("confirm_password"), "123456789");
		testTextBox(driver, By.name("email"), "kk@gmail.com");
		testTextBox(driver, By.name("contact_no"), "(639)1234567");
		//contact_no
		
		//selectDDByValue(driver, By.name("nf-field-22"),"mobile-automation");
		
		selectDDByText(driver, By.cssSelector("select[name='department']"),"Tresurer's Office");
		
		selectRadio(driver, By.name("inlineRadioOptions"), "Male");
		
		clickButton(driver, By.className("btn-warning"), "        SUBMIT ");
		//closeResources();
	}

}
