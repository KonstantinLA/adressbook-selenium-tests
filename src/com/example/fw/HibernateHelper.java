package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.GroupData;
import com.example.tests.NewContactData;
import com.example.utils.SortedListOf;

public class HibernateHelper extends HelperBase {

	public HibernateHelper(ApplicationManager manager) {
	  super(manager);
	}

	public List<GroupData> listGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<GroupData>(
              (List<GroupData>) session.createQuery("from GroupData").list());
		} finally {
          trans.commit();
		}
	}
	
	public List<NewContactData> listContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
          return new SortedListOf<NewContactData>(
              (List<NewContactData>) session.createQuery("from NewContactData").list());
		} finally {
          trans.commit();
		}
	}
}
