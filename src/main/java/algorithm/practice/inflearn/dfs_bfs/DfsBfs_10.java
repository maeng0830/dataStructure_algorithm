package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 *
 * 7*7 격자판의 정보가 주어집니다.
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 *
 * 첫 번째 줄에 경로의 가지수를 출력한다.
 * 8
 */
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
