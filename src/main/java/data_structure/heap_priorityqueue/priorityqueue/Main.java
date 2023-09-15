package data_structure.heap_priorityqueue.priorityqueue;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			priorityQueue.offer(random.nextInt(100));
		}

		System.out.println("priorityQueue.toString() = " + priorityQueue.toString());
		// priorityQueue.toString() = [ 5 29 15 40 53 92 92 74 53 59 ]
		System.out.println("priorityQueue.peek() = " + priorityQueue.peek());
		// priorityQueue.peek() = 5
		priorityQueue.offer(priorityQueue.peek() - 1);
		System.out.println("priorityQueue.offer(priorityQueue.peek() - 1)");
		// priorityQueue.offer(priorityQueue.peek() - 1)
		System.out.println("priorityQueue.toString() = " + priorityQueue.toString());
		// priorityQueue.toString() = [ 4 5 15 40 29 92 92 74 53 59 53 ]
		System.out.println("priorityQueue.poll() = " + priorityQueue.poll());
		// priorityQueue.poll() = 4
		System.out.println("priorityQueue.remove() = " + priorityQueue.remove());
		// priorityQueue.remove() = 5
		System.out.println("priorityQueue.toString() = " + priorityQueue.toString());
		// priorityQueue.toString() = [ 15 29 59 40 53 92 92 74 53 ]
	}
}
