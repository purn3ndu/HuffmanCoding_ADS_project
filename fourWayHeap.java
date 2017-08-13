import java.util.*;

public class fourWayHeap{
    /** The number of children each node has **/
    private static final int d = 4;
    private int heapSize;
    private Node[] heap;
    static int FRONT =3;
 
    /** Constructor **/    
    public fourWayHeap(int capacity)
    {
        heapSize = FRONT;
        heap = new Node[capacity + 3];
        //Arrays.fill(heap, -1);
    }
 
    public int getHeapSize() {
		return heapSize-FRONT;
	}


	/** Function to check if heap is empty **/
    public boolean isEmpty( )
    {
        return heapSize-FRONT == 0;
    }
 
    /** Check if heap is full **/
    public boolean isFull( )
    {
        return heapSize== heap.length;
    }
 
    /** Clear heap */
    public void makeEmpty( )
    {
        heapSize = FRONT;
    }
 
    /** Function to  get index parent of i **/
    private int parent(int i) 
    {
        return (i - 1 -FRONT)/d +FRONT;
    }
 
    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) 
    {
        return d * (i-FRONT) + k+FRONT;
    }
 
    /** Function to insert element */
    public void insert(Node x)
    {
        if (isFull( ) )
            throw new NoSuchElementException("Overflow Exception");
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }
 
    /** Function to find least element **/
    public Node findMin( )
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");           
        return heap[FRONT];
    }
 
    /** Function to delete min element **/
    public Node deleteM()
    {
        Node keyItem = heap[FRONT];
        delete(FRONT);
        return keyItem;
    }
 
    /** Function to delete element at an index **/
    public Node delete(int ind)
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }
 
    /** Function heapifyUp  **/
    private void heapifyUp(int childInd)
    {
        Node tmp = heap[childInd];    
        while (childInd > FRONT && tmp.getValue() < heap[parent(childInd)].getValue())
        {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }
 
    /** Function heapifyDown **/
    private void heapifyDown(int ind)
    {
        int child;
        Node tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize)
        {
            child = minChild(ind);
            if (heap[child].getValue() < tmp.getValue())
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }
 
    /** Function to get smallest child **/
    private int minChild(int ind) 
    {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) 
        {
            if (heap[pos].getValue() < heap[bestChild].getValue()) 
                bestChild = pos;
            pos = kthChild(ind, ++k);
        }    
        return bestChild;
    }
 
    /** Function to print heap **/
    public void printHeap()
    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }  

}