package algorithm.practice.inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsBfs_3 {

	public static class Save {
		int sumScore = 0;
		int sumTime = 0;
		int answer = 0;
	}

	public static int solution(int cur, int n, int m, int[] scores, int[] times, Save save) {
		if (save.sumTime > m) {
			return 0;
		} else if (cur == n + 1) {
			save.answer = Math.max(save.answer, save.sumScore);
			return 0;
		}

		save.sumScore += scores[cur];
		save.sumTime += times[cur];
		solution(cur + 1, n, m, scores, times, save);
		save.sumScore -= scores[cur];
		save.sumTime -= times[cur];
		solution(cur + 1, n, m, scores, times, save);

		return save.answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] scores = new int[n + 1];
		int[] times = new int[n + 1];
		Save save = new Save();

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			scores[i] = score;
			times[i] = time;
		}

		System.out.println(solution(1, n, m, scores, times, save));
	}
}
