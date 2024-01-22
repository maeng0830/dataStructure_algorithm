package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/16173
 */
public class Dfs_Bfs_16173 {

	static int n; // 가로세로 길이
	static int[][] graph;
	static String answer = "Hing";

	public static String dfs(int y, int x) {
		if (answer.equals("HaruHaru") || graph[y][x] == -1) {
			answer = "HaruHaru";
			return answer;
		}

		int ny = y + graph[y][x];
		int nx = x + graph[y][x];

		if (ny < n) {
			dfs(ny, x);
		}

		if (nx < n) {
			dfs(y, nx);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));
	}
}
