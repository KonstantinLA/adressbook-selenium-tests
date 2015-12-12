package com.example.tests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

	private static WebDriver driver;
	private static String baseUrl;
	private static StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8443/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	protected void returnToGroupsPage() {
	    driver.findElement(By.linkText("group page")).click();
	}

	protected void submitCreationForm() {
	    driver.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
	    driver.findElement(By.name("group_name")).sendKeys(group.name);
	    driver.findElement(By.name("group_header")).clear();
	    driver.findElement(By.name("group_header")).sendKeys(group.header);
	    driver.findElement(By.name("group_footer")).clear();
	    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
	}

	protected void initGroupCreation() {
	    driver.findElement(By.name("new")).click();
	}

	protected void goToGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
	}

	protected void openMainPage() {
	    driver.get(baseUrl + "/addressbookv4.1.4/");
	}

	protected void goToAddNewPage() {
		driver.findElement(By.linkText("add new")).click();
	}

	protected void fillAddNewContactForm(NewContactData newContact) {
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(newContact.firstName);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(newContact.lastName);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys(newContact.adress);
		driver.findElement(By.name("home")).clear();
		driver.findElement(By.name("home")).sendKeys(newContact.homePhone);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(newContact.mobilePhone);
		driver.findElement(By.name("work")).clear();
		driver.findElement(By.name("work")).sendKeys(newContact.workPhone);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(newContact.mainEmail);
		driver.findElement(By.name("email2")).clear();
		driver.findElement(By.name("email2")).sendKeys(newContact.secondEmail);
		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(newContact.birthDay);
		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(newContact.birthMonth);
		driver.findElement(By.name("byear")).clear();
		driver.findElement(By.name("byear")).sendKeys(newContact.birthYear);
		new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(newContact.group);
		driver.findElement(By.name("address2")).clear();
		driver.findElement(By.name("address2")).sendKeys(newContact.secondAdress);
		driver.findElement(By.name("phone2")).clear();
		driver.findElement(By.name("phone2")).sendKeys(newContact.home);
	}

	protected void returnToHomePage() {
		driver.findElement(By.linkText("home page")).click();
	}
}
