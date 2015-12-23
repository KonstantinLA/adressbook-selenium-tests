package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		app.getContactHelper().initEditContact(1);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}

}
