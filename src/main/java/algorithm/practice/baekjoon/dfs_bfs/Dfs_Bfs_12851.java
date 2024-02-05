package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12851
 */
public class Dfs_Bfs_12851 {

	static int n;
	static int k;
	static int[] dist;

	public static void bfs() {
		if (n == k) {
			System.out.println(0);
			System.out.println(1);
			return;
		}

		int count = 0;
		int min = Integer.MAX_VALUE;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (min < dist[cur]) {
				break;
			}

			for (int i = 0; i < 3; i++) {
				int next = cur;

				if (i == 0) {
					next += 1;
				} else if (i == 1) {
					next -= 1;
				} else {
					next *= 2;
				}

				if (next >= 0 && next < dist.length && (dist[next] == 0 || dist[next] == dist[cur] + 1)) {
					if (next == k) {
						dist[k] = dist[cur] + 1;
						min = dist[k];
						count++;
					} else {
						queue.offer(next);
						dist[next] = dist[cur] + 1;
					}
				}
			}
		}

		System.out.println(dist[k]);
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		dist = new int[100001];

		bfs();
	}
}
