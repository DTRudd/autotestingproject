package autotestingproject.pages;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	private WebDriver driver;
	
	private WebElement curElem;
	private WebElement nextElem;
	
	public Sortable(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setCurElem(int placeNum){
		curElem = driver.findElement(By.xpath("//li[" + placeNum + "]"));
	}
	public void setNextElem(int placeNum){
		nextElem = driver.findElement(By.xpath("//li[" + (placeNum + 1) + "]"));
	}
	
	public Actions dragToPlace(WebDriver driver, int placeNum){
		Actions builder = new Actions(driver);
		if (placeNum % 4 == 0){
			builder.dragAndDrop(curElem, nextElem);
		} else {
			builder.dragAndDropBy(curElem, 150, 0);
		}
		return builder;
	}
	
	public void bubbleSort(){
		try {
		boolean unSorted = true;
		while (unSorted){
			unSorted = false;
			for(int ii = 1; ii < 12; ii++){
				setCurElem(ii);
				setNextElem(ii);
				if (Integer.parseInt(curElem.getText()) > Integer.parseInt(nextElem.getText())){
					unSorted = true;
					dragToPlace(driver, ii).perform();
				}
			}
		}
		} catch (NoSuchElementException enfe){
			System.out.println(enfe.getMessage());
		}
	}
	
	public ArrayList<Integer> getNumberOrder(){
		ArrayList<Integer> outp = new ArrayList<Integer>();
		for(int ii = 1; ii < 13; ii++){
			setCurElem(ii);
			outp.add(Integer.parseInt(curElem.getText()));
		}
		return outp;
	}
	
	public void goToSortablePage(){
		driver.get("C:\\Users\\Administrator\\workspace\\HTML\\Sortable.html");
	}
}
