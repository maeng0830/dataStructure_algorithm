package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1388
 */
public class Dfs_Bfs_1388 {

	static int n; // 세로
	static int m; // 가로
	static char[][] graph;

	public static int solution() {
		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] != '*') {
					dfs(i, j);
					answer++;
				}
			}
		}

		return answer;
	}

	public static void dfs(int y, int x) {
		char tmp = graph[y][x];

		graph[y][x] = '*';

		if (tmp == '-') {
			int nx = x + 1;

			if (nx < m && graph[y][nx] == '-') {
				dfs(y, nx);
			}
		} else {
			int ny = y + 1;

			if (ny < n && graph[ny][x] == '|') {
				dfs(ny, x);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new char[n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();

			for (int j = 0; j < m; j++) {
				graph[i][j] = input.charAt(j);
			}
		}

		System.out.println(solution());
	}
}
