package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.navigateTo().mainPage();
		
		//save old state
		List<NewContactData> oldList = app.getContactHelper().getContacts();
		
		//action
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
		app.getContactHelper().initEditContact(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		
		//save new state
		List<NewContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
