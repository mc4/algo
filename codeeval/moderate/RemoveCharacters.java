package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program which removes specific characters from a string.
 */

public class RemovingCharacters {

	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		File file;
		BufferedReader reader = null;
		String tokens[];
		String line;

		file = new File(args[0]);
		reader = new BufferedReader(new FileReader(file));

		while ((line = reader.readLine()) != null) {
			tokens = line.split(",");

			String charSequence = tokens[0].trim();
			String delims = tokens[1].trim();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < charSequence.length(); i++) {
				if (!delims.contains(String.valueOf(charSequence.charAt(i)))) {
					sb.append(charSequence.charAt(i));
				}
			}
			System.out.println(sb.toString());
			sb = null;
		}
		
		reader.close();
	}
}
