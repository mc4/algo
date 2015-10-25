package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * CHALLENGE DESCRIPTION:
 * 
 * Your program should accept as its first argument a path to a filename. Each
 * line in this file contains two comma separated positive integers.
 */
public class CountingPrimes {

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		File file;
		BufferedReader br;

		try {

			file = new File(args[0]);
			br = new BufferedReader(new FileReader(file));

			/*
			 * reads the life of the file. splits the string into minimum and
			 * maximum for primes.
			 */
			String line;
			while ((line = br.readLine()) != null) {
				String[] range = line.split(",");
				int minimum = Integer.parseInt(range[0]);
				int maximum = Integer.parseInt(range[1]);
				System.out.println(countPrimes(minimum, maximum));
			}
			br.close();
		} catch (FileNotFoundException e) {
		} catch (IOException ioe) {
		}
	}

	static int countPrimes(int min, int max) {
		int count = 0;
		for (int i = min; i <= max; i++) {
			if (isPrime(i)) { count++; }
		}
		return count;
	}

	static boolean isPrime(int num) {
		if (num <= 1) {	return false; }
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
