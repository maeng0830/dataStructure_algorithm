package algorithm.practice.inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS를 통해 두 정점간의 모든 경로를 탐색할 수 있다.
public class RecursiveTreeGraph_12_matrix {
	static int answer = 0;

	public static void solution(int start, int target, int[][] graph, boolean[] visited) {
		if (start == target) {
			answer++;
			return;
		}

		for (int i = 1; i < graph.length; i++) {
			if (graph[start][i] != 0 && !visited[i]) {
				visited[i] = true;
				solution(i, target, graph, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] graph = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = 1;
		}

		boolean[] visited = new boolean[n + 1];
		visited[1] = true;

		solution(1, 5, graph, visited);

		System.out.print(answer);
	}
}
