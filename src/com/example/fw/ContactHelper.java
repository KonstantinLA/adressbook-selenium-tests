package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.NewContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean EDIT = true;
	public static boolean DETAILS = false;
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
		
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@name='entry']"));
		for (WebElement row : rows) {
			String lastName = row.findElement(By.xpath("td[2]")).getText();
			String firstName = row.findElement(By.xpath("td[3]")).getText();
			String mainEmail = row.findElement(By.xpath("td[4]")).getText();
			String homePhone = row.findElement(By.xpath("td[5]")).getText();
			NewContactData contact =  new NewContactData();
			contact.withLastName(lastName)
				.withFirstName(firstName)
				.withMainEmail(mainEmail)
				.withHomePhone(homePhone);
			cachedGroups.add(contact);
		}
	}
	
	public ContactHelper createNewContact(NewContactData newContact) {
		goToAddNewPage();
	    fillAddNewContactForm(newContact);
	    submitCreationForm();
	    returnToHomePage();
	    rebuildCache();
		return this;
	}
	
	public ContactHelper modifyContact(int index, NewContactData contactData, boolean modifyPage) {
		if(modifyPage == EDIT){
			initEditContact(index);
		} else {
			if(modifyPage == DETAILS){
			initDetailsContact(index);
			}
		}
		fillAddNewContactForm(contactData);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initEditContact(index);
		submitContactDeletion();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper fillAddNewContactForm(NewContactData newContact) {
		type(By.name("firstname"), newContact.getFirstName());
		type(By.name("lastname"), newContact.getLastName());
		type(By.name("address"), newContact.getAdress());
		type(By.name("home"), newContact.getHome());
		type(By.name("mobile"), newContact.getMobilePhone());
		type(By.name("work"), newContact.getWorkPhone());
		type(By.name("email"), newContact.getMainEmail());
		type(By.name("email2"), newContact.getSecondEmail());
		selectByText(By.name("bday"), newContact.getBirthDay());
		selectByText(By.name("bmonth"), newContact.getBirthMonth());
		type(By.name("byear"), newContact.getBirthYear());
		selectByIndex(By.name("new_group"), newContact.getGroup());
		type(By.name("address2"), newContact.getSecondAdress());
		type(By.name("phone2"), newContact.getHome());
		return this;
	}

	public ContactHelper goToAddNewPage() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	public ContactHelper submitCreationForm() {
	    click(By.name("submit"));
	    cachedGroups = null;
	    return this;
	}
	
	public ContactHelper initEditContact(int index){
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]//a[contains(@href,'edit')]"));
		return this;
	}
	
	public ContactHelper initDetailsContact(int index){
		click(By.xpath("//tr[@name='entry'][" + (index+1) + "]//a[contains(@href,'view')]"));
		goToModifyContact();
		return this;
	}
	
	public ContactHelper submitContactModification(){
		click(By.name("update"));
		return this;
	}
	
	public ContactHelper goToModifyContact(){
		click(By.name("modifiy"));
		return this;
	}
	
	public ContactHelper submitContactDeletion(){
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}
}
