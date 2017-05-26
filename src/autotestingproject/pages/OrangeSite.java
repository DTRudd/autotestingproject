package autotestingproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeSite {

    private WebDriver driver;

    public WebDriver getDriver(){
	return driver;
    }

    private By usernameLogin = By.id("txtUsername");
    private By passwordLogin = By.id("txtPassword");
    private By buttonLogin = By.id("btnLogin");
    private By newspanel = By.xpath("//table[@id=\"task-list-group-panel-slider-news\"]/tbody/tr/td/a");
    private By articleDisplayDiv = By.id("divArticleDisplay");
    private By article = By.id("articleId_10");
    private By paragraphs = By.id("//p");
    private By dashboard = By.id("menu_dashboard_index");
    private By applyLeaveText = By.linkText("Apply Leave");
    private By applyLeaveID = By.id("apply-leave");
    private By leaveType = By.id("applyleave_txtLeaveType");
    private By leaveFromDate = By.id("applyleave_txtFromDate");
    private By leaveToDate = By.id("applyleave_txtToDate");
    private By leaveComment = By.id("applyleave_txtComment");
    private By applyButton = By.id("applyBtn");

    public OrangeSite(WebDriver driver){
    	this.driver = driver;
    }

    public void goToDemo(){
    	driver.get("https://enterprise-demo.orangehrmlive.com");
    }

    public void sendUsername(){
    	driver.findElement(usernameLogin).sendKeys("anthony.nolan");
    }

    public void sendPassword(){
    	driver.findElement(passwordLogin).sendKeys("anthony.nolan");
    }

    public void login(){
    	driver.findElement(buttonLogin).submit();
    }

    public void waitForNews(){
    	(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(newspanel));
    }

    public void clickNewsStory(){
    	driver.findElement(newspanel).click();
    }

    public void waitForArticle(){
    	(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(articleDisplayDiv));
    }

    public String getHeader(){
    	return driver.findElement(article).getText();
    }

    public void switchToIFrame(){
    	driver.switchTo().frame(0);
    }

    public List<WebElement> getBody(){
    	return driver.findElements(paragraphs);
    }

    public void switchToDefault(){
    	driver.switchTo().defaultContent();
    }

    public void clickDashboardLink(){
    	driver.findElement(dashboard).click();
    }

    public void waitForApplyLeaveText(){
    	(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(applyLeaveText));
    }

    public void clickApplyLeaveText(){
    	driver.findElement(applyLeaveText).click();
    }

    public void waitForApplyLeaveID(){
    	(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(applyLeaveID));
    }

    public void selectTestLeave(){
    	new Select(driver.findElement(leaveType)).selectByVisibleText("Test Leave");
    }

    public void enterFromDate(){
    	driver.findElement(leaveFromDate).clear();
		driver.findElement(leaveFromDate).sendKeys("2018-07-01");
    }

    public void enterToDate(){
    	driver.findElement(leaveToDate).clear();
		driver.findElement(leaveToDate).sendKeys("2018-07-15");
    }

    public void enterComment(){
    	driver.findElement(leaveComment).sendKeys("Gardening.");
    }

    public void submitLeave(){
    	driver.findElement(applyButton).submit();
    }
}