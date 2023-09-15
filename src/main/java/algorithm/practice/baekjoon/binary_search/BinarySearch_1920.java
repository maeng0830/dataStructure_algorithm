package algorithm.practice.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_1920 {

	public static int solution(int[] a, int left, int right, int target) {
		if (left > right) {
			return 0;
		}

		int mid = (left + right) / 2;

		if (a[mid] == target) {
			return 1;
		} else if (a[mid] < target) {
			return solution(a, mid + 1, right, target);
		} else {
			return solution(a, left, mid - 1, target);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// n
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		// a
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);

		// m
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		// numbers
		int[] numbers = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		for (int number : numbers) {
			System.out.println(solution(a, 0, n - 1, number));
		}
	}
}
