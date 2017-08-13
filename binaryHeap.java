import java.util.*;

public class binaryHeap<Key extends Comparable<Key>> {
	private Vector<Key> bHeap;
	private int size = 0;

	public binaryHeap() {
		bHeap = new Vector<>();
		bHeap.add(0, null);
	}

	public int size() {
		return size;
	}

	public void insert(Key key) {
		size = size + 1;
		bHeap.add(size, key);
		bottomUp();
	}

	public Key deleteM() {
		Key max = bHeap.get(1);
		exchange(1, size);
		size = size - 1;
		topDown();
		//bHeap.remove(size + 1);
		return max;
	}

	private void bottomUp() {
		int pointer = size;
		while (pointer > 1 && less(pointer, pointer/2)) {
			exchange(pointer, pointer/2);
			pointer = pointer/2;
		}
	}

	private void topDown() {
		int pointer = 1;
		while (2 * pointer <= size) {
			int childrenMin = 2 * pointer;
			if (!less(childrenMin, childrenMin + 1) && childrenMin < size) {
				childrenMin++;
			}

			if (!less(pointer, childrenMin)) {
				exchange(pointer, childrenMin);
			} else {
				break;
			}
			pointer = childrenMin;

		}
	}

	private boolean less(int i, int j) {
		return (bHeap.get(i)).compareTo(bHeap.get(j)) < 0;
	}

	private void exchange(int i, int j) {
		Key temp = bHeap.get(i);
		bHeap.set(i, bHeap.get(j));
		bHeap.set(j, temp);
	}
}