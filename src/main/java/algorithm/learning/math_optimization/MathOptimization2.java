package algorithm.learning.math_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathOptimization2 {

	public static void solution(int n) {
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (i * i == n) {
					System.out.print(i + " ");
				} else {
					System.out.print(i + " ");
					System.out.print(n/i + " ");
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		solution(n);
	}
}
