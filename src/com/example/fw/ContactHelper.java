package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.NewContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = true;
	private SortedListOf<NewContactData> cachedGroups;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public SortedListOf<NewContactData> getContacts(){
		if(cachedGroups == null){
			rebuildCache();
		}
		return cachedGroups;
	}
	
	private void rebuildCache() {
		cachedGroups = new SortedListOf<NewContactData>();
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name='entry']"));
		for (WebElement row : rows) {
			NewContactData contact =  new NewContactData();
			contact.lastName = row.findElement(By.xpath("td[2]")).getText();
			contact.firstName = row.findElement(By.xpath("td[3]")).getText();
			contact.mainEmail = row.findElement(By.xpath("td[4]")).getText();
			contact.homePhone = row.findElement(By.xpath("td[5]")).getText();
			cachedGroups.add(contact);
		}
	}

	public void fillAddNewContactForm(NewContactData newContact) {
		type(By.name("firstname"), newContact.firstName);
		type(By.name("lastname"), newContact.lastName);
		type(By.name("address"), newContact.adress);
		type(By.name("home"), newContact.homePhone);
		type(By.name("mobile"), newContact.mobilePhone);
		type(By.name("work"), newContact.workPhone);
		type(By.name("email"), newContact.mainEmail);
		type(By.name("email2"), newContact.secondEmail);
		selectByText(By.name("bday"), newContact.birthDay);
		selectByText(By.name("bmonth"), newContact.birthMonth);
		type(By.name("byear"), newContact.birthYear);
		selectByIndex(By.name("new_group"), newContact.group);
		type(By.name("address2"), newContact.secondAdress);
		type(By.name("phone2"), newContact.home);
	}

	public void goToAddNewPage() {
		click(By.linkText("add new"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
		rebuildCache();
	}
	
	public void submitCreationForm() {
	    click(By.name("submit"));
	}
	
	public void initEditContact(int index){
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]//a[contains(@href,'edit')]"));
	}
	
	public void initDetailsContact(int index){
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]//a[contains(@href,'view')]"));
	}
	
	public void submitContactModification(){
		click(By.name("update"));
	}
	
	public void goToModifyContact(){
		click(By.name("modifiy"));
	}
	
	public void deleteContact(){
		click(By.xpath("//input[@value='Delete']"));
	}
	
	
}
