package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들의 무시합니다.
 *
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 * YES
 */

public class String8 {
	public static String solution(String str) {
		StringBuilder sb = new StringBuilder();

		// 문자열을 구성하는 문자를 모두 소문자로 변경한 뒤 배열로 생성한다.
		// 문자열에 알파벳이 아닌 문자가 포함되어있더라도 toLowerCase, toUpperCase가 가능하다!
		char[] chars = str.toLowerCase().toCharArray();

		// 알파벳인 문자만 sb에 담아준다.
		for (char c : chars) {
			if ((c >= 97 && c <= 122)) {
				sb.append(c);
			}
		}

		// 서로 대칭되는 위치의 문자가 동일한지 확인한다.
		for (int i = 0; i < sb.length() / 2; i++) {
			char front = sb.charAt(i);
			char back = sb.charAt(sb.length() - 1 - i);

			if (!(front == back)) {
				return "NO";
			}
		}

		return "YES";
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		System.out.println(solution(str));
	}
}
