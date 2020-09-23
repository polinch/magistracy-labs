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
                    if (newNode.getValue().compareTo(current.getValue()) < 0) {
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

    public T inOrder(Node<T> localNode, int index) {
        if (localNode != null && localNode.getIndex() != index) {
            inOrder(localNode.leftChild, index);
            inOrder(localNode.rightChild, index);
        }
        else {
            return localNode.getValue();
        }
        return null;
    }

    public void inOrderPrint(Node<T> localNode) {
        if (localNode != null) {
            inOrderPrint(localNode.leftChild);
            System.out.print(localNode.getValue() + " ");
            inOrderPrint(localNode.rightChild);
        }
    }

    public T findByIndex(int index) {
        T result = null;
        if (root != null) {
            result = inOrder(root, index);
        }
        else {
            result = null;
        }
        return result;
    }

    public boolean delete(int index) {
        if (root == null) {
            return false;
        }
        else {
            Node<T> current = root;
            Node<T> parent = root;

        }

        return false;
    }

    public Node<T> getSuccessor(Node<T> delNode) {

        return null;
    }
}
