package com.practice.app;

import com.practice.data_structures.Queue;

public class Main{

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enQueue(2);
        queue.enQueue(4);
        queue.deQueue();
        System.out.println(queue.read());
    }
}