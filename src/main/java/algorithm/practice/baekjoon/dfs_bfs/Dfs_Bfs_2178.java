package algorithm.practice.baekjoon.dfs_bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/2178
 */
public class Dfs_Bfs_2178 {

	static int n;
	static int m;
	static int[][] graph;
	static int[][] dist;

	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static int solution() {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(1, 1));
		graph[1][1] = 0;
		dist[1][1] = 1;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];

				if (ny >= 1 && ny <= n && nx >= 1 && nx <= m && graph[ny][nx] != 0) {
					graph[ny][nx] = 0;
					dist[ny][nx] = dist[cur.y][cur.x] + 1;

					queue.add(new Node(ny, nx));
				}
			}

			if (graph[n][m] == 0) {
				break;
			}
		}

		return dist[n][m];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][m + 1];
		dist = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			String tmp = br.readLine();

			for (int j = 1; j <= m; j++) {
				graph[i][j] = tmp.charAt(j - 1) - '0';
			}
		}

		System.out.println(solution());
	}
}
