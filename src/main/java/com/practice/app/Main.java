package com.practice.app;

import com.practice.data_structures.LinkedList;

public class Main{

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.print();
        list.printReverse();
    }
}




