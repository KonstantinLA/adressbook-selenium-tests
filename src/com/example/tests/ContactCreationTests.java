package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	
	
	
	
  @Test
  public void testNewContactCreation() throws Exception {
	  	app.getNavigationHelper().openMainPage();
	    app.getContactHelper().goToAddNewPage();
	    NewContactData newContact = new NewContactData();
	    newContact.firstName = "First name";
	    newContact.lastName = "Lirst name";
	    newContact.adress = "adress";
	    newContact.homePhone = "123456";
	    newContact.mobilePhone = "1234567";
	    newContact.workPhone = "12345678";
	    newContact.mainEmail = "email@test.test";
	    newContact.secondEmail = "email2@test.test";
	    newContact.birthDay = "3";
	    newContact.birthMonth = "May";
	    newContact.birthYear = "1980";
	    newContact.group = "group 1";
	    newContact.secondAdress = "second adress";
	    newContact.home = "home";
	    app.getContactHelper().fillAddNewContactForm(newContact);
	    app.getContactHelper().submitCreationForm();
	    app.getContactHelper().returnToHomePage();
  }
}

