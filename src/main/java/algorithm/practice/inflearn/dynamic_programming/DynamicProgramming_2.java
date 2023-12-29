package algorithm.practice.inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming_2 {

	static int n;
	static int[] memo;

	public static int solution(int n) {
		if (n <= 1) {
			return memo[n] = 1;
		}

		if (memo[n] == 0) {
			return memo[n] = solution(n - 2) + solution(n - 1);
		} else {
			return memo[n];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()) + 1;

		memo = new int[n + 1];

		System.out.println(solution(n));
	}
}
