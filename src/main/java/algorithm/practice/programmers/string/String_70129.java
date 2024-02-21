package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class String_70129 {

	public static int[] solution(String s) {
		int[] result = new int[2]; // 0은 이진 변환 횟수, 1은 제거된 모든 0의 개수

		int zeroCount = 0;
		int convertCount = 0;

		while (!s.equals("1")) {
			convertCount++;

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '0') {
					zeroCount++;
				} else {
					sb.append(c);
				}
			}

			s = Integer.toBinaryString(sb.length());
		}

		result[0] = convertCount;
		result[1] = zeroCount;

		return result;
	}

	public static void main(String[] args) {
		String s1 = "110010101001";
		String s2 = "01110";
		String s3 = "1111111";

		int[] result1 = solution(s1);
		System.out.println(result1[0] + " " + result1[1]);

		int[] result2 = solution(s2);
		System.out.println(result2[0] + " " + result2[1]);

		int[] result3 = solution(s3);
		System.out.println(result3[0] + " " + result3[1]);
	}
}
