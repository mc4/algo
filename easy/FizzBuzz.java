import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FizzBuzz {
	public static void main(String[] args) throws Exception {

		File file;
		BufferedReader br;
		String line;

		file = new File(args[0]);
		br = new BufferedReader(new FileReader(file));

		while ((line = br.readLine()) != null) {
			String tokens[] = line.split(" ");

			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			int limit = Integer.parseInt(tokens[2]);

			for (int i = 1; i < limit+1; i++) {

				if ((i % x == 0) && (i % y == 0)) {
					System.out.print("FB");
				} else if (i % x == 0) {
					System.out.print("F");
				} else if (i % y == 0) {
					System.out.print("B");
				} else {
					System.out.print(i);
				}

				if (i != limit) {
					System.out.print(" ");
				} else {
					System.out.println();
				}

			}

		}
		br.close();
	}
}
