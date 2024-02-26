package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */
public class String_12918 {

	public static boolean solution(String s) {
		if (s.length() != 4 && s.length() != 6) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s1 = "a234";
		String s2 = "1234";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}
}
