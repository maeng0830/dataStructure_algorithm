package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
public class String_12930 {

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();

		int index = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ' ') {
				sb.append(c);
				index = 0;
			} else if (index % 2 == 0) {
				char upperC = Character.toUpperCase(c);
				sb.append(upperC);
				index++;
			} else {
				char lowerC = Character.toLowerCase(c);
				sb.append(lowerC);
				index++;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "try hello world";

		String result = solution(input);
		System.out.println(result);
	}
}
