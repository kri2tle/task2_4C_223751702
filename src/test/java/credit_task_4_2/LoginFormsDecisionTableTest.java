package credit_task_4_2;

import org.junit.Test;
import org.junit.Assert;

public class LoginFormsDecisionTableTest {
	
	public static String validEmail = "kixahe8017@buzblox.com", validPassword = "#Test@2024", invalidEmail = "invalidemail@gmail.com", invalidPassword = "invalidPassword";
	public static String blankExpectedResponse = "Please correct the highlighted errors", invalidExpectedResponse = "Your email address or password is incorrect.", validExpectedResponse = "Success";
	
	@Test
	public void testStudentIdentity() {
		String studentId = "223751702";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Krishna";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testBlankEmailBlankPassword() {
		String response = LoginForms.bunnings_login("",""); 
		System.out.println("\n--testBlankEmailBlankPassword--\nExpected response: " + blankExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(blankExpectedResponse, response);
	}
	
	@Test
	public void testBlankEmailInvalidPassword() {
		String response = LoginForms.bunnings_login("", invalidPassword); 
		System.out.println("\n--testBlankEmailInvalidPassword--\nExpected response: " + blankExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(blankExpectedResponse, response);
	}
	
	@Test
	public void testBlankEmailValidPassword() {
		String response = LoginForms.bunnings_login("", validPassword); 
		System.out.println("\n--testBlankEmailValidPassword--\nExpected response: " + blankExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(blankExpectedResponse, response);
	}
	
	@Test
	public void testInvalidEmailBlankPassword() {
		String response = LoginForms.bunnings_login(invalidEmail, ""); 
		System.out.println("\n--testInvalidEmailBlankPassword--\nExpected response: " + blankExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(blankExpectedResponse, response);
	}
	
	@Test
	public void testInvalidEmailInvalidPassword() {
		String response = LoginForms.bunnings_login(invalidEmail, invalidPassword); 
		System.out.println("\n--testInvalidEmailInvalidPassword--\nExpected response: " + invalidExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(invalidExpectedResponse, response);
	}
	
	@Test
	public void testInvalidEmailValidPassword() {
		String response = LoginForms.bunnings_login(invalidEmail, validPassword); 
		System.out.println("\n--testInvalidEmailValidPassword--\nExpected response: " + invalidExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(invalidExpectedResponse, response);
	}
	
	@Test
	public void testValidEmailBlankPassword() {
		String response = LoginForms.bunnings_login(validEmail, ""); 
		System.out.println("\n--testValidEmailBlankPassword--\nExpected response: " + blankExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(blankExpectedResponse, response);
	}
	
	@Test
	public void testValidEmailInvalidPassword() {
		String response = LoginForms.bunnings_login(validEmail, invalidPassword); 
		System.out.println("\n--testValidEmailInvalidPassword--\nExpected response: " + invalidExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(invalidExpectedResponse, response);
	}
	
	@Test
	public void testValidEmailValidPassword() {
		String response = LoginForms.bunnings_login(validEmail, validPassword); 
		System.out.println("\n--testValidEmailValidPassword--\nExpected response: " + validExpectedResponse + "\nActual response: " + response + "\n");
		Assert.assertEquals(validExpectedResponse, response);
	}
}
