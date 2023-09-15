package data_structure.heap_priorityqueue.heap;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<>();

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			heap.add(random.nextInt(100));
		}

		System.out.println("heap.toString() = " + heap.toString());
		// heap.toString() = [ 6 11 75 29 45 83 82 55 50 46 ]
		System.out.println("heap.peek() = " + heap.peek());
		// heap.peek() = 6
		heap.add(heap.peek() - 1);
		System.out.println("heap.add(heap.peek() - 1)");
		// heap.add(heap.peek() - 1)
		System.out.println("heap.toString() = " + heap.toString());
		// heap.toString() = [ 5 6 75 29 11 83 82 55 50 46 45 ]
		System.out.println("heap.remove() = " + heap.remove());
		// heap.remove() = 5
		System.out.println("heap.toString() = " + heap.toString());
		// heap.toString() = [ 6 11 75 29 45 83 82 55 50 46 ]
	}
}
