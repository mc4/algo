package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EvenNumbers {
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}
		
		File file;
		BufferedReader br;
		String line;
		int c;
		
		try {
			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null ){
				c = Integer.parseInt(line);
				if(c%2 == 0){
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
}
