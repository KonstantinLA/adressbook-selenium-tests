package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {
	
	@Test
	public void modifySomeContactFromEditPage(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().initEditContact(index);
		NewContactData contactData = new NewContactData();
		contactData.firstName = "New First Name";
		contactData.lastName = "New Last Name";
		contactData.mainEmail = "new_email@test.test";
		contactData.homePhone = "0123456";
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		oldList.remove(index);
		oldList.add(contactData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
		
	}
	
	@Test
	public void modifySomeContactFromDetailsPage(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		app.getContactHelper().initDetailsContact(index);
		app.getContactHelper().goToModifyContact();
		NewContactData contactData = new NewContactData();
		contactData.firstName = "New First Name";
		contactData.lastName = "New Last Name";
		contactData.mainEmail = "new_email@test.test";
		contactData.homePhone = "0123456";
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		oldList.remove(index);
		oldList.add(contactData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	

}
