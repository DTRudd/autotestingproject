package autotestingproject.tests;

import org.openqa.selenium.WebDriver;

import autotestingproject.pages.DemoSite;

public class DemoTest {
	public String runTest(WebDriver driver){
		DemoSite testPage = new DemoSite(driver);
		testPage.goToIndex();
		testPage.goToAddUserLink();
		testPage.waitForAddUserPage();
		testPage.sendUsername();
		testPage.sendPassword();
		testPage.clickLoginButton();
		testPage.goToLoginLink();
		testPage.waitForLoginPage();
		testPage.sendUsername();
		testPage.sendPassword();
		testPage.clickLoginButton();
		testPage.waitForSuccessfulLogin();
		String success = testPage.getSuccessString();
		return success;
	}
}
