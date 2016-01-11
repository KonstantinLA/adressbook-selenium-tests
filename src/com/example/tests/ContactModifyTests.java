package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromEditPage(NewContactData contactData){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().initEditContact(index);
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		oldList.remove(index);
		oldList.add(contactData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
		
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromDetailsPage(NewContactData contactData){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		app.getContactHelper().initDetailsContact(index);
		app.getContactHelper().goToModifyContact();
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
