package com.example.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactCreation(NewContactData newContact) throws Exception {
	  	app.getNavigationHelper().openMainPage();
	  	app.getNavigationHelper().goToHomePage();
	  	
	  	List<NewContactData> oldList = app.getContactHelper().getContacts();

	    app.getContactHelper().goToAddNewPage();
	    app.getContactHelper().fillAddNewContactForm(newContact);
	    app.getContactHelper().submitCreationForm();
	    app.getContactHelper().returnToHomePage();
	    
	    List<NewContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.add(newContact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
  }
}

