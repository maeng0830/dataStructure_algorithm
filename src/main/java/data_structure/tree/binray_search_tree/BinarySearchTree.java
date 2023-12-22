package data_structure.tree.binray_search_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {

	private Node<E> root; // 루트 노드
	private int size; // 노드의 개수

	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
	}

	// 최소 데이터 탐색
	public E min() {
		return minNode(root);
	}

	private E minNode(Node<E> node) {
		E minData = node.value;

		// 루트 노드부터 -> 왼쪽 노드로 순회하면서, 가장 왼쪽 노드를 찾는다.
		while (node.left != null) {
			minData = node.value;
			node = node.left;
		}

		return minData;
	}

	// 최대 데이터 탐색
	public E max() {
		return maxNode(root);
	}

	private E maxNode(Node<E> node) {
		E maxData = node.value;

		// 루트 노드부터 -> 오른쪽 노드로 순회하면서, 가장 오른쪽 노드를 찾는다.
		while (node.right != null) {
			maxData = node.value;
			node = node.right;
		}

		return maxData;
	}

	// 전위 탐색
	public List<E> preOrder() {
		return preOrderTree(root, new ArrayList<>());
	}

	private List<E> preOrderTree(Node<E> node, ArrayList<E> visited) {
		if (node == null) {
			return visited;
		}

		visited.add(node.value);
		preOrderTree(node.left, visited);
		preOrderTree(node.right, visited);

		return visited;
	}

	// 중위 탐색
	public List<E> inOrder() {
		return inOrderTree(root, new ArrayList<>());
	}

	private List<E> inOrderTree(Node<E> node, ArrayList<E> visited) {
		if (node == null) {
			return visited;
		}

		inOrderTree(node.left, visited);
		visited.add(node.value);
		inOrderTree(node.right, visited);

		return visited;
	}

	// 후위 탐색
	public List<E> postOrder() {
		return postOrderTree(root, new ArrayList<>());
	}

	private List<E> postOrderTree(Node<E> node, List<E> visited) {
		if (node == null) {
			return visited;
		}

		postOrderTree(node.left, visited);
		postOrderTree(node.right, visited);
		visited.add(node.value);

		return visited;
	}

	// 데이터 존재 여부 확인
	public boolean contains(E value) {
		return containsNode(root, value);
	}

	private boolean containsNode(Node<E> node, E value) {
		if (node == null) {
			return false;
		}

		/*
		 * a.compareTo(b)
		 * a < b : -1
		 * a == b : 0
		 * a > b : 1
		 */

		if (value.compareTo(node.value) == 0) {
			return true;
		} else if (value.compareTo(node.value) < 0) {
			return containsNode(node.left, value);
		} else {
			return containsNode(node.right, value);
		}
	}

	// 노드 삽입
	public void insert(E value) {
		if (root == null) {
			root = new Node<>(value);
		} else {
			Node<E> cur = root;

			while (true) {
				Node<E> pre = cur;

			if (value.compareTo(pre.value) == 0) {
				System.out.println("중복된 데이터를 삽입할 수 없습니다.");
				break;
			} else if (value.compareTo(pre.value) < 0) {
					cur = cur.left;

					if (cur == null) {
						pre.left = new Node<>(value);
						break;
					}
				} else {
					cur = cur.right;

					if (cur == null) {
						pre.right = new Node<>(value);
						break;
					}
				}
			}
		}

		size++;
	}

	public void removeNode(E value) {
		Node<E> parent = null;
		Node<E> successor = null; // 왼쪽 서브트리의 가장 큰 노드 OR 오른쪽 서브트리의 가장 작은 노드
		Node<E> predecessor = null; // successor의 부모
		Node<E> child = null; // successor의 자식 여부

		Node<E> cur = root;

		// 삭제 대상 찾기
		while (cur != null) {
			if (value == cur.value) {
				break;
			}

			parent = cur;
			if (value.compareTo(cur.value) < 0) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}

		// 삭제 대상이 없는 경우
		if (cur == null) {
			System.out.println("해당하는 데이터가 없습니다.");
			return;
		}

		// 삭제 대상이 단말 노드인 경우
		if (cur.left == null && cur.right == null) {
			if (parent == null) {
				root = null;
			} else {
				if (parent.left == cur) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}

			return;
		}

		// 삭제 대상의 자식이 1개인 경우
		if ((cur.left != null && cur.right == null) || (cur.left == null && cur.right != null)) {
			if (cur.left != null) {
				child = cur.left;
			} else {
				child = cur.right;
			}

			if (parent == null) {
				root = child;
			} else {
				if (parent.left == cur) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			}

			return;
		}

		// 삭제 대상의 자식이 2개인 경우
		predecessor = cur;
		successor = cur.left;

		while (successor.right != null) {
			predecessor = successor;
			successor = successor.right;
		}

		predecessor.right = successor.left;
		successor.left = cur.left;
		successor.right = cur.right;

		if (parent == null) {
			root = successor;
		} else {
			if (parent.left == cur) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
		}
	}
}
