package autotestingproject.tests;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import autotestingproject.pages.Sortable;

public class SortableTest {
	public ArrayList<Integer> runTest(WebDriver driver){
		Sortable testPage = new Sortable(driver);
		testPage.goToSortablePage();
		testPage.bubbleSort();
		return testPage.getNumberOrder();
	}
}
