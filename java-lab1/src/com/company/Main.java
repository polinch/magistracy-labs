package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Tree<Integer> array;
        int length;
        length = scanner.nextInt();
        array = new Tree<Integer>(length);
        array.insertNode(7);
        array.insertNode(6);
        array.insertNode(5);
        array.insertNode(8);
        array.insertNode(9);
        array.insertNode(3);
        array.insertNode(10);
        //array.delete(2);
        array.print();
        System.out.println(array.findByIndex(0).getValue());
        System.out.println(array.findByIndex(1).getValue());
        System.out.println(array.findByIndex(2).getValue());
        System.out.println(array.findByIndex(3).getValue());
        System.out.println(array.findByIndex(4).getValue());
        System.out.println(array.findByIndex(5).getValue());
        System.out.println(array.findByIndex(6).getValue());
    }
}
