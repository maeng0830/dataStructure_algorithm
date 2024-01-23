package data_structure.hash_table;

public class LinkedList {

	private Node head;

	public boolean isEmpty() {
		return this.head == null;
	}

	public void addNode(String key, String value) {
		if (isEmpty()) {
			this.head = new Node(key, value, null);
		} else {
			Node cur = this.head;

			while (cur.getNext() != null) {
				if (cur.getKey().equals(key)) {
					cur.setValue(value);
					return;
				}

				cur = cur.getNext();
			}

			cur.setNext(new Node(key, value, null));
		}
	}

	public void removeNode(String key) {
		if (isEmpty()) {
			System.out.println("Not Exist Data");
			return;
		}

		Node cur = this.head;
		Node pre = cur;

		while (cur != null) {
			if (cur.getKey().equals(key)) {
				if (cur == this.head) {
					this.head = cur.getNext();
				} else {
					pre.setNext(cur.getNext());
				}

				return;
			}

			pre = cur;
			cur = cur.getNext();
		}

		System.out.println("Not Exist Data");
	}

	public Node getNode(String key) {
		if (isEmpty()) {
			System.out.println("Not Exist Data");
			return null;
		}

		Node cur = this.head;

		while (cur != null) {
			if (cur.getKey().equals(key)) {
				return cur;
			}

			cur = cur.getNext();
		}

		System.out.println("Not Exist Data");
		return null;
	}

	public void showData() {
		if (this.isEmpty()) {
			System.out.println("List is empty!");
			return;
		}

		Node cur = this.head;
		while (cur != null) {
			System.out.print(cur.getValue() + " ");
			cur = cur.getNext();
		}
		System.out.println();
	}
}
