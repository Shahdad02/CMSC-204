/**
 * 
 * @author Shahdad Parsi
 *
 */
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		
		String[] passwordStr = {"Ex2b&", "stR75&aBbb", "W55555bhaa", 
								"f6yXmmmTyI", "09$5r"};
		
		passwords = new ArrayList<>(Arrays.asList(passwordStr));
	}

	@After
	public void tearDown() throws Exception {
		
		passwords = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			
			PasswordCheckerUtility.isValidPassword("TcA22");
			assertTrue("Length Exception not thrown", false);
		} catch(LengthException e) {
			
			assertTrue("Length Exception was thrown", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		
		try {
			
			PasswordCheckerUtility.isValidPassword("hellothistestisfun");
			assertTrue("No Upper Exception not thrown", false);
		} catch(NoUpperAlphaException e) {
			
			assertTrue("NoUpperAlphaException was thrown", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		
		try {
			
			PasswordCheckerUtility.isValidPassword("ALMOSTDONEWITHTHISSTUFF");
			assertTrue("No Lower Exception not thrown", false);
		} catch(NoLowerAlphaException e) {
			
			assertTrue("NoLowerAlphaException was thrown", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Wrong exception", false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		
		try {
			
			PasswordCheckerUtility.isValidPassword("TcA22");
			assertTrue("Weak Password Exception thrown", false);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Wrong exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			
			PasswordCheckerUtility.isValidPassword("Hello@123");
			assertTrue("InvalidSequenceException not thrown", false);
		} catch(InvalidSequenceException e) {
			
			assertTrue("InvalidSequenceException was thrown", true);
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			assertTrue("Wrong Exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			
			PasswordCheckerUtility.isValidPassword("akajfhakjBajkh");
			assertTrue("NoDigitException not thrown", false);
		} catch(NoDigitException e) {
			
			assertTrue("NoDigitException was thrown", true);
		} catch(Exception e) {
			
			System.out.println(e.getMessage());
			assertTrue("Wrong Exception thrown", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		fail("Not implemented by student yet");
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		fail("Not implemented by student yet");
	}
	
}