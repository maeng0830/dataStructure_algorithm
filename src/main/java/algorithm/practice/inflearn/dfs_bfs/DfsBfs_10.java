package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsBfs_10 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = 0;

	public static void solution(int y, int x, int[][] maze) {
		if (y == 7 && x == 7) {
			answer++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[ny][nx] == 0) {
				maze[ny][nx] = 1;
				solution(ny, nx, maze);
				maze[ny][nx] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] maze = new int[8][8];

		for (int i = 1; i < maze.length; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < maze.length; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maze[1][1] = 1;

		solution(1, 1, maze);

		System.out.println(answer);
	}
}
