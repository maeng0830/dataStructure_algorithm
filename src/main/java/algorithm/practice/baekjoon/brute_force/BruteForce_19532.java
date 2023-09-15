package algorithm.practice.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_19532 {

	public static void solution(int[] ints) {
		int a = ints[0];
		int b = ints[1];
		int c = ints[2];
		int d = ints[3];
		int e = ints[4];
		int f = ints[5];

		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if ((a * x) + (b * y) == c) {
					if ((d * x) + (e * y) == f) {
						System.out.print(x + " ");
						System.out.print(y);
						return;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int[] ints = new int[str.length];

		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.parseInt(str[i]);
		}

		solution(ints);
	}
}
