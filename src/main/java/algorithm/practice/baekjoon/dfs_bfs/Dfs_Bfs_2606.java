package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2606
 */
public class Dfs_Bfs_2606 {

	static int n;
	static int m;
	static ArrayList<ArrayList<Edge>> edges;
	static boolean[] visited;
	static int answer = 0;

	static class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}

	public static int dfs(int index) {
		visited[index] = true;

		Iterator<Edge> iterator = edges.get(index).stream().iterator();

		while (iterator.hasNext()) {
			int to = iterator.next().to;

			if (!visited[to]) {
				answer++;
				dfs(to);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		edges = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges.get(from).add(new Edge(from, to));
			edges.get(to).add(new Edge(to, from));
		}

		visited = new boolean[n + 1];

		System.out.println(dfs(1));
	}
}
