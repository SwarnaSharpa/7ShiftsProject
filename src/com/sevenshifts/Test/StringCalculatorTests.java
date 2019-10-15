package com.sevenshifts.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sevenshifts.StringCalculator;

public class StringCalculatorTests {

	StringCalculator stringCalculator = new StringCalculator();
	
	@Test
	public void emptyString() {
		int result = stringCalculator.add("");
		assertEquals(result, 0);
	}
	@Test
	public void commaDelimiter() {
		int result = stringCalculator.add("1,2,3");
		assertEquals(result, 6);
	}
	@Test
	public void lineSeparator() {
		int result = stringCalculator.add("1\n,2,30");
		assertEquals(33, result);
	}
	
	@Test
	public void singleCustomDelimiter() {
		int result = stringCalculator.add("//@\n1@2@3");
		assertEquals(6, result);
	}
	
	@Test
	public void multipleCustomDelimiter() {
		int result = stringCalculator.add("//@,$\n1@2$3");
		assertEquals(6, result);
	}
	
	@Test
	public void negativeNumberHandling() {
		int result = stringCalculator.add("//$\n-1$2$-0300");
		assertEquals(2, result);
	}
	
	@Test
	public void moreThanThousand() {
		int result = stringCalculator.add("//@\n1500@2@3");
		assertEquals(5, result);
	}
	
	@Test
	public void arbitraryDelimiters() {
		int result = stringCalculator.add("//***\n1***2***3");
		assertEquals(6, result);
	}
	
	
	@Test
	public void multipleArbitraryDelimiters() {
		int result = stringCalculator.add("//***,@@@\n1***2***3@@@6");
		assertEquals(12, result);
	}
     

}
