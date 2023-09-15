package data_structure.heap_priorityqueue.priorityqueue;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<T> implements Queue<T> {

	private final Comparator<? super T> comparator; // 임의의 기준에 따라 비교하기 위한 필드
	private static final int DEFAULT_CAPACITY = 10; // 기본 용적 크기
	private int size; // 노드 개수
	private T[] array; // 노드가 담기는 배열

	// 생성자: 초기 공간 할당 X
	public PriorityQueue() {
		this(null);
	}

	@SuppressWarnings("unchecked")
	public PriorityQueue(Comparator<? super T> comparator) {
		this.array = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.comparator = comparator;
	}

	// 생성자: 초기 공간 할당 X
	public PriorityQueue(int capacity) {
		this(capacity, null);
	}

	@SuppressWarnings("unchecked")
	public PriorityQueue(int capacity, Comparator<? super T> comparator) {
		this.array = (T[]) new Object[capacity];
		this.size = 0;
		this.comparator = comparator;
	}

	// 주어진 인덱스 노드의 부모 노드 인덱스 반환
	private int getParent(int index) {
		return index / 2;
	}

	// 주어진 인덱스 노드의 왼쪽 자식 노드 인덱스 반환
	private int getLeftChild(int index) {
		return index * 2;
	}

	// 주어진 인덱스 노드의 오른쪽 자식 노드 인덱스 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}

	// 용적 크기 동적 조정
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		// 새 배열
		T[] newArray = (T[]) new Object[newCapacity];

		// 기존 노드 복사
		for (int i = 1; i <= size; i++) {
			newArray[i] = array[i];
		}

		this.array = newArray;
	}

	// 노드 추가
	@Override
	public boolean offer(T element) {
		// 저장 공간이 꽉 찬 경우, 용적 크기를 조정한다.
		if (size + 1 == array.length) {
			resize(array.length * 2);
		}

		siftUp(size + 1, element); // 타겟이 추가될 위치와, 타겟을 넘겨준다.
		size++; // 추가 후 size 증가

		return true;
	}

	// 상향 선별
	private void siftUp(int index, T target) {
		// comparator가 존재할 경우 siftUpComparator
		// comparator가 존재하지 않을 경우 siftUpComparable
		if (comparator != null) {
			siftUpComparator(index, target, comparator);
		} else {
			siftUpComparable(index, target);
		}
	}

	// Comparator을 이용한 sift up
	private void siftUpComparator(int index, T target, Comparator<? super T> comparator) {

		// 루트 노드를 제외한 탐색
		while (index > 1) {
			int parent = getParent(index);
			T parentVal = array[parent];

			// 타겟 노드가 부모 노드보다 크면 반복문 종료
			if (comparator.compare(target, parentVal) >= 0) {
				break;
			}

			array[index] = parentVal;
			index = parent;
		}

		array[index] = target;
	}

	// comparable을 이용한 sift up
	@SuppressWarnings("unchecked")
	private void siftUpComparable(int index, T target) {
		// 타겟 노드가 비교될 수 있도록 Comparable 변수를 만든다.
		Comparable<? super T> comparable = (Comparable<? super T>) target;

		// 루트 노드를 제외한 탐색
		while (index > 1) {
			int parent = getParent(index);
			T parentVal = array[parent];

			// 타겟 노드가 부모 노드보다 크면 반복문 종료
			if (comparable.compareTo(parentVal) >= 0) {
				break;
			}

			array[index] = parentVal;
			index = parent;
		}

		array[index] = target;
	}

	@Override
	public T poll() {
		// 루트 노드가 null인 경우, null을 반환한다.
		if (array[1] == null) {
			return null;
		}

		return remove();
	}

	@Override
	public T remove() {
		if (array[1] == null) {
			throw new NoSuchElementException();
		}

		T result = array[1];

		T target;
		if (size == 1) {
			target = null;
		} else {
			target = array[size];
		}

		array[size] = null;
		size--;
		siftDown(1, target);

		return result;
	}

	// 하향 선별
	private void siftDown(int index, T target) {
		// comparator가 존재할 경우 siftDownComparator
		// comparator가 존재하지 않을 경우 siftDownComparable
		if (comparator != null) {
			siftDownComparator(index, target, comparator);
		} else {
			siftDownComparable(index, target);
		}
	}

	// Comparator을 이용한 sift-down
	private void siftDownComparator(int index, T target, Comparator<? super T> comparator) {
		array[index] = null; // 삭제 할 인덱스의 노드 삭제
		size--;

		int parent = index;
		int child;

		// 왼쪽 자식 노드의 인덱스가 노드의 개수보다 작을 때 까지 반복
		while ((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent); // 오른쪽 자식 인덱스

			T childVal = array[child]; // 왼쪽 자식의 값 (교환 될 값)

			// 오른쪽 자식 인덱스가 size를 넘지 않으면서
			// 왼쪽 자식이 오른쪽 자식보다 큰 경우
			// child와 childVal을 오른쪽 자식으로 바꿔준다.
			if (right <= size && comparator.compare(childVal, array[right]) > 0) {
				child = right;
				childVal = array[child];
			}

			// 재배치할 노드가 자식 노드보다 작은 경우 반복문을 종료한다.
			if (comparator.compare(target, childVal) <= 0) {
				break;
			}

			// 현재 부모 노드 인덱스에 자식 노드 값을 저장
			// 부모 인덱스를 자식 인덱스로 교체
			array[parent] = childVal;
			parent = child;
		}

		// 최종 재배치 위치에 타겟을 저장한다.
		array[parent] = target;

		// 현재 용적 크기가 기본 용적 크기보다 크면서, 노드 개수가 전체 용적의 1/4인 경우
		// 용적을 반으로 줄인다(최소 기본 용적크기보단 커야함).
		if(array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}

	// Comparable을 이용한 sift-down
	@SuppressWarnings("unchecked")
	private void siftDownComparable(int index, T target) {
		Comparable<? super T> targetComparable = (Comparable<? super T>) target;

		array[index] = null;

		int parent = index;
		int child;

		while ((child = getLeftChild(parent)) <= size) {
			int right = getRightChild(parent);

			T childVal = array[child];
			Comparable<? super T> childComparable = (Comparable<? super T>) array[child];

			if (right <= size && childComparable.compareTo(array[right]) > 0) {
				child = right;
				childVal = array[child];
			}

			if (targetComparable.compareTo(childVal) <= 0) {
				break;
			}

			array[parent] = childVal;
			parent = child;
		}

		array[parent] = target;

		if (array.length > DEFAULT_CAPACITY && size < array.length / 4) {
			resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
		}
	}

	@Override
	public T peek() {
		if (array[1] == null) {
			throw new NoSuchElementException();
		}

		return array[1];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object value) {
		for(int i = 1; i <= size; i++) {
			if(array[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	public void clear() {
		for(int i = 1; i < array.length; i++) {
			array[i] = null;
		}

		size = 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (int i = 1; i < size + 1; i++) {
			sb.append(" ").append(array[i]);
		}

		sb.append(" ]");

		return sb.toString();
	}
}
