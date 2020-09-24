package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        Tree<Integer> array;
        int length;
        length = scanner.nextInt();
        array = new Tree<Integer>(length);
        array.insertNode(5);
        array.insertNode(6);
        array.insertNode(5);
        array.print();

    }
}
