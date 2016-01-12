package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromEditPage(NewContactData contactData){
		app.navigateTo().mainPage();
		
		//save old state
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		//action
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().initEditContact(index);
		app.getContactHelper().fillAddNewContactForm(contactData);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		oldList.remove(index);
		oldList.add(contactData);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
		
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromDetailsPage(NewContactData contactData){
		app.navigateTo().mainPage();
		//app.navigateTo().goToHomePage();
		
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
