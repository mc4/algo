package codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ArrayAbsurdity {

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("No file to run.");
			System.exit(0);
		}

		File file;
		BufferedReader br;
		String line;

		file = new File(args[0]);
		br = new BufferedReader(new FileReader(file));

		while ((line = br.readLine()) != null) {

			int values[] = buildArray(line);
			mergesort(values);
			findDuplicate(values);

		}
		br.close();
	}

	public static int[] buildArray(String line) {
		
		String tokens[] = line.split(";");
		int size = Integer.parseInt(tokens[0]);
		String stringInt[] = tokens[1].split(",");

		return convertStrToInt(stringInt, size);
	}

	public static int[] convertStrToInt(String pre[], int size) {
		int realInt[] = new int[size];
		
		for (int i = 0; i < pre.length; i++) {
			realInt[i] = Integer.parseInt(pre[i]);
		}
		return realInt;
	}

	public static void findDuplicate(int array[]) {
		int last = array[0];
		
		for (int i = 1; i < array.length; i++) {

			if (array[i] == last) {
				System.out.println(last);
				break;
			} else {
				last = array[i];
			}
		}
	}

	static void mergesort(int[] A) {
		if (A.length > 1) {
			int q = A.length / 2;

			int[] leftArray = Arrays.copyOfRange(A, 0, q);
			int[] rightArray = Arrays.copyOfRange(A, q, A.length);

			mergesort(leftArray);
			mergesort(rightArray);

			merge(A, leftArray, rightArray);
		}
	}

	static void merge(int[] a, int[] l, int[] r) {
		int totElem = l.length + r.length;
		int i, li, ri;
		i = li = ri = 0;
		while (i < totElem) {
			if ((li < l.length) && (ri < r.length)) {
				if (l[li] < r[ri]) {
					a[i] = l[li];
					i++;
					li++;
				} else {
					a[i] = r[ri];
					i++;
					ri++;
				}
			} else {
				if (li >= l.length) {
					while (ri < r.length) {
						a[i] = r[ri];
						i++;
						ri++;
					}
				}
				if (ri >= r.length) {
					while (li < l.length) {
						a[i] = l[li];
						li++;
						i++;
					}
				}
			}
		}
	}
}
