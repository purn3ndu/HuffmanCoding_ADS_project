import java.util.*;
public class buildtree {
	
	
	public fourWayHeap fH;
	// pairingHeap<Node> pH = new pairingHeap<>();

	public void buildtreeb(HashMap<Integer,Integer> freqTable) {
		int freqTableSize = freqTable.size();
		binaryHeap2 bH = new binaryHeap2(freqTableSize);
		// pass the HashMap freqTable instead ^
		// for (int i = 0; i < 1000000; i++) {
		// 	//iterate through the whole hashmap and insert each key value pair into the heap
		// 	if (freqTable.get(i) != 0) {
		// 		Node temp = new Node(i ,freqTable.get(i));
		// 		bH.insert(temp);
		// 	}
		
		// }

		//Traversing Hashmap  
	    for(Map.Entry<Integer, Integer> entry:freqTable.entrySet()){    
	        Integer key=entry.getKey();  
	        int value=entry.getValue();  
	        Node temp = new Node(key ,value);
	 		bH.insert(temp);
	        // System.out.println(key+" Details:");  
	        // System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
	    }


		while (bH.getHeapSize() > 1) {
			Node node1 = bH.deleteM();
			Node node2 = bH.deleteM();
			Node node3 = Node.meld(node1, node2);
			bH.insert(node3);
		}
	}
	
	public void buildtreef(HashMap<Integer,Integer> freqTable) {
		int freqTableSize = freqTable.size();
		fH = new fourWayHeap(freqTableSize);
		// pass the HashMap freqTable instead ^
		// for (int i = 0; i < 1000000; i++) {
		// 	//iterate through the whole hashmap and insert each key value pair into the heap
		// 	if (freqTable.get(i) != 0) {
		// 		Node temp = new Node(i ,freqTable.get(i));
		// 		bH.insert(temp);
		// 	}
		
		// }

		//Traversing Hashmap  
	    for(Map.Entry<Integer, Integer> entry:freqTable.entrySet()){    
	        Integer key=entry.getKey();  
	        int value=entry.getValue();  
	        Node temp = new Node(key ,value);
	 		fH.insert(temp);
	        // System.out.println(key+" Details:");  
	        // System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
	    }


		while (fH.getHeapSize() > 1) {
			Node node1 = fH.deleteM();
			Node node2 = fH.deleteM();
			Node node3 = Node.meld(node1, node2);
			fH.insert(node3);
		}
	}

//	 public void buildtreef(Vector<Integer> freqTable) {
//	 	for (int i = 0; i < 1000000; i++) {
//	 		if (freqTable.get(i) != 0) {
//	 			Node temp = new Node(i ,freqTable.get(i));
//	 			fH.insert(temp);
//	 		}
//		
//	 	}
//	 	while (fH.size() > 1) {
//	 		Node node1 = fH.deleteM();
//	 		Node node2 = fH.deleteM();
//	 		Node node3 = Node.meld(node1, node2);
//	 		fH.insert(node3);
//	 	}
//	 }

	// public void buildtreep(Vector<Integer> freqTable) {
	// 	for (int i = 0; i < 1000000; i++) {
	// 		if (freqTable.get(i) != 0) {
	// 			Node temp = new Node(i ,freqTable.get(i));
	// 			pH.insert(temp);
	// 		}
	// 	}
	// 	while (pH.size() > 1) {
	// 		Node node1 = pH.deleteM();
	// 		Node node2 = pH.deleteM();
	// 		Node node3 = Node.meld(node1, node2);
	// 		pH.insert(node3);
	// 	}
	// }

}