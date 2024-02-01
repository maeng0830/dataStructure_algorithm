package algorithm.practice.baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/6603
 */
public class Dfs_Bfs_6603 {

	static int k;
	static int[] s;

	public static void dfs(int index, int count, StringBuilder sb) {
		if (count == 6) {
			System.out.println(sb.toString());
			return;
		}

		if (index == k) {
			return;
		}

		// 현재 원소 포함
		sb.append(s[index]).append(" ");
		dfs(index + 1, count + 1, sb);

		// 현재 원소 미포함
		int sIndex = sb.indexOf(String.valueOf(s[index]));
		sb.delete(sIndex, sb.lastIndexOf(" ") + 1);
		dfs(index + 1, count, sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				break;
			}

			s = new int[k];

			for (int i = 0; i < k; i++) {
				s[i] = Integer.parseInt(st.nextToken());
			}

			StringBuilder sb = new StringBuilder();

			dfs(0, 0, sb);
			System.out.println();
		}
	}
}
