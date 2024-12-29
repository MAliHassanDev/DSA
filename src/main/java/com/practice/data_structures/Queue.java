package com.practice.data_structures;

import java.util.ArrayList;

public class Queue{
	private final ArrayList<Integer> queue;

	public Queue(){
		queue = new ArrayList<>();
	}

	public void enQueue(int value){
		queue.add(value);
	}

	public void deQueue(){
		if(!queue.isEmpty()){
			queue.removeFirst();
		}	
	}

	public int read(){
		return queue.getFirst();
	}
}
