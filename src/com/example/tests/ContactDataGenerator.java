package com.example.tests;

import static com.example.tests.GroupDataGenerator.generateRandomString;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if(args.length < 3){
			System.out.println("Plese specify parameters: <amount of test data> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if(file.exists()){
			System.out.println("file exists, please remove it manually" + file);
			return;
		}
		
		List<NewContactData> groups = generateRandomContacts(amount);
		if(format.equals("csv")){
			saveContactsToCsvFile(groups, file);
		} else if(format.equals("xml")){
			saveContactsToXmlFile(groups, file);
		} else {
			System.out.println("Unkonwn format " + format);
			return;
		}

	}

	private static void saveContactsToXmlFile(List<NewContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<NewContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("group", NewContactData.class);
		return (List<NewContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCsvFile(List<NewContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (NewContactData contact : contacts) {
			writer.write(contact.getAdress() + "," + contact.getBirthDay() + "," + contact.getBirthMonth() + "," + contact.getBirthYear() + "," + contact.getFirstName() + "," + contact.getGroup() + "," + contact.getHome() + "," + contact.getHomePhone() + "," + contact.getLastName() + "," + contact.getMainEmail() + "," + contact.getMobilePhone() + "," + contact.getSecondAdress() + "," + contact.getSecondEmail() + "," + contact.getSecondEmail() + ",!" + "\n");
		}
		writer.close();
	}
	
	public static List<NewContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<NewContactData> list = new ArrayList<NewContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while(line != null){
			String[] part = line.split(",");
			NewContactData contact = new NewContactData()
					.withAdress(part[0])
					.withBirthDay(part[1])
					.withBirthMonth(part[2])
					.withBirthYear(part[3])
					.withFirstName(part[4])
					.withHome(part[5])
					.withHomePhone(part[6])
					.withLastName(part[7])
					.withMainEmail(part[8])
					.withMobilePhone(part[9])
					.withSecondAdress(part[10])
					.withSecondEmail(part[11])
					.withWorkPhone(part[12]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<NewContactData> generateRandomContacts(int amount) {
		List<NewContactData> list = new ArrayList<NewContactData>();
		for(int i = 0; i < amount; i++){
			NewContactData newContact = new NewContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAdress(generateRandomString())
					.withHomePhone(generatePhoneNumber())
					.withMobilePhone(generatePhoneNumber())
					.withWorkPhone(generatePhoneNumber())
					.withMainEmail(generateEmail())
					.withSecondEmail(generateEmail())
					.withBirthDay(generateBirthDate().get(0))
					.withBirthMonth(generateBirthDate().get(1))
					.withBirthYear(generateBirthDate().get(2))
					.withSecondAdress(generateRandomString())
					.withHome(generateRandomString());
		    list.add(newContact);
		}
		return list;
	}
	
	private static String generatePhoneNumber(){
		Random rnd = new Random();
		String phone = "";
		phone += rnd.nextInt(Integer.MAX_VALUE);
		return phone;
	}
	
	private static String generateEmail(){
		String email = "";
		email = String.format("%s@%s.test", RandomStringUtils.randomAlphabetic(7),RandomStringUtils.randomAlphabetic(7));
		return email;
	}
	
	private static List<String> generateBirthDate(){
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
