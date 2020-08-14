package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class module3Test<E> {

	@Test
	public void testIsEmpty() {
		
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		
		
		assertTrue(myLinkedList.isEmpty());
		myLinkedList.addFirst(4);
		
		assertFalse(myLinkedList.isEmpty());
	}

	
	@Test
	public void testAddFirst() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.addFirst(8);
		assertEquals(new Integer (8), myLinkedList.head.getData());
	}
	
	@Test
	public void testSize() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		assertEquals(0, myLinkedList.size());
		
		myLinkedList.addFirst(8);
		myLinkedList.addLast(12);
		myLinkedList.addLast(11);
		myLinkedList.addLast(9);
		assertEquals(4, myLinkedList.size());
		
	}
	
	@Test
	public void testAddLast() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.addFirst(8);
		myLinkedList.addLast(12);
		myLinkedList.addLast(11);
		myLinkedList.addLast(9);
		assertEquals(new Integer (9), myLinkedList.head.next.next.next.getData());
	}
	
	@Test 
	public void testAdd() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.addFirst(8);
		myLinkedList.addLast(12);
		myLinkedList.addLast(11);
		myLinkedList.addLast(9);
		myLinkedList.add(2, 2);
		assertEquals(new Integer(2), myLinkedList.head.next.next.getData());
		
	}
	
	@Test 
	public void testRemove() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.addFirst(8);
		myLinkedList.addLast(12);
		myLinkedList.addLast(11);
		myLinkedList.addLast(9);
		myLinkedList.remove(2);
		
		assertEquals(new Integer(9), myLinkedList.head.next.next.getData());
		
	}
	
	@Test
	public void testPrint() {
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.addFirst(8);
		myLinkedList.addLast(12);
		myLinkedList.addLast(11);
		myLinkedList.addLast(9);
		
		
		assertEquals("8 12 11 9 ",myLinkedList.print());
	}
	
	}