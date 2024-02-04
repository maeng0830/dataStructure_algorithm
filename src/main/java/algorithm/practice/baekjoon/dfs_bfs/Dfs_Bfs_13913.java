package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/13913
 */
public class Dfs_Bfs_13913 {

	static int n;
	static int k;
	static int[] dist;

	static class Node {
		Node prev;
		int cur;

		public Node(Node prev, int cur) {
			this.prev = prev;
			this.cur = cur;
		}
	}

	public static void bfs() {
		if (n == k) {
			System.out.println(0);
			System.out.println(n);
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(null, n));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next = cur.cur;

				if (i == 0) {
					next += 1;
				} else if (i == 1) {
					next -= 1;
				} else {
					next *= 2;
				}

				if (next >= 0 && next < dist.length && dist[next] == 0) {
					dist[next] = dist[cur.cur] + 1;
					queue.offer(new Node(cur, next));
				}
			}

			if (dist[k] != 0) {
				break;
			}
		}

		System.out.println(dist[k]);

		Node tmp = null;

		while (!queue.isEmpty()) {
			Node cur = queue.peek();

			if (cur.cur == k) {
				tmp = queue.poll();
				break;
			} else {
				queue.poll();
			}
		}

		Stack<Integer> stack = new Stack<>();

		while (tmp != null) {
			stack.push(tmp.cur);
			tmp = tmp.prev;
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
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
