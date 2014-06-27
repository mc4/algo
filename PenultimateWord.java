package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Write a program which finds the next-to-last word in a string.
 */

public class PenultimateWord {
	
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}
		
		File file;
		BufferedReader br;

		String line;
		String[] words;

		try {
			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				words = line.split(" ");
				System.out.println(words[words.length - 2]);
			}
		} catch (Exception e) { 	
		}
	}
}
