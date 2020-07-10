package com.DinList;


public class DinListNode<T> {

    public T element;
    private DinListNode<T> next;

    public DinListNode(T element, DinListNode<T> next){
        this.element = element;
        this.next = next;
    }
    public T getElement(){
        return element;
    }
    public void setElement(T element){
        this.element = element;
    }

    public DinListNode<T> getNext() {
        return next;
    }
    public void setNext(DinListNode<T> next){
        this.next = next;
    }
    @Override
    public String toString(){
        return element + "\n";
    }

}
