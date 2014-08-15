package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RightmostChar {
	public static void main(String[] args) {
		
		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}
		
		File file;
		BufferedReader br;
		String line;
		int pos = -1;
		char target; 
		
		try {
			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));
			
			while ((line = br.readLine()) != null){
				target = line.charAt(line.length()-1);
				line = line.substring(0, line.length()-3);
				if(pos >= 0){
					System.out.println(line.lastIndexOf(target));
				} else {
					System.out.println(-1);
				}
				pos = -1;
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e){	
		}
	}
}
