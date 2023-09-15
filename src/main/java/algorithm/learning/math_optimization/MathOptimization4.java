package algorithm.learning.math_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathOptimization4 {

	public static int gcd(int a, int b) {
		if (a == b) {
			return a;
		}

		int bigNumber = 0;
		int smallNumber = 0;

		if (a > b) {
			bigNumber = a;
			smallNumber = b;
		} else {
			bigNumber = b;
			smallNumber = a;
		}

		while (bigNumber % smallNumber != 0) {
			int tmp = bigNumber % smallNumber;
			bigNumber = smallNumber;
			smallNumber = tmp;
		}

		return smallNumber;
	}

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);

		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));
	}
}
