package algorithm.practice.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_2947 {

	static int[] numbers;

	public static void solution(int n) {
		if (n == numbers.length - 1) {
			boolean check = check();

			if (!check) {
				solution(1);
			}

			return;
		}

		if (numbers[n] > numbers[n + 1]) {
			int tmp = numbers[n + 1];
			numbers[n + 1] = numbers[n];
			numbers[n] = tmp;

			print();

			solution(n + 1);
		} else {
			solution(n + 1);
		}
	}

	public static boolean check() {
		boolean check = true;

		for (int i = 1; i < numbers.length; i++) {
			if (i != numbers[i]) {
				check = false;
				break;
			}
		}

		return check;
	}

	public static void print() {
		for (int i = 1; i < numbers.length; i++) {
			if (i < numbers.length - 1) {
				System.out.print(numbers[i] + " ");
			} else {
				System.out.println(numbers[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		numbers = new int[6];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		solution(1);
	}
}
