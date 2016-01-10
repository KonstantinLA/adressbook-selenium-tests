package com.example.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class ContactCreationTests extends TestBase {
	
  @Test
  public void testNewContactCreation() throws Exception {
	  	app.getNavigationHelper().openMainPage();
	  	app.getNavigationHelper().goToHomePage();
	  	
	  	List<NewContactData> oldList = app.getContactHelper().getContacts();

	    app.getContactHelper().goToAddNewPage();
	    NewContactData newContact = new NewContactData();
	    newContact.firstName = "FirstName";
	    newContact.lastName = "LastName";
	    newContact.adress = "adress";
	    newContact.homePhone = "123456";
	    newContact.mobilePhone = "1234567";
	    newContact.workPhone = "12345678";
	    newContact.mainEmail = "email@test.test";
	    newContact.secondEmail = "email2@test.test";
	    newContact.birthDay = "3";
	    newContact.birthMonth = "May";
	    newContact.birthYear = "1980";
	    newContact.group = 2;
	    newContact.secondAdress = "second adress";
	    newContact.home = "home";
	    app.getContactHelper().fillAddNewContactForm(newContact);
	    app.getContactHelper().submitCreationForm();
	    app.getContactHelper().returnToHomePage();
	    
	    List<NewContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.add(newContact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
  }
}

