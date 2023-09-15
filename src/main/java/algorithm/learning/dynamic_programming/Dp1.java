package algorithm.learning.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다이나믹 프로그래밍은 매번 똑같은 계산을 반복하는 것이 아니라,
// 이미 이전에 계산된 값이 있다면, 그 값을 재사용하는 알고리즘이다.

// 큰 문제를 부분 문제로 분할하여 해결할 때, 중복된 부분 문제가 있다면 다이나믹 프로그래밍, 아니라면 분할 정복 알고리즘을 사용한다.

// 큰 문제를 부분 문제로 분할하면서 해결하는 방식을 top-down방식(재귀),
// 부분 문제부터 해결하면서 올라가는 방식을 bottom-up 방식(반복문)이라고 한다.

// 다이나믹 프로그래밍의 적용 기준
// 큰 문제가 부분 문제로 분할될 수 있을 때
// 부분 문제의 답으로 큰 문제를 해결할 수 있을 때
// 부분 문제가 중복될 때
public class Dp1 {

	public static int solution_topDown(int n, int[] mz) {
		if (n <= 2) {
			return 1;
		}

		if (mz[n] == 0) {
			mz[n] = solution_topDown(n - 2, mz) + solution_topDown(n - 1, mz);
		}

		return mz[n];
	}

	public static int solution_bottomUp(int n, int[] mz) {
		for (int i = 1; i <= n; i++) {
			if (i <= 2) {
				mz[i] = 1;
			} else {
				mz[i] = mz[i - 2] + mz[i - 1];
			}
		}

		return mz[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] mzForTD = new int[n + 1];

		int[] mzForBU = new int[n + 1];

		System.out.println(solution_topDown(n, mzForTD));
		System.out.println(solution_bottomUp(n, mzForBU));
	}
}
