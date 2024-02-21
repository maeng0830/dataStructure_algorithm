package algorithm.practice.programmers.string;

/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class String_68935 {
	
	public static int solution(int n) {
		// 10진법 -> 3진법
		String preThree = Integer.toString(n, 3);

		// 3진법 숫자 앞뒤로 뒤집기
		StringBuilder sb = new StringBuilder();

		for (int i = preThree.length() - 1; i >= 0; i--) {
			sb.append(preThree.charAt(i));
		}

		// 3진법 -> 10진법
		return Integer.valueOf(sb.toString(), 3);
	}

	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 125;

		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}
}
