package autotestingproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoSite {

	private WebDriver driver;
	
	private By addUserLink = By.linkText("3. Add a User");
	private By loginLink = By.linkText("4. Login");
	private By finalSection = By.linkText("Now move on to the final section");
	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By formsButton2Field = By.name("FormsButton2");
	private By greenText = By.xpath("//font[@color=\"#008000\"]");
	public DemoSite(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToIndex(){
		driver.get("http://www.thedemosite.co.uk/index.php");
	}

	public void goToAddUserLink(){
		driver.findElement(addUserLink).click();
	}
	
	public void goToLoginLink(){
		driver.findElement(loginLink).click();
	}
	
	public void waitForAddUserPage(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(usernameField));
	}
	
	public void sendUsername(){
		driver.findElement(usernameField).sendKeys("test");
	}
	
	public void sendPassword(){
		driver.findElement(passwordField).sendKeys("test");
	}
	
	public void clickLoginButton(){
		driver.findElement(formsButton2Field).click();
	}
	
	public void waitForLoginPage(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(finalSection));
	}
	
	public void waitForSuccessfulLogin(){
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(greenText));
	}
	
	public String getSuccessString(){
		return driver.findElement(greenText).getText();
	}
}
