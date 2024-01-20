package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/4963
 */
public class Dfs_Bfs_4963 {

	static int w;
	static int h;
	static int[][] graph;

	static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

	public static int solution() {
		int answer = 0;

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (graph[j][i] == 1) {
					dfs(i, j);
					answer++;
				}
			}
		}

		return answer;
	}

	public static void dfs(int x, int y) {
		graph[y][x] = 0;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < w && ny >= 0 && ny < h && graph[ny][nx] == 1) {
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			graph = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println(solution());
		}

		br.close();
	}
}
