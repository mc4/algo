import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		File file;
		BufferedReader reader;

		try {

			file = new File(args[0]);
			reader = new BufferedReader(new FileReader(file));

			String line = null;

			while ((line = reader.readLine()) != null) {
				StringBuilder result = new StringBuilder(line);
				
				String[] tokens = line.split(" ");
				String string = tokens[0];
				String mask = tokens[1];
				
				for (int i = 0; i < string.length(); i++) {
					char ch = string.charAt(i);
					result.setCharAt(i, mask.charAt(i) == 1 ? Character.toUpperCase(ch) : ch);
					
				//	result.setCharAt(i, ch >= 'A' && ch <= 'Z' ? (char) (ch + 'a' - 'A') : ch);
				}
				System.out.println(result);
			}
			reader.close();
		} catch (Exception e) {
		}
	}
}
