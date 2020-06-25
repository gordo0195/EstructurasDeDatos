package com.binarySearchTree;

public class BinNode<T extends Comparable<T>> {

    public T element;
    private BinNode<T> Father;
    private BinNode<T> LeftChld;
    private BinNode<T> RightChld;

    public BinNode(T element, BinNode<T> Father, BinNode<T> LeftChld, BinNode<T> RightChld){
        this.element = element;
        this.Father = Father;
        this.LeftChld = LeftChld;
        this.RightChld = RightChld;
    }

    public <T extends Comparable<? super T>> BinNode(T element) {
    }

    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }
    public BinNode<T> getFather(){
        return Father;
    }
    public void setFather(BinNode<T> Father){
        this.Father = Father;
    }
    public BinNode<T> getLeftChld(){
        return LeftChld;
    }
    public void setLeftChld(BinNode<T> LeftChld){
        this.LeftChld = LeftChld;
    }
    public BinNode<T> getRightChld(){
        return RightChld;
    }
    public void setRightChld(BinNode<T> RightChld){
        this.RightChld = RightChld;
    }
}
