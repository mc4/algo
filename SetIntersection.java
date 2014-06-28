package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SetIntersection {

	static ArrayList<String> first = new ArrayList<String>();
	static ArrayList<String> second = new ArrayList<String>();
	static ArrayList<String> cross = new ArrayList<String>();

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		File file;
		BufferedReader br;
		String line;

		try {

			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));

			while ((line = br.readLine()) != null) {
				buildLists(line);
				compareLists(first, second);
				printArray(cross);
				first.clear();
				second.clear();
				cross.clear();
			}
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	private static void buildLists(String line) {
		int i;
		StringBuilder sb = new StringBuilder();
		
		//build first array, ';' will always happen
		for (i = 0; i < line.length(); i++) {
			if (line.charAt(i) == ';') {
				first.add(sb.toString());
				sb.setLength(0);
				break;
			} else if (line.charAt(i) == ',') {
				first.add(sb.toString());
				sb.setLength(0);
				continue;
			} else {
				sb.append(line.charAt(i));
			}
		}
		
		//builds second list
		for (i++; i <= line.length() + 1; i++) {
			if (i == line.length()) {
				second.add(sb.toString());
				break;
			} else if (line.charAt(i) == ',') {
				second.add(sb.toString());
				sb.setLength(0);
			} else {
				sb.append(line.charAt(i));
			}
		}
	}

	private static void compareLists(ArrayList<String> a, ArrayList<String> b) {
		for (int i = 0; i < first.size(); i++) {
			for (int j = 0; j < second.size(); j++) {
				if (first.get(i).equals(second.get(j))) {
					cross.add(second.get(j));
				}
			}
		}
	}

	private static void printArray(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i));
			if (i < a.size() - 1) System.out.print(",");
		}
		System.out.println();
	}
}
