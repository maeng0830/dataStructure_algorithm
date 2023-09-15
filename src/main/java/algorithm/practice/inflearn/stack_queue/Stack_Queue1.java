package algorithm.practice.inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 * (()(()))(()
 *
 * 첫 번째 줄에 YES, NO를 출력한다.
 * NO
 */
public class Stack_Queue1 {

	public static String solution(String str) {
		Stack<Character> stack = new Stack<>();
		char[] chars = str.toCharArray();

		for (char c : chars) {
			if (stack.isEmpty()) {
				if (c == '(') {
					stack.add(c);
				} else {
					return "NO";
				}
			} else if (stack.peek() == c) {
				stack.add(c);
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return "YES";
		} else {
			return "NO";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(solution(str));
	}
}
