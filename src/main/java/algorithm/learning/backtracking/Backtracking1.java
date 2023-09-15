package algorithm.learning.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹은 재귀적으로 모든 경우의 수를 확인하는 방법이다.
// 깊이가 달라져서 for로는 모든 경우의 수를 확인할 수 없을 때 사용한다.
// 트리 구조로 모든 경우의 수를 탐색한다고 생각하면 이해하기 용이하다.
// 중요한 포인트는 불필요한 분기는 가지치기 한다는 것이다.

// 백트래킹을 이해하기 쉬운 기본 문제는 순열! - 백준 15649
public class Backtracking1 {

	public static void solution(int n, int m, int number, int[] answer, boolean[] check) {
		if (number == m) {
			for (int i : answer) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (check[i]) {
				continue;
			}

			answer[number] = i;
			check[i] = true;

			solution(n, m, number + 1, answer, check);

			check[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int number = 0;
		int[] answer = new int[m];
		boolean[] check = new boolean[n + 1];

		solution(n, m, number, answer, check);
	}
}
