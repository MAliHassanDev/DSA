package com.practice.data_structures;

import java.util.ArrayList;
import java.util.List;

public class Queue<T>{
	private final List<T> queue;

	public Queue(){
		queue = new ArrayList<>();
	}

	public void enQueue(T value){
		queue.add(value);
	}

	public void deQueue(){
		if(!queue.isEmpty()){
			queue.removeFirst();
		}	
	}

	public T read(){
		return queue.getFirst();
	}
}
