package com.BST;


public class BinNode {

    public Object element;
    private BinNode Father;
    private BinNode LeftChld;
    private BinNode RightChld;

    public BinNode(Object element, BinNode Father, BinNode LeftChld, BinNode RightChld){
        this.element = element;
        this.Father = Father;
        this.LeftChld = LeftChld;
        this.RightChld = RightChld;
    }

    public BinNode(Object element) {
        this.element = element;
    }

    public Object BinNode(Object element) {
        return element;
    }

    public Object getElement(){
        return element;
    }
    public void setElement(Object element){
        this.element = element;
    }
    public BinNode getFather(){
        return Father;
    }
    public void setFather(BinNode Father){
        this.Father = Father;
    }
    public BinNode getLeftChld(){
        return LeftChld;
    }
    public void setLeftChld(BinNode LeftChld){
        this.LeftChld = LeftChld;
    }
    public BinNode getRightChld(){
        return RightChld;
    }
    public void setRightChld(BinNode RightChld){
        this.RightChld = RightChld;
    }
}
