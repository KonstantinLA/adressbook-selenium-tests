package com.example.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	
  @DataProvider
  public Iterator<Object[]> contactsFromFile() throws IOException {
			return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		}
	
  @Test(dataProvider = "contactsFromFile")
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

