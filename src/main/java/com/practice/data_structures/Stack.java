package com.practice.data_structures;

import java.util.List;
import java.util.ArrayList;

public class Stack<T>{
	private final List<T> stack;

	public Stack(){
		stack = new ArrayList<>();
	}

	public T peek(){
		return stack.getLast();
	}

	public void pop(){
		stack.removeLast();
	}

	public void push(T value){
		stack.add(value);
	}

	public boolean isEmpty(){
		return stack.isEmpty();
	}
}