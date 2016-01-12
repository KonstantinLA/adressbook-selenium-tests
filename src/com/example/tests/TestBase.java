package com.example.tests;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.Stop();
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i = 0; i < 5; i++){
			GroupData group = new GroupData()
				.withName(generateRandomString())
				.withHeader(generateRandomString())
				.withFooter(generateRandomString());
		    list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		for(int i = 0; i < 5; i++){
			NewContactData newContact = new NewContactData();
			newContact.firstName = generateRandomString();
			newContact.lastName = generateRandomString();
			newContact.adress = generateRandomString();
			newContact.homePhone = generatePhoneNumber();
			newContact.mobilePhone = generatePhoneNumber();
			newContact.workPhone = generatePhoneNumber();
			newContact.mainEmail = generateEmail();
			newContact.secondEmail = generateEmail();
			newContact.birthDay = generateBirthDate().get(0);
			newContact.birthMonth = generateBirthDate().get(1);
			newContact.birthYear = generateBirthDate().get(2);
			newContact.secondAdress = generateRandomString();
			newContact.home = generateRandomString();
			
		    list.add(new Object[]{newContact});
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();
		if(rnd.nextInt(3)==0){
			return "";
		} else{
			return "test" + rnd.nextInt();
		}
	}
	
	public String generatePhoneNumber(){
		Random rnd = new Random();
		String phone = "";
		phone += rnd.nextInt(Integer.MAX_VALUE);
		return phone;
	}
	
	public String generateEmail(){
		String email = "";
		email = String.format("%s@%s.test", RandomStringUtils.randomAlphabetic(7),RandomStringUtils.randomAlphabetic(7));
		return email;
	}
	
	public List<String> generateBirthDate(){
		List<String> birthDate = new ArrayList<>();
		String day = "";
		String month = "";
		String year = "";
		Random rnd = new Random();
		day += rnd.nextInt(29);
		if(day.equals("0")){
			day = "1";
		}
		birthDate.add(day);
		Date date = new Date();
		String strDateFormat = "MMMM";
		SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat, Locale.US);
		month = sdf.format(date);
		birthDate.add(month);
		year = Year.of(1900 + rnd.nextInt(100)).toString();
		birthDate.add(year);
		
		return birthDate;
	}
}
