package algorithm.practice.inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 수열을 출력한다.
 *
 * 첫 번째 줄에 총 항의 수 N이 주어집니다.
 * 10
 *
 * 첫 번째 줄에 피보나치 수열을 출력합니다.
 * 1 1 2 3 5 8 13 21 34 55
 */
public class RecursiveTreeGraph_4 {

	public static int solution(int n, int[] dp) {
		if (n <= 2) {
			dp[n] = 1;
		}

		if (dp[n] == 0) {
			dp[n] = solution(n - 2, dp) + solution(n -1, dp);
		}

		return dp[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		solution(n, dp);

		for (int i = 1; i < dp.length; i++) {
			sb.append(dp[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
