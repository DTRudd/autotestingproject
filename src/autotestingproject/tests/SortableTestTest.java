package autotestingproject.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortableTestTest {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\workspace\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\workspace\\Selenium\\geckodriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}
	
	@Test
	public final void testRunTest() {
		SortableTest st = new SortableTest();
		ArrayList<Integer> outputList = st.runTest(driver);
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(Integer ii : outputList){
			sortedList.add(new Integer(ii));
		}
		Collections.sort(sortedList);
		assertEquals(sortedList,outputList);
	}

}
