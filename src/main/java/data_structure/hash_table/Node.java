package data_structure.hash_table;

public class Node {

	private String Key;
	private String value;
	private Node next;

	public Node(String key, String value, Node next) {
		Key = key;
		this.value = value;
		this.next = next;
	}

	public String getKey() {
		return Key;
	}

	public String getValue() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
