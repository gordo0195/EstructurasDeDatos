package com.AVLTree;

public class AVLTree<T extends Comparable<T>> {

    public AVLNode<T> Root;

    public AVLTree(){
        this.Root = null;
    }
    public boolean isEmpy(){
        return this.Root == null;
    }
    public AVLNode<T> getRoot(){
        return Root;
    }
    public boolean isRoot(AVLNode<T> avlNode){
        return Root == avlNode;
    }
    public boolean isLeaf(AVLNode<T> node){
        return node.getLeftChld() == null && node.getRightChld() == null;
    }
    public boolean isInternal(AVLNode<T> nodo) {
        return !isLeaf(nodo);
    }
}
