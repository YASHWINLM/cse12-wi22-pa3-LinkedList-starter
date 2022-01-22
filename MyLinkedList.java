/**
 * TODO: Add your file header
 * Name:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * 
 * 2-4 sentence file description here
 */

import java.util.AbstractList;

/** 
 * TODO: Add class header here 
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		/* Add your implementation here */
		// TODO
		this.size=0;
		this.head=new Node(null);
		this.tail=new Node (null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
	}

	@Override
	public int size() {
		// need to implement the size method
		return this.size; // TODO
	}

	@Override
	public E get(int index) {
		if(index<0 || index>size()){
			throw new IndexOutOfBoundsException();
		}
		
		return getNth(index).data;  // TODO
	}

	@Override
	public void add(int index, E data) {
		/* Add your implementation here */
		// TODO

		Node newNode = new Node(data);
		if (data == null)
			throw new NullPointerException();
		else if (size == 0 || index == size) {

			newNode.next = tail;
			newNode.prev = tail.prev;
			newNode.prev.next = newNode;
			tail.prev = newNode;

		} else {
			Node curNode = getNth(index - 1);
			newNode.prev = curNode.prev;
			newNode.next = curNode;
			curNode.prev = newNode;
		}

		size++;
	}

	public boolean add(E data) {
		add(size, data);
		return true;
	}

	public E set(int index, E data) {
		if(data==null){
			throw new NullPointerException();
		}
		if(index < 0 || index >=size()){
			throw new IndexOutOfBoundsException();
		}
		Node replacingNode=this.head.next;
		E replaced=null;
		for(int i=0;i<=index;i++){
			if(replacingNode.equals(getNth(index))){
				replaced=replacingNode.data;
				replacingNode.data=data;
			}
			replacingNode=replacingNode.next;
		}
		return replaced; // TODO
	}

	public E remove(int index) {
		Node curNode= getNth(index);
		curNode.prev.next = curNode.next;
		curNode.next.prev = curNode.prev;
		return (E) curNode.data; // TODO
	}

	public void clear() {
		/* Add your implementation here */
		this.size=0;
		this.head=new Node(null);
		this.tail=new Node (null);
		this.head.setNext(this.tail);
		this.tail.setPrev(this.head);
	}

	public boolean isEmpty() {
		if(this.size==0){
			return true;
		}
		return false;  // TODO
	}

	protected Node getNth(int index) {
		if(index < 0 || index >=size()){
			throw new IndexOutOfBoundsException();
		}
		Node nTH=this.head.next;
		for(int i=0;i<index;i++){
			nTH=nTH.next;
		}
		
		return nTH;  // TODO
	}
}