package data_structure.hash_table;

public class Main {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();

		hashTable.put("Kim", "preKim");
		hashTable.put("Lee", "preLee");
		hashTable.put("Kwon", "preKwon");
		hashTable.put("Choi", "preChoi");
		hashTable.put("Park", "prePark");
		hashTable.put("Ji", "preJi");
		hashTable.put("Jung", "preJung");
		hashTable.put("Jo", "preJo");
		hashTable.printHashTable();
		System.out.println();
		/*
		==Hash Table==
		0: List is empty!
		1: List is empty!
		2: List is empty!
		3: List is empty!
		4: preJung
		5: preKwon preJo
		6: List is empty!
		7: preChoi
		8: preLee prePark
		9: preKim preJi
		*/

		hashTable.remove("Kim");
		hashTable.remove("Jung");
		hashTable.put("Lee", "PostLee");
		hashTable.printHashTable();
		System.out.println();
		/*
		==Hash Table==
		0: List is empty!
		1: List is empty!
		2: List is empty!
		3: List is empty!
		4: List is empty!
		5: preKwon preJo
		6: List is empty!
		7: preChoi
		8: PostLee prePark
		9: preJi
		*/

		hashTable.remove("Kim");
		// Not Exist Data
	}
}
