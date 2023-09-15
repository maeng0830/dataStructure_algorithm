package algorithm.practice.baekjoon.math_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathOptimization_1978 {

	public static int solution(int[] ints) {
		int answer = 0;

		for (int i = 0; i < ints.length; i++) {
			int number = ints[i];
			boolean check = false;

			if (number == 1) {
				continue;
			}

			for (int j = 2; j <= (int) Math.sqrt(number); j++) {
				if (number % j == 0) {
					check = true;
					break;
				}
			}

			if (!check) {
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] str = br.readLine().split(" ");
		int[] ints = new int[n];

		for (int i = 0; i < n; i++) {
			ints[i] = Integer.parseInt(str[i]);
		}

		System.out.println(solution(ints));
	}
}
