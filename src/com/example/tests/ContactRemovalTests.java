package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().goToHomePage();
		
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		app.getContactHelper().initEditContact(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
