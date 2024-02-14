package algorithm.practice.baekjoon.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * https://www.acmicpc.net/problem/9012
 */
public class Stack_Queue_9012 {

	static int n;

	public static void solution(char[] chars) {
		Stack<Character> stack = new Stack<>();

		for (char c : chars) {
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					System.out.println("NO");
					return;
				} else {
					stack.pop();
				}
			}
		}

		if (!stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();

			solution(chars);
		}
	}
}
