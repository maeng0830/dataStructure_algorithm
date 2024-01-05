package algorithm.practice.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1654 {

	static long n;
	static long target;
	static long[] cables;

	public static long solution(long n, long target, long[] cables) {
		Arrays.sort(cables);

		long left = 1;
		long right = cables[(int) n - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long acc = 0;

			for (long cable : cables) {

				acc += cable / mid;
			}

			if (acc == target) {
				left = mid + 1;
			} else if (acc > target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return (left + right) / 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		target = Integer.parseInt(st.nextToken());

		cables = new long[(int) n];
		for (int i = 0; i < n; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(solution(n, target, cables));
	}
}
