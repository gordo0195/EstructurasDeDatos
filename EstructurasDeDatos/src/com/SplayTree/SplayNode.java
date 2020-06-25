package com.SplayTree;

public class SplayNode<T extends Comparable<T>> {

    public T element;
    private SplayNode<T> Father;
    private SplayNode<T> LeftChld;
    private SplayNode<T> RightChld;

    public SplayNode(T element, SplayNode<T> Father, SplayNode<T> LeftChld, SplayNode<T> RightChld){
        this.element = element;
        this.Father = Father;
        this.LeftChld = LeftChld;
        this.RightChld = RightChld;
    }

    public <T extends Comparable<? super T>> SplayNode(T element) {
    }

    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }
    public SplayNode<T> getFather(){
        return Father;
    }
    public void setFather(SplayNode<T> Father){
        this.Father = Father;
    }
    public SplayNode<T> getLeftChld(){
        return LeftChld;
    }
    public void setLeftChld(SplayNode<T> LeftChld){
        this.LeftChld = LeftChld;
    }
    public SplayNode<T> getRightChld(){
        return RightChld;
    }
    public void setRightChld(SplayNode<T> RightChld){
        this.RightChld = RightChld;
    }
}
