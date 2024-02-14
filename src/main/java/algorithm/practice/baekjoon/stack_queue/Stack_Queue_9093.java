package algorithm.practice.baekjoon.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_Queue_9093 {

	static int t; // 테스트 개수

	public static void solution(String string) {
		StringBuilder answer = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		char[] chars = string.toCharArray();

		for (char c : chars) {
			if (c != ' ') {
				stack.push(c);
			} else {
				while (!stack.isEmpty()) {
					answer.append(stack.pop());
				}

				answer.append(" ");
			}
		}

		while (!stack.isEmpty()) {
			answer.append(stack.pop());
		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String tmp = br.readLine();

			solution(tmp);
		}
	}
}
