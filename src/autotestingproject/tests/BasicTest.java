package autotestingproject.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicTest {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\workspace\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\workspace\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.close();
	}
	
	
	
	
	


}
