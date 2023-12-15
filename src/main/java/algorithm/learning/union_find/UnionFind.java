package algorithm.learning.union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 서로소 집합(Disjoint Set)은 상호 배타적으로 구성된 집합들을 말한다.
 * 즉 공통 원소가 없는 집합들을 말한다.
 * 한 그래프에서의 서로소 집합은 서로 연결되지 않은 부분 그래프들이라고 볼 수 있다.
 *
 * 서로소 집합은 서로 다른 두 집합을 병합하는 연산(Union or Merge)과 원소가 어떤 집합에 속해 있는지 판단하는 연산(Find)을 기반으로 구현된다.
 * 따라서 서로소 집합을 구현하는 알고리즘을 Union-Find 또는 Merge-Find라고 부른다.
 *
 * 용어 설명
 *   1) 부모: 각 원소가 가르키는 원소
 *
 *   2) 대표: 각 집합을 대표하는 원소
 *
 * 서로소 집합은 트리를 통해 구현할 수 있으며, 기본적으로 3가지 연산으로 구현된다.
 *   1) MakeSet 연산은 대상 원소들을 우선 모두 각각 독립된 집합으로 분리하는 과정이다.
 *      각 원소는 자신이 가르키는 원소가 속한 집합에 속한다.
 *      따라서 MakeSet 연산에서는 각 원소가 자기 자신을 가르키도록 설정하는 것이다.
 *
 *   2) Union 연산은 서로소 집합을 하나의 집합으로 병합하는 과정이다.
 *      서로 다른 집합에 속한 두 원소를 같은 집합에 속하도록 병합하는 방법은 두 원소가 모두 같은 부모를 가르키도록 설정해주는 것이다.
 *      일반적으로 두 원소 중 값이 작은 원소를 기준으로 부모를 통일시켜준다.
 *      이 때 주의할 점은 부모를 변경해야하는 것은 대상 원소 자체가 아니라, 대상 원소의 대표의 부모를 변경해야한다.
 *
 *   3) Find 연산은 특정 원소가 어떤 집합에 포함되어 있는지 확인하는 과정이다.
 *      특정 원소가 어떤 집합에 포함되어있는 지 확인 하기 위해서는 해당 원소가 속한 집합의 대표를 찾아야한다.
 *      대표는 자신의 번호와 부모의 번호가 동일한 원소를 말하며, 이것은 재귀적으로 찾을 수 있다.
 *
 * Union-Find 알고리즘은 Find 연산에서 그 성능을 개선할 수 있다.
 *   1) 현재 Find 연산은 재귀적으로 매번 집합의 대표까지 탐색해야하는 비효율적인 연산을 하고 있다.
 *   2) 따라서 재귀를 반환하는 과정에서 집합의 각 원소의 부모를 대표로 바꿔주면서 반환하면 최종적으로 집합의 모든 원소의 부모가 대표가 되게끔 통일시켜줄 수 있다.
 */
public class UnionFind {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine()); // 5

		// MakeSet 연산
		// parents는 각 원소(index)의 부모(value)를 담는 배열
		int[] parents = makeSet(size);

		// 초기에 각 원소는 자기 자신을 가르키고 있다.
		// [0, 1, 2, 3, 4, 5]
		System.out.println(Arrays.toString(parents));

		// 1번 원소의 집합과 2번 원소의 집합을 병합
		// [0, 1, 1, 3, 4, 5]
		union(parents, 1, 2);
		System.out.println(Arrays.toString(parents));

		// 2번 원소의 집합과 3번 원소의 집합을 병합
		// [0, 1, 1, 1, 4, 5]
		union(parents, 2, 3);
		System.out.println(Arrays.toString(parents));

		// 4번 원소의 집합과 5번 원소의 집합을 병합
		// [0, 1, 1, 1, 4, 4]
		union(parents, 4, 5);
		System.out.println(Arrays.toString(parents));

		// 3번 원소의 집합과 5번 원소의 집합을 병합
		// [0, 1, 1, 1, 1, 4]
		union(parents, 3, 5);
		System.out.println(Arrays.toString(parents));

		// 최종적으로 각 원소들이 속한 집합.
		// 주의 사항은 parents의 값은 각 원소의 부모를 뜻하는 것이지 각 원소가 속한 집합(대표)를 뜻하지 않는다는 것이다.
		// 각 원소의 집합(대표)는 find()로 찾아야한다.
		// 1 1 1 1 1
		System.out.print(find(parents, 1) + " ");
		System.out.print(find(parents, 2) + " ");
		System.out.print(find(parents, 3) + " ");
		System.out.print(find(parents, 4) + " ");
		System.out.print(find(parents, 5) + " ");
	}

	private static int[] makeSet(int size) {
		// 1번 원소가 1번 인덱스에 대응할 수 있도록 배열 크기를 선언
		int[] parents = new int[size + 1];

		// 각 원소는 자기 자신을 가르킨다.
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}

		return parents;
	}

	private static int find(int[] parents, int x) {
		if (parents[x] == x) { // x가 자기 자신을 가르킨다 = x는 집합의 대표
			return x;
		} else { // x가 속한 집합의 대표를 재귀적으로 찾는다.
			return parents[x] = find(parents, parents[x]);
		}
	}

	private static void union(int[] parents, int a, int b) {
		int aRep = find(parents, a); // a가 속한 집합의 대표
		int bRep = find(parents, b); // b가 속한 집합의 대표

		// 값이 작은 대표를 기준으로 집합을 병합
		if (aRep > bRep) {
			parents[aRep] = bRep;
		} else {
			parents[bRep] = aRep;
		}
	}
}
