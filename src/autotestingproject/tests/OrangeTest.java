package autotestingproject.tests;

import autotestingproject.pages.OrangeSite;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrangeTest {

	public String runTest(WebDriver driver){
		OrangeSite testPage = new OrangeSite(driver);
		testPage.goToDemo();
		testPage.sendUsername();
		testPage.sendPassword();
		testPage.login();
		testPage.waitForNews();
		testPage.clickNewsStory();
		testPage.waitForArticle();
		String header = testPage.getHeader();
		testPage.switchToIFrame();
		List<WebElement> body = testPage.getBody();
		StringBuilder sb = new StringBuilder();
		for(WebElement we : body){
			sb.append(we.getText());
			sb.append("\n");
		}
		String bodyString = sb.toString();
		System.out.println(header);
		System.out.println(bodyString);
		testPage.switchToDefault();
		testPage.clickDashboardLink();
		testPage.waitForApplyLeaveText();
		testPage.clickApplyLeaveText();
		testPage.waitForApplyLeaveID();
		testPage.selectTestLeave();
		testPage.enterFromDate();
		testPage.enterToDate();
		testPage.enterComment();
		testPage.submitLeave();
		return header;
	}
}
