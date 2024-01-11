package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/11725
 */
public class Dfs_Bfs_11725 {

	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;

	public static void solution(int start) {
		dfs(start, 0);

		for (int i = 2; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}

	public static void dfs(int cur, int pre) {
		if (cur == 1) {
			visited[cur] = 1;
		} else {
			visited[cur] = pre;
		}

		Iterator<Integer> iterator = graph.get(cur).stream().iterator();

		while (iterator.hasNext()) {
			int node = iterator.next();

			if (visited[node] == 0) {
				dfs(node, cur);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		visited = new int[n + 1];

		solution(1);
	}
}
