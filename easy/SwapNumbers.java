package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SwapNumbers {
	
	public static String swap(String sentence) {
		
		String[] words = sentence.split(" ");
		String res = "";
		
		for (String word: words) {
			int len = word.length();
			String post = word.charAt(len-1) + word.substring(1, len-1) + word.charAt(0);
			res += post + " ";
		}
		
		return res;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		File file;
		BufferedReader br;
		String line;

		file = new File(args[0]);
		br = new BufferedReader(new FileReader(file));

		while ((line = br.readLine()) != null) {
			System.out.println(swap(line.trim()).trim());
		}
		
	}

}
