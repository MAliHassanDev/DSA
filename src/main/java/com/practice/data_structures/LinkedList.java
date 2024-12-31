package com.practice.data_structures;

import java.util.List;


public class LinkedList<T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	public LinkedList(){};

	// inserts new node at the end of list
	public void insert(T value){
		Node<T> node = this.createNode(value);
		this.assignHeadIfNull(node);
		this.tail.next = node;
		this.tail = node;
		this.size++;
	}

	public void insert(int index,T value){
		this.validateIndex(index);
		
		Node<T> newNode = this.createNode(value);
		// replace the head
		if(index == 0){
			newNode.next = this.head.next;
			this.head.next = null;
			this.head = newNode;
		}
		this.insertNextToNode(this.getPreviousNode(index),newNode);
	}

	public T get(int index){
		this.validateIndex(index);
		Node<T> targetNode = this.head;
		int currentIndex = 1;
		while(currentIndex <= index){
			targetNode = targetNode.next;
			currentIndex++;
		}
		return targetNode.value;
	}

	public T getFirst(){
		return this.head.value;
	}

	public T getLast(){
		return this.tail.value;
	}

	public int size(){
		return this.size;
	}

	public boolean remove(T value){
		if(this.head == null) return false;
		
		Node<T> previousNode = this.head;
		boolean nodeFound = false;
		if(previousNode.value == value){
			nodeFound = true;
		}else{
			while(previousNode.next != null){
				if(previousNode.next.value == value){
					nodeFound = true;
					break;
				}
				previousNode = previousNode.next;
			}
		}
		if(nodeFound){
			this.removeNextNode(previousNode);
		}
		return nodeFound;
	}

	public void removeAt(int index){
		this.validateIndex(index);
		Node<T> prevNode = this.getPreviousNode(index);
		this.removeNextNode(prevNode);
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

	private Node<T> createNode(T value){
		return new Node<T>(value);
	}

	private void assignHeadIfNull(Node<T> node){
		if(this.head == null){
			this.head = node;
			this.tail = node;
		}
	}

	private void insertNextToNode(Node<T> currentNode,Node<T> newNode){
		newNode.next = currentNode.next;
		currentNode.next = newNode;
		this.size++;
	}

	private void removeNextNode(Node<T> currentNode){
		Node<T> nextNode = currentNode.next;
		currentNode.next = nextNode.next;
		nextNode.next = null;
		this.size--;
	}

	// finds the node which is one index behind the node at given index
	private Node<T> getPreviousNode(int index){
		Node<T> prevNode = this.head;
		int nextNodeIndex = 1;
		while(nextNodeIndex < index){
			prevNode = prevNode.next;
			nextNodeIndex++;
		}
		return prevNode;
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
}