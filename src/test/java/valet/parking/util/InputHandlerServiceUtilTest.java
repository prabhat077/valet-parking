package valet.parking.util;


import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerServiceUtilTest {

	@Test
	void verifyInputLine1Capacity_sucess() {
		String[] output = InputHandlerServiceUtil.verifyInput("4 3", 1);
		String[] expectedOutput = new String[] { "4", "3" };
		Assertions.assertArrayEquals(output, expectedOutput);
	}

	@Test
	void verifyInputLine1Capacity_fail() {
		// if zero capacity input given
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("", 1));

		String output = exception.getMessage();
		String expectedOutput = "Invalid no of Argument in Line 1";
		Assertions.assertEquals(output, expectedOutput);

		// if more than 2 capacity input given
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("4 5 6", 1));

		output = exception.getMessage();
		expectedOutput = "Invalid no of Argument in Line 1";
		Assertions.assertEquals(output, expectedOutput);

		// if input given are not parsable by Integer
		exception = Assertions.assertThrows(NumberFormatException.class,
				() -> InputHandlerServiceUtil.verifyInput("4z 5", 1));

		output = exception.getMessage();
		expectedOutput = "Number Format Exception for capacity in Line 1";
		Assertions.assertEquals(output, expectedOutput);

	}

	@Test
	void verifyInputLineEnter_sucess() {
		Random r = new Random();
		// Any line value greater than 1
		int lineNo = r.nextInt(100) + 2;
		String[] output = InputHandlerServiceUtil.verifyInput("Enter motorcycle SGX1234A 1613541902", lineNo);
		String[] expectedOutput = new String[] { "Enter", "motorcycle", "SGX1234A", "1613541902" };
		Assertions.assertArrayEquals(output, expectedOutput);

		lineNo = r.nextInt(100) + 2;
		output = InputHandlerServiceUtil.verifyInput("Enter car SGX1234A 1613541902", lineNo);
		expectedOutput = new String[] { "Enter", "car", "SGX1234A", "1613541902" };
		Assertions.assertArrayEquals(output, expectedOutput);
	}

	@Test
	void verifyInputLineEnter_fail() {
		Random r = new Random();
		// Any line value greater than 1
		
		// if zero capacity input given

		int lineNo = r.nextInt(100) + 2;

		// Test for invalid input
		String expectedOutput = "Invalid Input Line "+ lineNo;
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("", lineNo));
		String output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

		// If Enter but only 3 arguments
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Enter SGX1234A 1613541902", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);
		

		// If Enter but only 2 arguments
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Enter SGX1234A", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

		// Incorrect Parking operation
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Ent car SGX1234A 1613541902", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);
	
		// Incorrect Parking operation
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Enter truck SGX1234A 1613541902", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

	}
	
	@Test
	void verifyInputLineExit_sucess() {
		Random r = new Random();
		// Any line value greater than 1
		int lineNo = r.nextInt(100) + 2;
		String[] output = InputHandlerServiceUtil.verifyInput("Exit SGX1234A 1613541902", lineNo);
		String[] expectedOutput = new String[] { "Exit", "SGX1234A", "1613541902" };
		Assertions.assertArrayEquals(output, expectedOutput);

		lineNo = r.nextInt(100) + 2;
		output = InputHandlerServiceUtil.verifyInput("Exit SGX1234A 1613541902", lineNo);
		expectedOutput = new String[] { "Exit", "SGX1234A", "1613541902" };
		Assertions.assertArrayEquals(output, expectedOutput);
	}

	@Test
	void verifyInputLineExit_fail() {
		Random r = new Random();
		

		// Any line value greater than 1
		int lineNo = r.nextInt(100) + 2;

		// Test for invalid input
		// if zero capacity input given
		String expectedOutput = "Invalid Input Line "+ lineNo;
		Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("", lineNo));
		String output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);
		
		// If Enter but only 2 arguments
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Exit SGX1234A", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

		// Incorrect Parking operation
		exception = Assertions.assertThrows(IllegalArgumentException.class,
				() -> InputHandlerServiceUtil.verifyInput("Ent SGX1234A 1613541902", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);
	}
	
	@Test
	void verifyInputTimestamp_fail() {
		Random r = new Random();
		// Any line value greater than 1
		
		// if zero capacity input given

		int lineNo = r.nextInt(100) + 2;

		// Test for invalid input
		String expectedOutput = "Number Format Exception for timeStamp in Line "+ lineNo;
		Exception exception = Assertions.assertThrows(NumberFormatException.class,
				() -> InputHandlerServiceUtil.verifyInput("Enter motorcycle SGX1234A abcd", lineNo));
		String output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

		// Test for invalid input
		expectedOutput = "Number Format Exception for timeStamp in Line "+ lineNo;
		exception = Assertions.assertThrows(NumberFormatException.class,
				() -> InputHandlerServiceUtil.verifyInput("Exit SGX1234A abcd", lineNo));
		output = exception.getMessage();
		Assertions.assertEquals(output, expectedOutput);

	}


}
