package com.company;

public class Node<T extends Comparable<T>>{
//        implements Comparable<Node<T>> {
    private int index;
    private T value;
    Node<T> leftChild;
    Node<T> rightChild;

    public Node(T t) {
        this.value = t;
    }

    public T getValue() {
        return this.value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

//    @Override
//    public int compareTo(Node<T> o) {
//        return value.compareTo(o.getValue());
//    }
}

