package algorithm.practice.inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DynamicProgramming_1 {

	static int n;
	static int[] memo;

	public static int solution() {
		memo[1] = 1;
		memo[2] = 2;

		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i - 2] + memo[i - 1];
		}

		return memo[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		memo = new int[n + 1];

		System.out.println(solution());
	}
}
