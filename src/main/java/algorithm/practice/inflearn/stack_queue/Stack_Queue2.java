package algorithm.practice.inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 *
 * 남은 문자만 출력한다.
 * EFLM
 */

public class Stack_Queue2 {

	public static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();
		StringBuilder answer = new StringBuilder();

		for (char c : chars) {
			if (c != ')') {
				stack.add(c);
			} else {
				while (stack.peek() != '(') {
					stack.pop();
				}
				stack.pop();
			}
		}

		while (!stack.isEmpty()) {
			answer.append(stack.pop());
		}

		answer.reverse();

		return answer.toString();
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(solution(str));
	}
}
