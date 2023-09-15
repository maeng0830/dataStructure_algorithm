package algorithm.practice.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce_14568 {

	public static int solution(int n) {
		int answer = 0;

		for (int a = 1; a < n + 1; a++) {
			if (a % 2 != 0) {
				continue;
			}
			for (int b = 1; b < n + 1 - a; b++) {
				for (int c = b + 2; c < n + 1 - a - b; c++) {
					if (a + b + c == n) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
}
