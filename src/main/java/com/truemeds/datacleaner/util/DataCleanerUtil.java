package com.truemeds.datacleaner.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.truemeds.datacleaner.entity.FinalOutput;

public class DataCleanerUtil {

	private static int count = 0;
	private static int finalOutputID = 2;

	public static List<FinalOutput> cleanData(List<String> inputDetailsList) {
		List<FinalOutput> list = new ArrayList<FinalOutput>();
		for (String str : inputDetailsList) {
			char last_removed = '\0';
			String finalString = removeUtil(str.replaceAll("\\s", ""), last_removed);
			list.add(saveFinalOutput(str, finalString, DataCleanerUtil.count));
			DataCleanerUtil.count = 0;
		}
		return list;
	}

	/**
	 * Recursive method to keep on checking the string until it has no adjacent same
	 * characters.
	 * 
	 * @param inputString
	 * @param lastRemoved
	 * @return
	 */
	private static String removeUtil(String inputString, char lastRemoved) {

		if (inputString.length() == 0 || inputString.length() == 1)
			return inputString;

		if (inputString.charAt(0) == inputString.charAt(1)) {
			DataCleanerUtil.count = DataCleanerUtil.count + 1;
			lastRemoved = inputString.charAt(0);
			while (inputString.length() > 1 && inputString.charAt(0) == inputString.charAt(1))
				inputString = inputString.substring(1, inputString.length());
			inputString = inputString.substring(1, inputString.length());
			return removeUtil(inputString, lastRemoved);
		}

		String remainingString = removeUtil(inputString.substring(1, inputString.length()), lastRemoved);

		if (remainingString.length() != 0 && remainingString.charAt(0) == inputString.charAt(0)) {
			lastRemoved = inputString.charAt(0);

			return remainingString.substring(1, remainingString.length());
		}

		if (remainingString.length() == 0 && lastRemoved == inputString.charAt(0))
			return remainingString;

		return (inputString.charAt(0) + remainingString);
	}

	/**
	 * Create a new FinalOutput object and
	 * 
	 * @param originalString
	 * @param finalString
	 * @param totalSteps
	 */
	private static FinalOutput saveFinalOutput(String originalString, String finalString, int totalSteps) {
		FinalOutput finalOutput = new FinalOutput();
		finalOutput.setId(DataCleanerUtil.finalOutputID);
		DataCleanerUtil.finalOutputID = DataCleanerUtil.finalOutputID + 1;
		finalOutput.setOriginalString(originalString);
		finalOutput.setCleanedString(finalString);
		finalOutput.setNumberOfSteps(totalSteps);
		finalOutput.setCreated(new Timestamp(System.currentTimeMillis()));
		return finalOutput;
	}

}