package com.practice.data_structures;

import java.util.List;


public class LinkedList<T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList(){};

	// inserts new node at the end of list
	public void insert(T value){
		Node<T> newNode = this.createNode(value,null,null);
		if(this.head == null){
			this.head = newNode;
			this.tail = newNode;
		}else{
			newNode.prev = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}
		this.size++;			
	}

	public void insert(int index,T value){
		this.validateIndex(index);	
		Node<T> newNode = this.createNode(value,null,null);
		if(index == 0){
			newNode.next = this.head;
			this.head.prev = newNode;
			this.head = newNode;
		}else{
			Node<T> targetNode = this.getNode(index);
			Node<T> prevNode = targetNode.prev;
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = targetNode;
			targetNode.prev = newNode; 
		}
		this.size++;
	}

	public T get(int index){
		this.validateIndex(index);
		Node<T> targetNode = this.head;
		int currentIndex = 0;
		while(currentIndex < index){
			targetNode = targetNode.next;
			currentIndex++;
		}
		return targetNode.value;
	}

	public T getHead(){
		return this.head.value;
	}

	public T getTail(){
		return this.tail.value;
	}

	public int size(){
		return this.size;
	}

	public boolean remove(T value){
		if(this.head == null) return false;
		// remove head;
		if(this.head.value == value){
			Node<T> newHead = this.head.next;
			newHead.prev = null;
			this.head = newHead;
			return true;
		}
		Node<T> targetNode = this.head;

		while(targetNode.next != null){
			if(targetNode.value == value){
				this.removeNode(targetNode);
				return true;
			}
			targetNode = targetNode.next;
		}
		return false;
	}

	public void removeAt(int index){
		this.validateIndex(index);
		// remove head
		if(index == 0){
			Node<T> newHead = this.head.next;
			newHead.prev = null;
			this.head = newHead;
			return;
		}
		this.removeNode(this.getNode(index));
	}

	public void reverse(){
		if(this.head == null) return;
		
	}

	public boolean contains(T value){
		Node<T> currentNode = this.head;
		while(currentNode != null){
			if(currentNode.value == value){
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public void print(){
		Node<T> currentNode = this.head;
		System.out.print("Head -> ");

		while(currentNode != null){
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.next;
		}
		System.out.print("Tail\n");
	}

	public void printReverse(){
		Node<T> currentNode = this.tail;
		System.out.print("Tail -> ");
		while(currentNode != null){
			System.out.print(currentNode.value + " -> ");
			currentNode = currentNode.prev;
		}
		System.out.print("Head\n");
	}

	private Node<T> createNode(T value,Node<T> next,Node<T> prev){
		return new Node<T>(value,next,prev);
	}

	private void removeNode(Node<T> node){
		Node<T> prevNode = node.prev;
		prevNode.next = node.next;
		node.next.prev = prevNode;
		node = null;
		this.size--;
	}

	private Node<T> getNode(int index){
		Node<T> currNode = this.head;
		int currNodeIndex = 0;
		while(currNodeIndex < index){
			currNode = currNode.next;
			currNodeIndex++;
		}
		return currNode;
	}

	private void validateIndex(int index){
		if(index < 0 || index > this.size){
			throw new IndexOutOfBoundsException(
				"Index cannot be greater than the list size or less than zero"
			);
		}
	}

}






class Node<T>{
	public final T value;
	public Node<T> next;
	public Node<T> prev;

	public Node(T value, Node<T> next,Node<T> prev){
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public Node(T value){
		this(value,null,null);
	}

	public Node(T value,Node<T> next){
		this(value,next,null);
	}
}