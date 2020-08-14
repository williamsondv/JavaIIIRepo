package linkedlist;


public class LinkedList<E>  {

	Node<E> head;
	
	public boolean isEmpty() {
		if(this.head == null) {
		return true;
		} else {
			return false;
		}
	}

	
	public int size() {
		Node<E> currentNode = new Node<E>();
		currentNode = this.head;
		int listSize = 0;
		while (currentNode != null) {
			listSize++;
			currentNode = currentNode.next;
			
		}
		return listSize;
	}

	
	public void addFirst(E data) {
		Node<E> workingNode = new Node<E>(data, null);
		if (this.head == null) {
			this.head = workingNode;
		}
	}

	
	public void addLast(E data) {
		Node<E> workingNode = new Node<E>();
		Node<E> currentNode = new Node<E>(data, null);
		if (this.head != null) {
			workingNode = this.head;
			while(workingNode.next != null) {
				workingNode = workingNode.next;
			}
			workingNode.next = currentNode;
		}
	}

	
	public void add( E data, int index) throws IndexOutOfBoundsException {
		Node<E> workingNode = new Node<E>(data, null);
		
		
		
	        Node<E> headNode = this.head;
	        for(int i = 0; i< index -1; i++){
	            headNode = headNode.next;
	        }
	        workingNode.setNext(headNode.next);
	        headNode.setNext(workingNode);
		
	}

	
	public E remove(int index) throws IndexOutOfBoundsException {
		
		Node<E> nextNode = new Node<E>(null, null);
		Node<E> tempNode = new Node<E>(null, null);
		nextNode = this.head;
		if (index == 0) {
			this.head = null;
		} else {
		for (int i = 0; i < index - 1; i ++) {
			nextNode = nextNode.next;
		}}
		tempNode = nextNode;
		
		nextNode.next = nextNode.next.next;
		return tempNode.getData();
		
	}

	
	public String print() {
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		Node<E> workingNode = new Node<E>();
		workingNode = this.head;
		if (this.head == null) {
			System.out.println("List is empty. No data to print.");
		} else {
			
			while (workingNode != null) {
				sb.append(workingNode.getData());
				sb.append(" ");
				workingNode = workingNode.next;
			}
			System.out.print(sb.toString());
			return sb.toString();
			
		}
		return sb.toString();
	}

	


}
