package algorithm.practice.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_10870 {

	static int[] dp;

	public static int solution(int n) {
		if (n == 0) {
			return 0;
		} else if (n <= 2) {
			return 1;
		}

		if (dp[n] != 0) {
			return dp[n];
		} else {
			return dp[n] = solution(n - 2) + solution(n - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 1];

		System.out.println(solution(n));
	}
}
