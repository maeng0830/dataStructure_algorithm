package algorithm.learning.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce2 {

	public static int solution(int n) {
		int count = 0;

		for (int a = 0; a < n + 1; a++) {
			for (int b = 0; b < n + 1 - a; b++) {
				for (int c = 0; c < n + 1 - a - b; c++) {
					if (a + b + c == n) {
						if (a >= b + 2) {
							if (a != 0 && b != 0 && c != 0) {
								if (c % 2 == 0) {
									count++;
								}
							}
						}
					}
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
}
