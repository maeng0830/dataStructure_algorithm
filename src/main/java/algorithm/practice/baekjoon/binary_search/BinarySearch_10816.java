package algorithm.practice.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10816
 */
public class BinarySearch_10816 {

	static int[] hasNumbers;
	static int[] targetNumbers;


	public static int lowerBound(int number) {
		int left = 0;
		int right = hasNumbers.length - 1;
		int answer = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (hasNumbers[mid] == number) {
				answer = mid;
				right = mid - 1;
			} else if (hasNumbers[mid] > number) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}

	public static int upperBound(int number) {
		int left = 0;
		int right = hasNumbers.length - 1;
		int answer = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (hasNumbers[mid] == number) {
				answer = mid;
				left = mid + 1;
			} else if (hasNumbers[mid] > number) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}

	public static void solution(int[] hasNumbers, int[] targetNumbers) {
		// 이분 탐색을 위한 정렬
		Arrays.sort(hasNumbers);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < targetNumbers.length; i++) {
			int targetNumber = targetNumbers[i];

			int low = lowerBound(targetNumber);
			int high = upperBound(targetNumber);

			if (low == -1) {
				sb.append(0 + " ");
			} else {
				sb.append((high - low + 1) + " ");
			}
		}

		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine()); // 상근이의 카드 개수
		hasNumbers = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			hasNumbers[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine()); // 타겟 카드 개수
		targetNumbers = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			targetNumbers[i] = Integer.parseInt(st.nextToken());
		}

		solution(hasNumbers, targetNumbers);
	}
}
