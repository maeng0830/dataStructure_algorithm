package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 *
 * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 *
 * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 * 12
 */
public class DfsBfs_11 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public int solution(int y, int x, int[][] maze, int[][] dis) {
		Queue<Point> queue = new LinkedList<>();

		queue.offer(new Point(y, x));
		maze[y][x] = 1;

		while (!queue.isEmpty()) {
			Point tmp = queue.poll(); // 현재 지점

			for (int i = 0; i < 4; i++) {
				//  다음 지점 후보군
				int ny = tmp.y + dy[i];
				int nx = tmp.x + dx[i];

				// 조건을 충족하는 다음 지점 탐색
				if (ny >= 1 && ny <= 7 && nx >= 1 && nx <= 7 && maze[ny][nx] != 1) {
					maze[ny][nx] = 1; // 다음 지점 방문
					queue.offer(new Point(ny, nx)); // 다음 지점을 큐에 삽입
					dis[ny][nx] = dis[tmp.y][tmp.x] + 1; // 다음 지점까지의 거리 저장

					// 방문한 지점이 목적지일 경우, 거리 반환
					if (ny == 7 && nx == 7) {
						return dis[ny][nx];
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		DfsBfs_11 dfsBfs_11 = new DfsBfs_11();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] maze = new int[8][8];
		int[][] dis = new int[8][8];

		for (int i = 1; i < maze.length; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < maze.length; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfsBfs_11.solution(1, 1, maze, dis));
	}
}
