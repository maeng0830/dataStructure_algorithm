package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
 */

/*
 * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
 * Computercooler
 * c
 */

/*
 * 첫 줄에 해당 문자의 개수를 출력한다.
 * 2
 */
public class String1 {

	public static int solution(String word, char letter) {
		int answer = 0;

		// letter의 대소문자 여부에 따라서 word도 대소문자 변환 해준다.
		if (letter >= 97) {
			word = word.toLowerCase();
		} else {
			word = word.toUpperCase();
		}

		// word를 구성하는 문자를 순회하면서 letter와 일치할 때 카운트한다.
		for (char c : word.toCharArray()) {
			if (c == letter) {
				answer++;
			}
		}

		return answer;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String word = br.readLine();
		char letter = br.readLine().charAt(0);

		int answer = solution(word, letter);

		System.out.println(answer);
	}
}
