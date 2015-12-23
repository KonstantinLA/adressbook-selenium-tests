package com.example.tests;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {
	
	@Test
	public void modifySomeContactFromEditPage(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initEditContact(1);
		NewContactData contactData = new NewContactData();
		contactData.firstName = "New First Name";
		contactData.lastName = "New Last Name";
		contactData.mainEmail = "new_email@test.test";
		contactData.homePhone = "0123456";
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
	}
	
	@Test
	public void modifySomeContactFromDetailsPage(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initDetailsContact(1);
		app.getContactHelper().goToModifyContact();
		NewContactData contactData = new NewContactData();
		contactData.firstName = "New First Name";
		contactData.lastName = "New Last Name";
		contactData.mainEmail = "new_email@test.test";
		contactData.homePhone = "0123456";
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
	

}
