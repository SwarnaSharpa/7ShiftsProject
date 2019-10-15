package com.sevenshifts;

import java.util.ArrayList;

import com.customexceptions.NegativeNumberException;

/* This class will find out the sum of the numbers present in the string. */

public class StringCalculator {

	public static int maxNumber = 1000;

	/**
	 * This method will print the sum of all the numbers present in the string
	 * and also throws the exception in case of negative numbers.
	 * 
	 * @param str
	 * @return total
	 */
	public int add(String str) {
		String delimiter = determineDelimiters(str);
		str = str.replaceAll(System.lineSeparator(), "");
		int total = calculateTheSum(str, delimiter);
		System.out.println("Sum of all numbers present in the string is: " + total);
		return total;
	}

	/**
	 * This method accepts the string and the delimiter and calculates the sum
	 * of all the numbers present in the string.
	 * 
	 * @param str
	 * @param del
	 * @return
	 */
	public int calculateTheSum(String str, String del) {
		int sum = 0;
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		ArrayList<String> nums = new ArrayList<>();
		String[] numbers;
		if (del.length() > 1) {
			numbers = str.split(del);
		} else {
			numbers = str.split("\\" + del);
		}
		for (String n : numbers) {
			if (n.matches("^([1-9][0-9]{0,2}|1000)$")) {
				nums.add(n);
			} else if (n.matches("^-?[0-9]\\d*(\\.\\d+)?$")) {
				negativeNumbers.add(Integer.parseInt(n));
			}
		}
		for (int i = 0; i < nums.size(); i++) {
			sum = sum + Integer.parseInt(nums.get(i).toString());
		}
		if (!negativeNumbers.isEmpty()) {
			negativeNumEx(negativeNumbers);
		}
		return sum;
	}

	/**
	 * This method will return the delimiter.
	 * 
	 * @param str
	 * @return finalSplitDelimiter
	 */
	public String determineDelimiters(String str) {
		String[] delims = {};
		if (str.contains(System.lineSeparator()) && str.contains("//")) {
			delims = str.replaceAll("//", "").split(System.lineSeparator());
			if (delims[0].contains(",")) {
				delims = delims[0].split(",");
			} else {
				delims = new String[] { delims[0] };
			}
		} else if (str.contains(System.lineSeparator()) && !str.contains("//")) {
			delims = new String[] { "," };
		}

		String finalSplitDelimiter = "";

		if (delims.length > 1) {
			for (int k = 0; k < delims.length; k++) {
				finalSplitDelimiter = finalSplitDelimiter.concat("\\" + delims[k].substring(0, 1));
				if (k != delims.length - 1) {
					finalSplitDelimiter = finalSplitDelimiter.concat("|");
				}

			}
		} else if (delims.length == 1) {
			finalSplitDelimiter = delims[0].substring(0, 1);

		} else {
			finalSplitDelimiter = ",";
		}
		return finalSplitDelimiter;

	}

	/**
	 * This method will throw the custom NegativeNumberException and print all
	 * the negative numbers present in the provided string.
	 */
	public void negativeNumEx(ArrayList<Integer> negativenumbers) {
		try {
			throw new NegativeNumberException("Negative numbers are not allowed");
		} catch (NegativeNumberException nnex) {
			nnex.printStackTrace();
			System.out.println("Here are the numbers which are negative:" + "\n");
			for (int q = 0; q < negativenumbers.size(); q++) {
				System.out.println(negativenumbers.get(q) + "\n");
			}
		}
	}

}
