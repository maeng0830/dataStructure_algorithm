package algorithm.practice.programmers.stack_queue;

import data_structure.stack_queue_deque.stack.Stack;
import java.util.Arrays;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Programmers_12906 {

	public static int[] solution(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (stack.empty()) {
				stack.push(arr[i]);
				continue;
			}

			if (stack.peek() == arr[i]) {
				continue;
			} else {
				stack.push(arr[i]);
			}
		}

		int[] result = new int[stack.size()];

		for (int i = 0; i < result.length; i++) {
			result[result.length - 1 - i] = stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {
		int[] input1 = {1, 1, 3, 3, 0, 1, 1};
		int[] input2 = {4, 4, 4, 3, 3};

		System.out.println(Arrays.toString(solution(input1)));
		System.out.println(Arrays.toString(solution(input2)));
	}
}
