package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class String_12932 {

	public static int[] solution(long n) {
		String str = String.valueOf(n);

		int[] result = new int[str.length()];

		for (int i = str.length() - 1; i >= 0; i--) {
			result[str.length() - 1 - i] = str.charAt(i) - '0';
		}

		return result;
	}

	public static void main(String[] args) {
		long input = 54321;

		int[] result = solution(input);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
