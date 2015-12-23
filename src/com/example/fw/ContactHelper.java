package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.NewContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
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
		selectByText(By.name("new_group"), newContact.group);
		type(By.name("address2"), newContact.secondAdress);
		type(By.name("phone2"), newContact.home);
	}

	public void goToAddNewPage() {
		click(By.linkText("add new"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	public void submitCreationForm() {
	    click(By.name("submit"));
	}
	
	public void initEditContact(int index){
		click(By.xpath("//tr[@name='entry'][" + index + "]//a[contains(@href,'edit')]"));
	}
	
	public void initDetailsContact(int index){
		click(By.xpath("//tr[@name='entry'][" + index + "]//a[contains(@href,'view')]"));
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
