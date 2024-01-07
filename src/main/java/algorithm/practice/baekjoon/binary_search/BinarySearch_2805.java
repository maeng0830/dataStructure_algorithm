package algorithm.practice.baekjoon.binary_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_2805 {

	static int n;
	static int m;
	static int[] trees;

	public static int solution() {
		Arrays.sort(trees);

		int left = 0;
		int right = trees[n - 1];

		while (left < right) {
			int mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < n; i++) {
				int tmp = trees[i] - mid;

				if (tmp >= 1) {
					sum += tmp;
				}
			}

			if (sum >= m) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		trees = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution());
	}
}
