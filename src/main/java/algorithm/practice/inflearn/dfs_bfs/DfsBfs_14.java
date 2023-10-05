package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 격자판 정보가 주어진다.
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 *
 * 첫 번째 줄에 섬의 개수를 출력한다.
 * 5
 */
public class DfsBfs_14 {
	static int answer = 0;
	static int n = 0;
	static int[][] board;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

	public static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void bfs(int y, int x) {
		Queue<Point> queue = new LinkedList<>();

		board[y][x] = 0;
		queue.offer(new Point(y, x));

		while (!queue.isEmpty()) {
			Point tmp = queue.poll();

			for (int i = 0; i < 8; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];

				if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 1) {
					board[ny][nx] = 0;
					queue.offer(new Point(ny, nx));
				}
			}
		}
	}

	public static int solution(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					answer++;
					bfs(i, j);
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution(board));
	}
}
