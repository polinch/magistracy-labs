package com.company;

public class Tree<T>{
    private Node<T> root;
    int index;

    public Tree() {
        root = null;
        index = 0;
    }

    public void addNode(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setIndex(index);

        if (root == null) {
            root = newNode;
        }
        else {
            Node<T> current = root;
            Node<T> parent;
            while (true) {
                parent = current;
                if (index < current.getIndex()) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
        index++;
    }

    public T findByIndex(int index) {
        T result = null;
        if (root == null) {
            result = null;
        }
        else {
            Node<T> current = root;
            while (current.getIndex() != index) {
                if (index < current.getIndex()) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                result = current.getValue();
                if (current == null) {
                    result = null;
                }
            }
        }
        return result;
    }
}
