package autotestingproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wikipedia {

	private By randomPage = By.xpath("//li[@id=\"n-randompage\"]/a");
	private By firstLink = By.xpath("//div[@id=\"mw-content-text\"]/p/a");
	private By contentPanel = By.id("mw-content-text");
	
	private WebDriver driver;
	
	public Wikipedia(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickFirstLink(){
		driver.findElement(firstLink).click();
	}
	
	public void goToRandomPage(){
		driver.findElement(randomPage).click();
	}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public void waitUntilContentLoaded(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(contentPanel));
	}
	
	public void goToMainPage(){
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}

}
