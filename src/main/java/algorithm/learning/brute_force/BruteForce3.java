package algorithm.learning.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BruteForce3 {

	public static void solution(int a, int b, int c, int d, int e, int f) {
		for (int x = -10000; x <= 10000; x++) {
			for (int y = -1000; y <= 10000; y++) {
				if ((a*x) + (b*y) == c) {
					if ((d*x) + (e*y) == f) {
						System.out.print(x + " ");
						System.out.print(y);
						return;
					}
				}
			}
		}

		System.out.println("NO ANSWER");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		solution(ints[0], ints[1], ints[2], ints[3], ints[4], ints[5]);
	}
}
