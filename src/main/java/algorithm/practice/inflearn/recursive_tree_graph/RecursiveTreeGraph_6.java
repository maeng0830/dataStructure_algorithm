package algorithm.practice.inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DFS는 부분 집합을 구하는데 사용될 수 있다.
// 1 ~ n까지의 자연수가 주어졌을 때, 부분 집합을 구하는 문제
public class RecursiveTreeGraph_6 {

	public static void solution(int cur, int n, boolean[] visited) {
		if (cur == n + 1) {
			for (int i = 1; i < visited.length; i++) {
				if (visited[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}

		visited[cur] = true;
		solution(cur + 1, n, visited);
		visited[cur] = false;
		solution(cur + 1, n, visited);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n + 1];


		solution(1, n, visited);
	}
}
