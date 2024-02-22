package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class String_12916 {

	public static boolean solution(String s) {
		int[] count = new int[2]; // 0: p 개수, 1: y개수

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == 'p' || c == 'P') {
				count[0]++;
			} else if (c == 'y' || c == 'Y') {
				count[1]++;
			}
		}

		return count[0] == count[1];
	}

	public static void main(String[] args) {
		String s1 = "pPoooyY";
		String s2 = "Pyy";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}


}
