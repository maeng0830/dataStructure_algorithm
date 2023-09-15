package algorithm.practice.inflearn.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 */

/*
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 * it is time to study
 */

/**
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.
 * study
 */
public class String3 {

	public static String solution(String sentence) {
		String answer = "";

		// 문장을 단어로 나눠 배열을 생성한다.
		String[] words = sentence.split(" ");

		// 단어를 순회한다.
		for (String word : words) {
			// 현재 정답보다 길이가 긴 단어를 찾으면, 정답을 변경한다.
			if (answer.length() < word.length()) {
				answer = word;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sentence = br.readLine();

		System.out.println(solution(sentence));
	}
}
