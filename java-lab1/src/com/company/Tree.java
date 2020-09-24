package com.company;

import java.sql.PseudoColumnUsage;

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

//    public T inOrderData(Node<T> localNode, int index) {
//        if (localNode != null && localNode.getIndex() != index) {
//            inOrderData(localNode.leftChild, index);
//            inOrderData(localNode.rightChild, index);
//        }
//        else {
//            return localNode.getValue();
//        }
//        return null;
//    }

    public Node<T> inOrderNode(Node<T> localNode, int index) {
        if (localNode != null && localNode.getIndex() != index) {
            inOrderNode(localNode.leftChild, index);
            inOrderNode(localNode.rightChild, index);
        }
        else {
            return localNode;
        }
        return null;
    }

    public void print() {
        inOrderPrint(root);
    }

    public void inOrderPrint(Node<T> localNode) {
        if (localNode != null) {
            inOrderPrint(localNode.leftChild);
            System.out.print(localNode.getValue() + " ");
            inOrderPrint(localNode.rightChild);
        }
    }

    public Node<T> findByIndex(int index) {
        Node<T> result = null;
        if (root != null) {
            result = inOrderNode(root, index);
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
        Node<T> current = inOrderNode(root, index);
        Node<T> parent = getParentByChildIndex(index, root);

        if (current == null) {
            return false;
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (parent.leftChild == current) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        else if (current.rightChild == null){
            if (current == root) {
                root = current.leftChild;
            } else if (current == parent.leftChild) {
                parent.leftChild = current.leftChild;
            } else  {
                parent.rightChild = current.leftChild;
            }
        }
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (current == parent.leftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        else {
            Node<T> successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (current == parent.leftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
        return true;
    }

    public  Node<T> getParentByChildIndex(int childIndex, Node<T> currentNode) {
        if (currentNode.rightChild.getIndex() == childIndex || currentNode.leftChild.getIndex() == childIndex) {
            return currentNode;
        }

        getParentByChildIndex(childIndex, currentNode.rightChild);
        getParentByChildIndex(childIndex, currentNode.leftChild);

        return null;
    }

    public Node<T> getSuccessor(Node<T> delNode) {
        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}
