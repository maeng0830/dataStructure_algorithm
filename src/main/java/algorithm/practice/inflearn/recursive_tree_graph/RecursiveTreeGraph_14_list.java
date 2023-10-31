package algorithm.practice.inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BFS는 두 정점간의 최단 거리를 구하는데 사용할 수 있다.
 *
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 *
 * 1: 0
 * 2: 3
 * 3: 1
 * 4: 1
 * 5: 2
 * 6: 2
 */
public class RecursiveTreeGraph_14_list {

	public static void solution(ArrayList<ArrayList<Integer>> graph, int start) {
		boolean[] visited = new boolean[graph.size()];
		int[] depth = new int[graph.size()];


		Queue<Integer> queue = new LinkedList<>();

		visited[start] = true; // 출발 정점 방문 체크
		queue.offer(start); // 출발 정점 queue 삽입

		while (!queue.isEmpty()) {
			int cv = queue.poll();

			for (int nv : graph.get(cv)) {
				if (!visited[nv]) {
					visited[nv] = true;
					queue.offer(nv); // 방문
					depth[nv] = depth[cv] + 1;
				}
			}
		}

		for (int i = 1; i < depth.length; i++) {
			if (depth[i] != 0) {
				System.out.print(i + ": " + depth[i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
		}

		int start = 1;

		solution(graph, start);
	}
}
