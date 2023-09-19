package algorithm.learning.bfs;

public class Main {

	public static void main(String[] args) {
		///////////////////// 인접 리스트의 BFS /////////////////////
		AdjList_bfs<Integer> adjList_bfs = new AdjList_bfs<>();

		for (int i = 1; i <= 5; i++) {
			adjList_bfs.addVertex(i);
		}

		adjList_bfs.addEdge(1, 2);
		adjList_bfs.addEdge(1, 4);
		adjList_bfs.addEdge(2, 3);
		adjList_bfs.addEdge(2, 4);
		adjList_bfs.addEdge(2, 5);
		adjList_bfs.addEdge(3, 2);
		adjList_bfs.addEdge(4, 5);
		adjList_bfs.addEdge(4, 1);
		adjList_bfs.addEdge(5, 1);

		for (int i = 1; i <= 5; i++) {
			adjList_bfs.bfs(i);
			System.out.println();
		}
		/*1 2 4 3 5
		  2 3 4 5 1
		  3 2 4 5 1
		  4 5 1 2 3
		  5 1 2 4 3 */

		System.out.println("/////////////////////////////////////");

		///////////////////// 인접 행렬의 BFS /////////////////////
		AdjMatrix_bfs adjMatrix_bfs = new AdjMatrix_bfs(5);

		adjMatrix_bfs.insertSingleDir(1, 2);
		adjMatrix_bfs.insertSingleDir(1, 4);
		adjMatrix_bfs.insertSingleDir(2, 3);
		adjMatrix_bfs.insertSingleDir(2, 4);
		adjMatrix_bfs.insertSingleDir(2, 5);
		adjMatrix_bfs.insertSingleDir(3, 2);
		adjMatrix_bfs.insertSingleDir(4, 5);
		adjMatrix_bfs.insertSingleDir(4, 1);
		adjMatrix_bfs.insertSingleDir(5, 1);

		for (int i = 1; i <= 5; i++) {
			adjMatrix_bfs.bfs(i);
			System.out.println();
		}
		/*1 2 4 3 5
		  2 3 4 5 1
		  3 2 4 5 1
		  4 5 1 2 3
		  5 1 2 4 3 */
	}
}
