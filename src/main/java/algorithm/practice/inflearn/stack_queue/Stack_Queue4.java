package algorithm.practice.inflearn.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 * 352+*9-
 *
 * 연산한 결과를 출력합니다.
 * 12
 */
public class Stack_Queue4 {

	public static int solution(String str) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c != '+' && c != '-' && c != '*' && c != '/') {
				// char '0'의 아스키코드는 48이다. 그리고 '1'의 아스키 코드는 49이다.
				// char 간의 연산은 아스키 코드 값으로 이뤄지기 때문에, int로 변환하고 싶은 char - '0'를 하면된다.
				stack.push(c - '0');
				continue;
			}

			if (c == '+') {
				stack.push(stack.pop() + stack.pop());
			} else if (c == '-') {
				stack.push(-stack.pop() + stack.pop());
			} else if (c == '*') {
				stack.push(stack.pop() * stack.pop());
			} else {
				stack.push(stack.pop() / stack.pop());
			}
		}

		return stack.pop();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(solution(str));
	}
}
