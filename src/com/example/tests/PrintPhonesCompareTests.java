package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class PrintPhonesCompareTests extends TestBase {
	
	@Test
	public void printPhoneCompareToContactList(){
		
	  	SortedListOf<PrintContactData> oldList = app.getPrintContactHelper().getContactsFromHomePage();
		SortedListOf<PrintContactData> newList = app.getPrintContactHelper().getContactsFromPrintPhonesPage();
		assertThat(newList, equalTo(oldList));
	}

}
