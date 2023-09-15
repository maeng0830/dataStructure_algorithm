package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 */

/*
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다. 문자열은 영어 알파벳으로만 구성되어 있습니다.
 * StuDY
 */

/*
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 * sTUdy
 */
public class String2 {

	public static String solution(String word) {
		StringBuilder sb = new StringBuilder();

		// word를 구성하는 문자를 순회하면서, 각 문자의 대소문자를 변환하여 sb에 추가한다.
		for (char c : word.toCharArray()) {
			if (c >= 97) {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();

		System.out.println(solution(word));
	}
}
