package algorithm.practice.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_10989 {

	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		mergeSorting(0, numbers.length - 1);

		for (int number : numbers) {
			System.out.println(number);
		}
	}

	public static void merge(int start, int mid, int end) {
		int lt = start;
		int rt = mid + 1;
		int idx = start;

		int[] tmp = new int[numbers.length];

		while (lt <= mid && rt <= end) {
			if (numbers[lt] < numbers[rt]) {
				tmp[idx] = numbers[lt];
				lt++;
				idx++;
			} else {
				tmp[idx] = numbers[rt];
				rt++;
				idx++;
			}
		}

		if (lt > mid) {
			while (rt <= end) {
				tmp[idx] = numbers[rt];
				rt++;
				idx++;
			}
		} else {
			while (lt <= mid) {
				tmp[idx] = numbers[lt];
				lt++;
				idx++;
			}
		}

		for (int i = start; i <= end; i++) {
			numbers[i] = tmp[i];
		}
	}

	public static void mergeSorting(int start, int end) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;

		mergeSorting(start, mid);
		mergeSorting(mid + 1, end);

		merge(start, mid, end);
	}
}
