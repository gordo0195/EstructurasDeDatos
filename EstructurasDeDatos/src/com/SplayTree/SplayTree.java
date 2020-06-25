package com.SplayTree;

public class SplayTree<T extends Comparable<T>> {

    public SplayNode<T> Root;

    public SplayTree(){
        this.Root = null;
    }
    public boolean isEmpy(){
        return this.Root == null;
    }
    public SplayNode<T> getRoot(){
        return Root;
    }
    public boolean isRoot(SplayNode<T> SplyNode){
        return Root == SplyNode;
    }
    public boolean isLeaf(SplayNode<T> node){
        return node.getLeftChld() == null && node.getRightChld() == null;
    }
    public boolean isInternal(SplayNode<T> nodo) {
        return !isLeaf(nodo);
    }
}
