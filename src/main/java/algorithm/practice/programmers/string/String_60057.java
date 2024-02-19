package algorithm.practice.programmers.string;

import java.util.Stack;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class String_60057 {

	public static int solution(String s) {
		int result = s.length();

		for (int i = 1; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			Stack<String> stack = new Stack<>();
			int index = 0;

			// 현재 단위로 딱 떨어지는 위치 까지 해결
			while (index <= s.length() - i) {
				String substring = s.substring(index, index + i);

				if (stack.empty() || stack.peek().equals(substring)) {
					stack.push(substring);
				} else {
					int count = stack.size();

					if (count != 1) {
						sb.append(count + stack.peek());
						stack.clear();
					} else {
						sb.append(stack.pop());
					}

					stack.push(substring);
				}

				index += i;
			}

			if (!stack.empty()) {
				if (stack.size() == 1) {
					sb.append(stack.pop());
				} else {
					sb.append(stack.size() + stack.pop());
				}
			}

			// 나머지 부분 해결
			sb.append(s.substring(index));

			result = Math.min(result, sb.length());
		}

		return result;
	}

	public static void main(String[] args) {
		String input1 = "aabbaccc";
		String input2 = "ababcdcdababcdcd";
		String input3 = "abcabcdede";
		String input4 = "abcabcabcabcdededededede";
		String input5 = "xababcdcdababcdcd";

		System.out.println(solution(input1));
		System.out.println(solution(input2));
		System.out.println(solution(input3));
		System.out.println(solution(input4));
		System.out.println(solution(input5));
	}
}
