package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1260
 */
public class Dfs_Bfs_1260 {

	static int n;
	static int m;
	static int v;
	static boolean[][] graph;
	static boolean[] visited;

	public static void solution(int index) {
		dfs(index);
		System.out.println();

		Arrays.fill(visited, false);

		bfs(index);
	}

	public static void dfs(int index) {
		visited[index] = true;
		System.out.print(index + " ");

		for (int i = 1; i <= n; i++) {
			boolean edge = graph[index][i];

			if (edge && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(index);
		visited[index] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int i = 1; i <= n; i++) {
				if (graph[node][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = true;
			graph[b][a] = true;
		}

		solution(v);
	}
}
