package algorithm.learning.dfs;

public class Main {

	public static void main(String[] args) {
		///////////////////// 인접 리스트의 DFS /////////////////////
		AdjList_dfs<Integer> adjList_dfs = new AdjList_dfs<>();

		for (int i = 1; i <= 5; i++) {
			adjList_dfs.addVertex(i);
		}

		adjList_dfs.addEdge(1, 2);
		adjList_dfs.addEdge(1, 4);
		adjList_dfs.addEdge(2, 3);
		adjList_dfs.addEdge(2, 4);
		adjList_dfs.addEdge(2, 5);
		adjList_dfs.addEdge(3, 2);
		adjList_dfs.addEdge(4, 5);
		adjList_dfs.addEdge(4, 1);
		adjList_dfs.addEdge(5, 1);

		for (int i = 1; i <= 5; i++) {
			adjList_dfs.dfs(i);
			System.out.println();
		}

		/*1 2 3 4 5
		  2 3 4 5 1
		  3 2 4 5 1
		  4 5 1 2 3
		  5 1 2 3 4*/

		System.out.println("/////////////////////////////////////");

		///////////////////// 인접 행렬의 DFS /////////////////////
		AdjMatrix_dfs adjMatrix_dfs = new AdjMatrix_dfs(5);

		adjMatrix_dfs.insertSingleDir(1, 2);
		adjMatrix_dfs.insertSingleDir(1, 4);
		adjMatrix_dfs.insertSingleDir(2, 3);
		adjMatrix_dfs.insertSingleDir(2, 4);
		adjMatrix_dfs.insertSingleDir(2, 5);
		adjMatrix_dfs.insertSingleDir(3, 2);
		adjMatrix_dfs.insertSingleDir(4, 5);
		adjMatrix_dfs.insertSingleDir(4, 1);
		adjMatrix_dfs.insertSingleDir(5, 1);

		for (int i = 1; i <= 5; i++) {
			adjMatrix_dfs.dfs(i);
			System.out.println();
		}
		/*1 2 3 4 5
		  2 3 4 5 1
		  3 2 4 5 1
		  4 5 1 2 3
		  5 1 2 3 4*/
	}
}
