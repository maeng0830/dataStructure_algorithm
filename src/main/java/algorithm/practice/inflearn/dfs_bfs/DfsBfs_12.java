package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
 * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 * 첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.
 * 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
 * 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
 * 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * 6 4
 * 0 0 -1 0 0 0
 * 0 0 1 0 -1 0
 * 0 0 -1 0 0 0
 * 0 0 0 0 -1 1
 *
 * 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
 * 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
 * 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * 4
 */
public class DfsBfs_12 {

	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	static int[][] board, dis;
	static int n, m;

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int solution() {
		int answer = 0;
		Queue<Point> queue = new LinkedList<>();

		// 출발 지점들을 모두 queue에 삽입
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					queue.offer(new Point(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point tmp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];

				if (ny < n && ny >= 0 && nx < m && nx >= 0 && board[ny][nx] == 0) {
					board[ny][nx] = 1;
					dis[ny][nx] = dis[tmp.y][tmp.x] + 1;
					queue.offer(new Point(ny, nx));
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 토마토가 모두 익지는 못하는 상황
				if (board[i][j] == 0) {
					return -1;
				}

				answer = Math.max(answer, dis[i][j]);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 가로 크기
		n = Integer.parseInt(st.nextToken()); // 세로 크기

		board = new int[n][m];
		dis = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solution());
	}
}
