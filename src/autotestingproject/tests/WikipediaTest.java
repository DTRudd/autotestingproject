package autotestingproject.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import autotestingproject.pages.Wikipedia;

public class WikipediaTest {
	public void runTest(WebDriver driver){
		try{
			Wikipedia testPage = new Wikipedia(driver);
			testPage.goToMainPage();
			testPage.goToRandomPage();
			int jumps = 0;
			boolean reachedEndState = false;
			Pattern endStatePattern = Pattern.compile("((Ancient Greek)|(Latin)|(Greek language)) .*");
			
			while(!reachedEndState){
				testPage.waitUntilContentLoaded();
				Matcher endStateMatcher = endStatePattern.matcher(testPage.getTitle());
				
				if (endStateMatcher.find()){
					reachedEndState = true;
					System.out.println("Found page " + endStateMatcher.group(1) + " in " + jumps + " jumps.");
				} else {
					jumps++;
					if (jumps > 50){
						System.out.println("Timeout - loop likely found.  Restarting...");
						jumps = 0;
						testPage.goToRandomPage();
						continue;
					}
					testPage.clickFirstLink();
				}
				
			}
			
		} catch (ElementNotFoundException enfe){
			System.out.println(enfe.getMessage());
		}
	} 
}
