package data_structure.tree.binray_search_tree;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

		binarySearchTree.insert(1);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(15);
		binarySearchTree.insert(16);
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);
		binarySearchTree.insert(2);
		binarySearchTree.insert(10);

		List<Integer> preOrder = binarySearchTree.preOrder();
		System.out.println(Arrays.toString(preOrder.toArray()));
		// [1, 3, 2, 15, 4, 6, 10, 16]

		List<Integer> inOrder = binarySearchTree.inOrder();
		System.out.println(Arrays.toString(inOrder.toArray()));
		// [1, 2, 3, 4, 6, 10, 15, 16]

		List<Integer> postOrder = binarySearchTree.postOrder();
		System.out.println(Arrays.toString(postOrder.toArray()));
		// [2, 10, 6, 4, 16, 15, 3, 1]

		binarySearchTree.removeNode(15);
		binarySearchTree.removeNode(2);

		List<Integer> preOrder2 = binarySearchTree.preOrder();
		System.out.println(Arrays.toString(preOrder2.toArray()));
		// [1, 3, 10, 4, 6, 16]

		List<Integer> inOrder2 = binarySearchTree.inOrder();
		System.out.println(Arrays.toString(inOrder2.toArray()));
		// [1, 3, 4, 6, 10, 16]

		List<Integer> postOrder3 = binarySearchTree.postOrder();
		System.out.println(Arrays.toString(postOrder3.toArray()));
		// [6, 4, 16, 10, 3, 1]
	}
}
