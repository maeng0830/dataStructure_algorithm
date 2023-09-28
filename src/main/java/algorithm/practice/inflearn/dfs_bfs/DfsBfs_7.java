package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 조합의 경우의 수는 nCr = n-1Cr-1 + n-1Cr 이다.
 * r이 0이거나, n = r이면 1이다.
 *
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 * 5 3
 *
 * 첫째 출에 조합수를 출력한다.
 * 10
 */
public class DfsBfs_7 {

	public static int solution(int n, int r, int[][] memo) {
		if (r == 0 || n == r) {
			memo[n][r] = 1;
			return memo[n][r];
		}

		if (memo[n][r] == 0) {
			return solution(n - 1, r - 1, memo) + solution(n - 1, r, memo);
		} else {
			return memo[n][r];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] memo = new int[n + 1][r + 1];

		System.out.println(solution(n, r, memo));
	}
}
