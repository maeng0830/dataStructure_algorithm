package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class DfsBfs_13 {

	static int answer = 0;
	static int n = 0;
	static int[][] board;
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void dfs(int y, int x, int[][] board) {
		// 방문한 육지를 0으로 바꾼다.
		board[y][x] = 0;

		// 현재 위치에서 8방향으로 탐색한다.
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 현재 위치에서 특정 방향이 육지인 경우, dfs를 호출한다.
			if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 1) {
				dfs(ny, nx, board);
			}
		}
	}

	public static int solution(int[][] board) {
		// board를 순회하면서 값이 1인 경우를 탐색한다.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				// board의 값이 1인 경우, 섬의 갯수를 +1하고, dfs를 호출한다.
				if (board[i][j] == 1) {
					answer++;
					dfs(i, j, board);
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
