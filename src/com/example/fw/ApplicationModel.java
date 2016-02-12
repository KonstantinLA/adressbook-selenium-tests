package com.example.fw;

import java.util.List;

import com.example.tests.GroupData;
import com.example.tests.NewContactData;
import com.example.utils.SortedListOf;

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	private SortedListOf<NewContactData> contacts;
	
	public SortedListOf<GroupData> getGroups(){
		return groups;
	}
	
	public void setGroups(List<GroupData> groups){
		this.groups = new SortedListOf<GroupData>(groups);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
	
	public SortedListOf<NewContactData> getContacts(){
		return contacts;
	}
	
	public void setContacts(List<NewContactData> contacts){
		this.contacts = new SortedListOf<NewContactData>(contacts);
	}

	public ApplicationModel addContact(NewContactData contact) {
		contacts.add(contact);
		return this;
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}

}
