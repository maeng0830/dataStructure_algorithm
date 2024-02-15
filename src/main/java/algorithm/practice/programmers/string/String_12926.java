package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */
public class String_12926 {

	public static String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ' ') {
				sb.append(c);
			} else if (c >= 'a' && c <= 'z') {
				int position = (c - 'a' + n) % ('z' - 'a' + 1);
				char nc = (char) (position + 'a');
				sb.append(nc);
			} else {
				int position = (c - 'A' + n) % ('Z' - 'A' + 1);
				char nc = (char) (position + 'A');
				sb.append(nc);
			}
		}

		return sb.toString();
	}


	public static void main(String[] args) {
		String s1 = "AB";
		int n1 = 1;

		String s2 = "z";
		int n2 = 1;

		String s3 = "a B z";
		int n3 = 4;

		System.out.println(solution(s2, n2));
	}
}
