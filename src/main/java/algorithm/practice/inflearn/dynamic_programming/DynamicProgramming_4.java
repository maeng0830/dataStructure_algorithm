package algorithm.practice.inflearn.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
 * 아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
 * (조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
 * (조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
 * (조건3) 벽돌들의 높이는 같을 수도 있다.
 * (조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
 * (조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.
 *
 * 입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
 * 둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
 * 각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 *
 * 첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.
 * 10
 */
public class DynamicProgramming_4 {

	static int n;
	static ArrayList<Brick> bricks;
	static int[] memo;
	static int answer;

	static class Brick implements Comparable<Brick> {
		int s;
		int h;
		int w;

		public Brick(int s, int h, int w) {
			this.s = s;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(Brick o) {
			return o.s - this.s;
		}
	}

	public static int solution() {
		memo[0] = bricks.get(0).h;

		for (int i = 0; i < n; i++) {
			Brick brick = bricks.get(i);
			int acc = 0;

			for (int j = i - 1; j >= 0; j--) {
				Brick target = bricks.get(j);

				if (brick.w < target.w && memo[j] > acc) {
					acc = memo[j];
				}
			}

			memo[i] = acc + brick.h;

			answer = Math.max(answer, memo[i]);
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		bricks = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			bricks.add(new Brick(s, h, w));
		}

		Collections.sort(bricks);

		memo = new int[n];

		System.out.println(solution());

		System.out.println(Arrays.toString(memo));
	}
}
