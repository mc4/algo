package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MthToLastElement {

	public static void main(String[] args) {
			if (args.length == 0) {
				System.out.println("No file to run.");
				System.exit(0);
			}

			File file;
			BufferedReader br;
			String line;
			String[] elements = null;

			try {

				file = new File(args[0]);
				br = new BufferedReader(new FileReader(file));
											
				while ((line = br.readLine()) != null) {
					
					elements = line.split(" ");
					int size = elements.length - 1;
					int m = Integer.parseInt(elements[size]);
					
					if(m > size){
						System.out.println();
						continue;
					} else {
						System.out.println(elements[size - m]);
					}
					
				}
				br.close();
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
			}
	}

}
