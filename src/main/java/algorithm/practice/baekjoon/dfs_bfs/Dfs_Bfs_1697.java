package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/1697
 */
public class Dfs_Bfs_1697 {

	static int n;
	static int k;
	static int[] dist = new int[100001];

	public static int bfs() {
		if (n == k) {
			return 0;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next = cur;

				if (i == 0) {
					next += 1;
				} else if (i == 1) {
					next -= 1;
				} else {
					next *= 2;
				}

				if (next >= 0 && next < dist.length && dist[next] == 0) {
					queue.offer(next);
					dist[next] = dist[cur] + 1;
				}
			}

			if (dist[k] != 0) {
				break;
			}
		}

		return dist[k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(bfs());
	}
}
