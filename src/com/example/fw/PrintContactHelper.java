package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.PrintContactData;
import com.example.utils.SortedListOf;
import java.util.regex.*;

public class PrintContactHelper extends WebDriverHelperBase {
	
	public PrintContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public SortedListOf<PrintContactData> getContactsFromHomePage() {
		SortedListOf<PrintContactData> contacts = new SortedListOf<PrintContactData>();
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name='entry']"));
		for (WebElement row : rows) {
			String lastName = row.findElement(By.xpath("td[2]")).getText();
			String firstName = row.findElement(By.xpath("td[3]")).getText();
			String homePhone = row.findElement(By.xpath("td[5]")).getText();
			String firstAndLastName;
			if(firstName.equals("")){
				firstAndLastName = lastName;
			} else {
				firstAndLastName = firstName + " " + lastName;
			}
			contacts.add(new PrintContactData().withFirstAndLastName(firstAndLastName).withHomePhone(homePhone));
		}
		
		return contacts;
	}
	
	public SortedListOf<PrintContactData> getContactsFromPrintPhonesPage() {
		SortedListOf<PrintContactData> contacts = new SortedListOf<PrintContactData>();
		
		manager.navigateTo().printPhonesPage();
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='view']/tbody/tr/td[@valign='top']"));
		for (WebElement cell : cells) {
			String firstAndLastName = cell.findElement(By.tagName("b")).getText();
			String contactPrint = cell.getText();
			String homePhone = getHomePhone(contactPrint);
			String phone = homePhone.substring("H: ".length(), (homePhone.length()-"\n".length()));
			contacts.add(new PrintContactData().withFirstAndLastName(firstAndLastName).withHomePhone(phone));
		}
		
		return contacts;
	}
	
	private String getHomePhone(String contactPrint){
		Pattern regex = Pattern.compile("H:\\s*\\w*[\\w*\\-*]+w*\\\n");
		Matcher matcher = regex.matcher(contactPrint);
		if(matcher.find()){
			return matcher.group();
		} else {
			return "";
		}
	}
}
