import java.util.Vector;

public class pairingHeap<Key extends Comparable<Key>> {

	public Key rootNode;
	public Vector<pairingHeap<Key>> childrenList;
	public int size = 0;
	
	public pairingHeap() {
		rootNode = null;
		childrenList = new Vector<>();
	}

	public void insert(Key key) {
		size++;
		if(rootNode == null)
			rootNode = key;
		else {
			pairingHeap<Key> newNode = new pairingHeap<Key>();
			newNode.rootNode = key;
			if(newNode.rootNode.compareTo(rootNode) > 0) {
				childrenList.add(newNode);
			} else {
				newNode.rootNode = rootNode;
				newNode.childrenList = childrenList;
				rootNode = key;
				childrenList = new Vector<>();
				childrenList.add(newNode);
			}
		}
	}

	private pairingHeap<Key> meld(pairingHeap<Key> key1, pairingHeap<Key> key2) {	
		if ((key1.rootNode).compareTo(key2.rootNode) < 0) {
			key1.childrenList.add(key2);
			return key1;
		} else {
			key2.childrenList.add(key1);
			return key2;
		}

	}
	
	public Key deleteM() {
		size--;
		Key minNode = rootNode;
		if(childrenList.isEmpty()) {
			rootNode = null;
			return minNode;
		}
		//Pass 1
		Vector<pairingHeap<Key>> rawList = childrenList;
		Vector<pairingHeap<Key>> passList = new Vector<>();
		pairingHeap<Key> temp = new pairingHeap<>();
		if (rawList.size() > 1) {
			for (int i = 0; i < rawList.size() / 2; i++) {
				temp = meld(rawList.get(i * 2), rawList.get(i * 2 + 1));
				passList.add(temp);
			}
			if (rawList.size() % 2 == 1) {
				temp = rawList.get(rawList.size() - 1);
				passList.set(passList.size() - 1, meld(temp, passList.get(passList.size() - 1)));
		    }
		} else {
			passList.add(rawList.get(0));
		}
		//Pass 2
		if (passList.size() > 1) {
			int j = passList.size() - 1;
			int k = j;
			for (int i = 0; i < j; i++) {
				temp = meld(passList.get(k), passList.get(k-1));
				passList.remove(k);
				passList.set(k - 1, temp);
				k--;
			}
		}
		//return minNode
		rootNode = passList.get(0).rootNode;
		childrenList = passList.get(0).childrenList;
		return minNode;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		pairingHeap<Integer> p = new pairingHeap<>();
		p.insert(8);
		p.insert(3);
		p.insert(5);
		p.insert(6);
		p.insert(1);
		//p.deleteM();
		//p.deleteM();
		//p.deleteM();
		//p.deleteM();
		System.out.println(p.rootNode);
		System.out.println(p.childrenList);
	}

}