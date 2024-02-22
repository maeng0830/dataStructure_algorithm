package algorithm.practice.programmers.string;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class String_81301 {

	public static int solution(String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder wordSb = new StringBuilder();


		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else {
				wordSb.append(c);
			}

			boolean convert = convertAdd(sb, wordSb);

			if (convert) {
				wordSb = new StringBuilder();
			}
		}

		return Integer.parseInt(sb.toString());
	}

	private static boolean convertAdd(StringBuilder sb, StringBuilder wordSb) {
		String word = wordSb.toString();

		int before = sb.length();

		switch (word) {
			case "zero":
				sb.append(0);
				break;
			case "one":
				sb.append(1);
				break;
			case "two":
				sb.append(2);
				break;
			case "three":
				sb.append(3);
				break;
			case "four":
				sb.append(4);
				break;
			case "five":
				sb.append(5);
				break;
			case "six":
				sb.append(6);
				break;
			case "seven":
				sb.append(7);
				break;
			case "eight":
				sb.append(8);
				break;
			case "nine":
				sb.append(9);
				break;
		}

		return before < sb.length();
	}

	public static void main(String[] args) {
		String s1 = "one4seveneight";
		String s2 = "23four5six7";
		String s3 = "2three45sixseven";
		String s4 = "123";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
	}
}
