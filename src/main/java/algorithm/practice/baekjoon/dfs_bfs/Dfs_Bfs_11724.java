package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11724
 */
public class Dfs_Bfs_11724 {

	static int n;
	static int m;
	static boolean[][] graph;
	static boolean[] visited;
	static int answer;

	public static int solution() {
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				answer++;
			}
		}

		return answer;
	}

	public static void dfs(int index) {
		visited[index] = true;

		for (int i = 1; i <= n; i++) {
			boolean edge = graph[index][i];

			if (edge && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = true;
			graph[b][a] = true;
		}

		System.out.println(solution());
	}
}
