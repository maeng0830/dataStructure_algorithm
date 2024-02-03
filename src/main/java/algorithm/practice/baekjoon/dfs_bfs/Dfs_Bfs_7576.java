package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/7576
 */
public class Dfs_Bfs_7576 {

	static int n; // 세로
	static int m; // 가로
	static int[][] box;
	static Queue<Tomato> queue;

	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static class Tomato {
		int y;
		int x;

		public Tomato(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int solution() {
		int answer = 0;

		bfs();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					return -1;
				} else {
					answer = Math.max(answer, box[i][j]);
				}
			}
		}

		return answer - 1;
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Tomato cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (ny >= 0 && ny < n && nx >= 0 && nx < m && box[ny][nx] == 0) {
					queue.offer(new Tomato(ny, nx));
					box[ny][nx] = box[cur.y][cur.x] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		box = new int[n][m];
		queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if (box[i][j] == 1) {
					queue.offer(new Tomato(i, j));
				}
			}
		}

		System.out.println(solution());
	}
}
