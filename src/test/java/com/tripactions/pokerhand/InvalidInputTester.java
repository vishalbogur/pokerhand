package com.tripactions.pokerhand;

import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.tripactions.pokerhand.exception.ApplicationException;

/**
 * Tests if the exception is thrown from the application in case of invalid inputs.
 * 
 * @author vishalbogur
 *
 */
public class InvalidInputTester {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void testForNullInput() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString(null);
		fail();
	}
	
	@Test
	public void testForEmptyInput() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString("");
		fail();
	}
	
	@Test
	public void testForIncompleteInput() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString("2s 5d 6h 7c");
		fail();
	}

	@Test
	public void testForInvalidSuitValues() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString("2X 2s 3d 4h 5c");
		fail();
	}

	@Test
	public void testForInvalidValues() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString("1s 2s 3d 4h 5c");
		fail();
	}
	
	@Test
	public void testForInvalidInputFormat() throws ApplicationException {
		exception.expect(ApplicationException.class);
		Hand.fromString("3s2s3d4h5c");
		fail();
	}
	
}
