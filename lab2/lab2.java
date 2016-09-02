// Inderpreet Singh

interface Iterator {
  int get();
  Iterator advance();
  boolean equals(Iterator other);
}

interface Sequence {
  Iterator begin();
  Iterator end();
}

interface BidirectionalIterator extends Iterator {
  BidirectionalIterator retreat();
}

class DNode {
	DNode(int d, DNode n, DNode p) { data = d; next = n; prev = p; }
	int data;
	DNode next;
	DNode prev;
}

class DList implements Sequence {
	DNode sentinel;
	DList() {
		sentinel = new DNode(444, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	  }

	  // insert before pos, return iterator pointing to new node
	  public Iter insert(Iter pos, int e) {
		 //sentinel.next = ;
		 //sentinel.previous = ;
		 DNode newN = new DNode (e, pos.curr.next , pos.curr.prev);
		 sentinel.next = newN;
		 pos.curr.prev = newN;
		 pos.curr.prev.next = newN;
		 if(newN.next == null){
			 sentinel.next = newN;
		 }
		 if(newN.prev == null){
			 sentinel.prev = newN;
		 }
		 return new Iter(newN);
	  }

	  // erase the node at pos, return iterator to the next element
	  public Iter erase(Iter pos) {
		  pos.curr.prev.next = pos.curr.next;
		  DNode temp = pos.curr.next;
		  pos.curr.next.prev = pos.curr.prev;
		  pos.curr.next = null;
		  pos.curr.prev = null;
		  return new Iter(temp);
	  }

	  public boolean empty() {
		  return sentinel.next == null && sentinel.prev == null;
	  }
	  
	  public class Iter implements Iterator, BidirectionalIterator {
		  DNode curr;
		  Iter(DNode n) { curr = n; }
		  public int get() { return curr.data; }
		  public Iterator advance() {
			  curr = curr.next;
			  return this;
		  }
		  public BidirectionalIterator retreat() {
			  curr = curr.prev;
			  return this;
		  }
		  public boolean equals(Iterator other) {
			  return curr == ((Iter)other).curr; 
		  }
	  }
	  public Iter begin() { return new Iter(sentinel.next); }
	  public Iter end() { return new Iter(sentinel); }
}

public class lab2 {
	public static void main(String[] args){
		DList L = new DList();
		for (int i = 0; i != 10; ++i) {
		   L.insert(L.end(), i);
		}
	}
}
