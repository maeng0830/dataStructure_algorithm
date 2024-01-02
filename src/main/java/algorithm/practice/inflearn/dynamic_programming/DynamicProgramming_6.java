package algorithm.practice.inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 * 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 *
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 * 41
 */
public class DynamicProgramming_6 {

	static int n;
	static int m;
	static int[] memo;
	static ArrayList<Problem> problems = new ArrayList<>();

	static class Problem {
		int score;
		int time;

		public Problem(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static int solution() {
		memo = new int[m + 1];

		for (int i = 0; i < problems.size(); i++) {
			Problem problem = problems.get(i);

			// 냅색 알고리즘에서 각 선택지를 중복해서 선택할 수 없다면, 반복문을 뒤에서부터 시작한다.
			for (int j = memo.length - 1; j >= problem.time; j--) {
				memo[j] = Math.max(memo[j], memo[j - problem.time] + problem.score);
			}
		}

		return memo[m];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			problems.add(new Problem(score, time));
		}

		System.out.println(solution());
	}
}
