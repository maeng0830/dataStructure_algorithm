package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1012
 */
public class Dfs_Bfs_1012 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	static int t;
	static int m;
	static int n;
	static int k;
	static int[][] graph;

	static int answer;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			inputData();
			System.out.println(solution());
			answer = 0;
		}
	}

	public static void inputData() throws IOException {
		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 가로
		n = Integer.parseInt(st.nextToken()); // 세로
		k = Integer.parseInt(st.nextToken()); // 배추 개수

		graph = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 배추 가로 위치
			int y = Integer.parseInt(st.nextToken()); // 배추 세로 위치

			graph[y][x] = 1;
		}
	}

	public static void dfs(int x, int y) {
		graph[y][x] = 0;

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (nX >= 0 && nX < m && nY >= 0 && nY < n && graph[nY][nX] != 0) {
				dfs(nX, nY);
			}
		}
	}

	public static int solution() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[j][i] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}

		return answer;
	}
}
