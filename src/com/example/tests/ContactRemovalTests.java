package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		
		//save old state
		SortedListOf<NewContactData> oldList = app.getContactHelper().getContacts();
		
		//action
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    app.getContactHelper().deleteContact(index);
		
		//save new state
		SortedListOf<NewContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		assertThat(newList, equalTo(oldList.without(index)));
	}

}
