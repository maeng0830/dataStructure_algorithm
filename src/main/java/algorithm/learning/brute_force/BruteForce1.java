package algorithm.learning.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BruteForce1 {

	public static void solution(long n) {
		int i = 2;

		while (i < 1000000) {
			if (n % i == 0) {
				System.out.println("NO");
				break;
			}

			i++;

			if (i == 1000000) {
				System.out.println("YES");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			solution(Long.parseLong(br.readLine()));
		}
	}
}
