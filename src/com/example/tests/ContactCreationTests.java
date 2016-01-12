package com.example.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactCreation(NewContactData newContact) throws Exception {
	  	app.navigateTo().mainPage();
	  	
	  	//save old state
	  	List<NewContactData> oldList = app.getContactHelper().getContacts();
	  	
	  	//actions
	    app.getContactHelper().goToAddNewPage();
	    app.getContactHelper().fillAddNewContactForm(newContact);
	    app.getContactHelper().submitCreationForm();
	    app.getContactHelper().returnToHomePage();
	    
	    //save new state
	    List<NewContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.add(newContact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
  }
}

