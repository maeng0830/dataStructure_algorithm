package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 */

/**
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 * 3
 * good
 * Time
 * Big
 */

/**
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 * doog
 * emiT
 * giB
 */

public class String4 {

	public static void solution(StringBuilder[] words) {
		// 단어 배열을 순회한다.
		for (StringBuilder word : words) {
			// 단어의 절반 이하 문자까지만 순회한다.
			for (int i = 0; i < word.length() / 2; i++) {
				// 대칭되는 위치에 있는 문자를 임시 저장한다.
				char front = word.charAt(i);
				char back = word.charAt((word.length() - 1) - i);

				// 대칭되는 위치의 문자를 서로 변경한다.
				word.setCharAt(i, back);
				word.setCharAt((word.length() - 1) - i, front);
			}

			System.out.println(word);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = Integer.parseInt(br.readLine());
		StringBuilder[] words = new StringBuilder[count];

		for (int i = 0; i < words.length; i++) {
			words[i] = new StringBuilder(br.readLine());
		}

		solution(words);
	}
}
