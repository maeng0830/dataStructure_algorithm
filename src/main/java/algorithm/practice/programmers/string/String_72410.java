package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class String_72410 {

	public static String solution(String new_id) {
		StringBuilder sb = new StringBuilder();
		boolean checkDot = false;

		// 대문자 -> 소문자, 필요없는 문자 제거, 2개 이상의 연속된 마침표 -> 하나의 마침표
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);

			// 숫자
			if (Character.isDigit(c)) {
				sb.append(c);
				checkDot = false;
			}

			// 대문자 -> 소문자
			if (Character.isAlphabetic(c)) {
				sb.append(Character.toLowerCase(c));
				checkDot = false;
			}

			// -, _
			if (c == '-' || c == '_') {
				sb.append(c);
				checkDot = false;
			}

			// .
			if (c == '.' && !checkDot) {
				sb.append(c);
				checkDot = true;
			}
		}

		// 시작과 끝의 마침표 제거
		if (sb.length() != 0 && sb.charAt(0) == '.') {
			sb.deleteCharAt(0);
		}

		if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.') {
			sb.deleteCharAt(sb.length() - 1);
		}


		// new_id의 길이가 16 이상이면 첫 15 문자만 사용 -> 끝 문자가 "."이라면 해당 문자 제거
		// (new_id가 빈 문자열이라면 "a" 대입) -> new_id의 길이가 2 이하라면, new_id의 마지막 문자를 길이가 3될 때까지 추가
		if (sb.length() >= 16) {
			sb = new StringBuilder(sb.substring(0, 15));

			if (sb.charAt(sb.length() - 1) == '.') {
				sb.deleteCharAt(sb.length() - 1);
			}
		} else if (sb.length() <= 2) {
			if (sb.length() == 0) {
				sb.append("a");
			}

			while (sb.length() < 3) {
				sb.append(sb.charAt(sb.length() - 1));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
		String new_id2 = "z-+.^.";
		String new_id3 = "=.=";
		String new_id4 = "123_.def";
		String new_id5 = "abcdefghijklmn.p";

		System.out.println(solution(new_id1));
		System.out.println(solution(new_id2));
		System.out.println(solution(new_id3));
		System.out.println(solution(new_id4));
		System.out.println(solution(new_id5));
	}
}
