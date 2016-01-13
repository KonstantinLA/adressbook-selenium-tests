package com.example.tests;

import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNewContactCreation(NewContactData newContact) throws Exception {
	  	
	  	//save old state
	  	SortedListOf<NewContactData> oldList = app.getContactHelper().getContacts();
	  	
	  	//actions
	  	app.getContactHelper().createNewContact(newContact);
	    
	    
	    //save new state
	  	SortedListOf<NewContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.withAdded(newContact)));
  }
}

