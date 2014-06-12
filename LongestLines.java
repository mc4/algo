package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * CHALLENGE DESCRIPTION:
 * 
 * Write a program to read a multiple line text file and write the 'N' longest
 * lines to stdout. Where the file to be read is specified on the command line.
 * 
 * Your program should read an input file (the first argument to your program
 * will be a path to a filename). The first line contains the value of the
 * number 'N' followed by multiple lines. You may assume that the input file is
 * formatted correctly and the number on the first line i.e. 'N' is a valid
 * positive integer.
 */

/**
 * OUTPUT:
 * 
 * The 'N' longest lines, newline delimited. Ignore all empty lines in the
 * input. Ensure that there are no trailing empty spaces on each line you print.
 * Also ensure that the lines are printed out in decreasing order of length i.e.
 * the output should be sorted based on their length.
 */

public class LongestLines {

	static String longestWords[];

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}
		
		int numOrdered = 0;
		int target;

		File file;
		BufferedReader br;

		try {
			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));

			String line = br.readLine();
			target = Integer.parseInt(line);
			longestWords = new String[target];

			for (int i = 0; i < target; i++) {
				line = br.readLine();
				longestWords[i] = line;
			}

			while ((line = br.readLine()) != null) {
				lengthTest(line);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		// sort
		while (numOrdered <= longestWords.length) {
			int longest = longestWords.length - 1 - numOrdered;
			for (int i = longest; i >= 0; i--) {
				moveLeft(longest, i);
			}
			numOrdered++;
		}

		for (int i = 0; i < longestWords.length; i++) {
			System.out.println(longestWords[i]);
		}
	}

	// only adds words that are longer than shortest in the list
	private static void lengthTest(String currentLine) {
		// find shortest index in the list
		int smallestLength = longestWords[0].length();
		int smallestIndex = 0;

		for (int i = 0; i < longestWords.length; i++) {
			if (longestWords[i].length() < smallestLength) {
				smallestLength = longestWords[i].length();
				smallestIndex = i;
			}
		}

		if (currentLine.length() < smallestLength) {
			return;
		} else if (smallestIndex != 0) {
			longestWords[smallestIndex] = currentLine;
		} else {
			// first indice of array is smallest
			longestWords[smallestIndex] = currentLine;
		}
	}

	private static void swap(int larger, int smaller) {
		String temp = longestWords[larger];
		longestWords[larger] = longestWords[smaller];
		longestWords[smaller] = temp;
	}

	private static void moveLeft(int subArrayIndex, int index) {
		int targetIndex = 0;
		int targetLength = longestWords[0].length();

		// find longest word in subarray
		for (int i = subArrayIndex; i < longestWords.length; i++) {
			if (longestWords[i].length() > targetLength) {
				targetIndex = i;
				targetLength = longestWords[i].length();
			}
		}
		swap(targetIndex, index);
	}
}
