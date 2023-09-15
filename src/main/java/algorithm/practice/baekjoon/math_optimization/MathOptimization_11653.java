package algorithm.practice.baekjoon.math_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathOptimization_11653 {

	public static void solution(int n) {
		if (n == 1) {
			return;
		}

		int number = n;
		int i = 2;

		while (number != 1) {
			if (number % i == 0) {
				System.out.println(i);
				number /= i;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		solution(n);
	}
}
