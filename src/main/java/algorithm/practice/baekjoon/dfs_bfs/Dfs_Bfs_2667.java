package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.acmicpc.net/problem/2667
 */
public class Dfs_Bfs_2667 {

	static int n;
	static int[][] graph;

	static int count;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public static void solution() {
		int total = 0;
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (graph[i][j] == 1) {
					total++;

					dfs(i, j);
					list.add(count);
					count = 0;
				}
			}
		}

		Collections.sort(list);

		System.out.println(total);

		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	public static void dfs(int y, int x) {
		graph[y][x] = 0;
		count++;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < n && nx >= 0 && nx < n && graph[ny][nx] == 1) {
				dfs(ny, nx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < n; j++) {
				graph[i][j] = tmp.charAt(j) - '0';
			}
		}

		solution();
	}
}
