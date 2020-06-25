package com.AVLTree;

public class AVLNode <T extends Comparable<T>> {

    public T element;
    private AVLNode<T> Father;
    private AVLNode<T> LeftChld;
    private AVLNode<T> RightChld;

    public AVLNode(T element, AVLNode<T> Father, AVLNode<T> LeftChld, AVLNode<T> RightChld){
        this.element = element;
        this.Father = Father;
        this.LeftChld = LeftChld;
        this.RightChld = RightChld;
    }

    public <T extends Comparable<? super T>> AVLNode(T element) {
    }

    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }
    public AVLNode<T> getFather(){
        return Father;
    }
    public void setFather(AVLNode<T> Father){
        this.Father = Father;
    }
    public AVLNode<T> getLeftChld(){
        return LeftChld;
    }
    public void setLeftChld(AVLNode<T> LeftChld){
        this.LeftChld = LeftChld;
    }
    public AVLNode<T> getRightChld(){
        return RightChld;
    }
    public void setRightChld(AVLNode<T> RightChld){
        this.RightChld = RightChld;
    }
}
