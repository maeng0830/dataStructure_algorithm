package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 * ksekkset
 *
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 * kset
 */

public class String6 {

	public static String solution(String str) {
		// 정답 문자열을 저장할 StringBuilder를 생성한다.
		StringBuilder sb = new StringBuilder();

		// 입력 문자열을 char[]으로 변환한다.
		char[] charArray = str.toCharArray();

		// char[]을 순회하면서, StringBuilder에 없을 경우에만 추가한다.
		for (char c : charArray) {
			if (sb.indexOf(String.valueOf(c))  == -1) {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(solution(str));
	}
}
