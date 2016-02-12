package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static com.example.fw.ContactHelper.EDIT;
import static com.example.fw.ContactHelper.DETAILS;
import com.example.utils.SortedListOf;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModifyTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromEditPage(NewContactData contactData){
		
		//save old state
		SortedListOf<NewContactData> oldList = app.getContactHelper().getUiContacts();
		
		//action
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
	    app.getContactHelper().modifyContact(index, contactData, EDIT);
		
		//save new state
	    SortedListOf<NewContactData> newList = app.getContactHelper().getUiContacts();
		
		//compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contactData)));
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactFromDetailsPage(NewContactData contactData){
		
		//save old state
		SortedListOf<NewContactData> oldList = app.getContactHelper().getUiContacts();
		
		//action
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    app.getContactHelper().modifyContact(index, contactData, DETAILS);
		
	    //save new state
	    SortedListOf<NewContactData> newList = app.getContactHelper().getUiContacts();
		
		//compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contactData)));
	}
	

}
