package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2644
 */
public class Dfs_Bfs_2644 {

	static int n;
	static int from;
	static int to;
	static int m;
	static boolean[][] graph;
	static boolean[] visited;
	static int[] dist;

	public static int bfs(int from, int to) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);
		visited[from] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int i = 1; i <= n; i++) {
				if (graph[node][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
					dist[i] = dist[node] + 1;

					if (i == to) {
						return dist[i];
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		graph = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = true;
			graph[b][a] = true;
		}

		System.out.println(bfs(from, to));
	}
}
