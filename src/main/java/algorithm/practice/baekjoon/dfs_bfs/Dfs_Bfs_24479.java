package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/24479
 * 정점의 수가 많을 경우, 인접 리스트 그래프를 사용하자. 인접 배열 그래프는 메모리 초과가 발생할 수 있다.
 */
public class Dfs_Bfs_24479 {

	static int n;
	static int m;
	static int r;
	static int order;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;

	public static void solution(int index) {
		dfs(index);

		for (int i = 1; i <= n; i++) {
			System.out.println(visited[i]);
		}
	}

	public static void dfs(int index) {
		order++;
		visited[index] = order;

		Collections.sort(graph.get(index));

		ArrayList<Integer> edges = graph.get(index);
		Iterator<Integer> iterator = edges.stream().iterator();

		while (iterator.hasNext()) {
			Integer nextNode = iterator.next();

			if (visited[nextNode] == 0) {
				dfs(nextNode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		visited = new int[n + 1];

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		solution(r);
	}
}
