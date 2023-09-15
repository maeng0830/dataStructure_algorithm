package algorithm.practice.baekjoon.math_optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MathOptimization_15736 {

	public static int solution(int n) {

		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(solution(n));
	}
}
