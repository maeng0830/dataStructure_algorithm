package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/14889
 */
public class Dfs_Bfs_14889 {

	static int n;
	static int[][] graph;
	static boolean[] visited;

	static int answer = Integer.MAX_VALUE;

	public static int dfs(int index, int count) {
		if (count == n / 2) {
			int result = diff();

			answer = Math.min(answer, result);
			return answer;
		}

		if (index == n) {
			return answer;
		}

		visited[index] = true;
		dfs(index + 1, count + 1);
		visited[index] = false;
		dfs(index + 1, count);

		return answer;
	}

	public static int diff() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j < n; j++) {
				if (visited[i] && visited[j]) {
					start += graph[i][j];
					start += graph[j][i];
				}

				if (!visited[i] && !visited[j]) {
					link += graph[i][j];
					link += graph[j][i];
				}
			}
		}

		return Math.abs(start - link);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));
	}
}
