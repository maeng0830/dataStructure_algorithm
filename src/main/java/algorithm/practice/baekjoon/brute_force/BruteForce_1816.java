package algorithm.practice.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_1816 {

	public static void solution(long password) {
		int i = 2;

		while (i <= 1000000) {
			if (password % i == 0) {
				System.out.println("NO");
				return;
			}

			i++;
		}

		System.out.println("YES");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			solution(Long.parseLong(br.readLine()));
		}
	}
}
