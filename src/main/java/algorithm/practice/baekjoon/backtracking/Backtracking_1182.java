package algorithm.practice.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backtracking_1182 {

	static int answer;

	public static void solution(int n, int s, int[] ints, int cur, int sum) {
		if (n == cur) {
			if (s == sum) {
				answer++;
			}
			return;
		}

		solution(n, s, ints, cur + 1, sum);
		solution(n, s, ints, cur + 1, sum + ints[cur]);
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] ints = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

		if (s == 0) {
			answer--;
		}

		solution(n, s, ints, 0, 0);

		System.out.println(answer);
	}
}
