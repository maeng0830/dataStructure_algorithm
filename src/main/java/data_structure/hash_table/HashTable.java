package data_structure.hash_table;

public class HashTable {

	private LinkedList[] bucket; // 저장소

	private static final int DEFAULT_SIZE = 10; // 기본 저장소 크기

	public HashTable(int size) {
		bucket = new LinkedList[size];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new LinkedList();
		}
	}

	public HashTable() {
		bucket = new LinkedList[DEFAULT_SIZE];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new LinkedList();
		}
	}

	/**
	 * key -> HashCode
	 */
	private int hashFunction(String key) {
		int hashCode = 0;

		for (char c : key.toCharArray()) {
			hashCode += c;
		}

		return hashCode;
	}

	/**
	 * HashCode -> Index
	 */
	private int convertToIndex(int hashCode) {
		return hashCode % bucket.length;
	}

	/**
	 * Data(Key:Value) add
	 */
	public void put(String key, String value) {
		int index = convertToIndex(hashFunction(key));

		LinkedList linkedList = bucket[index];

		linkedList.addNode(key, value);
	}

	/**
	 * Data(Key:Value) remove
	 */
	public void remove(String key) {
		int index = convertToIndex(hashFunction(key));

		LinkedList linkedList = bucket[index];

		linkedList.removeNode(key);
	}

	/**
	 * get Value
	 */
	public String get(String key) {
		int index = convertToIndex(hashFunction(key));

		LinkedList linkedList = bucket[index];

		return linkedList.getNode(key).getValue();
	}

	public void printHashTable() {
		System.out.println("==Hash Table==");
		for (int i = 0; i < this.bucket.length; i++) {
			System.out.print(i + ": ");
			this.bucket[i].showData();
		}
	}
}
