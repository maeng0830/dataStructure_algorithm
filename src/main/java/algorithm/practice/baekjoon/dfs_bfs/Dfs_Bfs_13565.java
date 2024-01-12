package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13565
 */
public class Dfs_Bfs_13565 {

	static int m;
	static int n;
	static int[][] graph;

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static String answer;

	public static String solution() {
		answer = "NO";

		for (int i = 0; i < n; i++) {
			if (answer.equals("YES")) {
				break;
			}

			if (graph[0][i] == 0) {
				dfs(0, i);
			}
		}

		return answer;
	}

	public static void dfs(int y, int x) {
		if (y == m - 1 || answer.equals("YES")) {
			answer = "YES";
			return;
		}

		graph[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < m && nx >= 0 && nx < n && graph[ny][nx] == 0) {
				dfs(ny, nx);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(st.nextToken()); // 가로

		graph = new int[m][n];

		for (int i = 0; i < m; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < n; j++) {
				if (tmp.charAt(j) == '0') {
					graph[i][j] = 0;
				} else {
					graph[i][j] = 1;
				}
			}
		}

		System.out.println(solution());
	}
}
