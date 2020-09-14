package com.company;

public class Tree<T extends Comparable<T>>{
    private Node<T> root;
    int index;
    int length;

    public Tree(int length) {
        root = null;
        index = 0;
        this.length = length;
    }

    public boolean insertNode(T value) {
        boolean result;
        if (index < length - 1) {
            Node<T> newNode = new Node<>(value);
            newNode.setIndex(index);
            result = true;
            if (root == null) {
                root = newNode;
            }
            else {
                Node<T> current = root;
                Node<T> parent;
                while (true) {
                    parent = current;
                    if (newNode.compareTo(current) < 0) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            break;
                        }
                    }
                    else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = newNode;
                            break;
                        }
                    }
                }
            }
            index++;
        }
        else
            result = false;
        return result;
    }
//    public void addNode(T value) {
//        Node<T> newNode = new Node<>(value);
//        newNode.setIndex(index);
//
//        if (root == null) {
//            root = newNode;
//        }
//        else {
//            Node<T> current = root;
//            Node<T> parent;
//            while (true) {
//                parent = current;
//                if (newNode.compareTo(current) < 0) {
//                    current = current.leftChild;
//                    if (current == null) {
//                        parent.leftChild = newNode;
//                        return;
//                    }
//                }
//                else {
//                    current = current.rightChild;
//                    if (current == null){
//                        parent.rightChild = newNode;
//                        return;
//                    }
//                }
//            }
//        }
//        index++;
//    }
//
//    public T findByIndex(int index) {
//        T result = null;
//        if (root == null) {
//            result = null;
//        }
//        else {
//            Node<T> current = root;
//            while (current != null) {
//                if (index < current.getIndex()) {
//                    current = current.leftChild;
//                } else {
//                    current = current.rightChild;
//                }
//                result = current.getValue();
//            }
//        }
//        return result;
//    }

    public T postOrder(Node<T> localNode, int index) {
        if (localNode != null && localNode.getIndex() != index) {
            postOrder(localNode.leftChild, index);
            postOrder(localNode.rightChild, index);
        }
        else {
            return localNode.getValue();
        }
        return null;
    }

    public T findByIndex(int index) {
        T result = null;
        if (root != null) {
            result = postOrder(root, index);
        }
        else {
            result = null;
        }
        return result;
    }

    public void delete(int index) {

    }
}
