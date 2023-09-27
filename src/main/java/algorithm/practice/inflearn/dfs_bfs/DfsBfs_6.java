package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10 이하의 N개 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 * 3 2
 * 3 6 9
 *
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 */
public class DfsBfs_6 {

	public static void solution(int depth, int n, int k, int[] numbers, boolean[] visited, StringBuilder answer) {
		if (depth == k) {
			System.out.println(answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer.append(numbers[i]).append(" ");
				solution(depth + 1, n, k, numbers, visited, answer);
				visited[i] = false;
				answer.delete(answer.lastIndexOf(String.valueOf(numbers[i])), answer.length());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] visited = new boolean[n];
		StringBuilder sb = new StringBuilder();

		solution(0, n, k, numbers, visited, sb);
	}
}
