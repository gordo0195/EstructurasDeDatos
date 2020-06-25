package com.binarySearchTree;

import java.util.Iterator;

public class DinamicList<T> implements Iterable<T> {

    private DinListNode<T> first;
    private DinListNode<T> last;
    private int size;

    public DinamicList(){
        first = null;
        last = null;
        size = 0;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int Size(){
        return size;
    }
    public T get(int index){
        if(isEmpty() || (index < 0 || index >= Size())){
            return null;
        }else if(index == 0){
            return getFirst();
        }else if(index == Size()-1){
            return getLast();
        }else{
            DinListNode<T> searched = getNode(index);
            return searched.getElement();
        }
    }
    public T getFirst(){
        if(isEmpty()){
            return null;
        }else{
            return first.getElement();
        }
    }
    public T getLast(){
        if(isEmpty()){
            return null;
        }else{
            return last.getElement();
        }

    }
    private DinListNode<T> getNode(int index){
        if(isEmpty() || (index < 0 || index >= Size())){
            return null;
        }else if(index == 0){
            return first;
        }else if(index == Size()-1){
            return last;
        }else{
            DinListNode<T> searched = first;
            int count = 0;
            while (count < index){
                count++;
                searched = searched.getNext();
            }
            return searched;
        }
    }
    public T addLast(T element){
        DinListNode<T> aux;
        if(isEmpty()){
            return addFirst(element);
        }else{
            aux = new DinListNode<>(element, null);
            last.setNext(aux);
            last = aux;
        }
        size++;
        return last.getElement();
    }
    public T addFirst(T element){
        DinListNode<T> aux;
        if(isEmpty()){
            aux = new DinListNode<>(element, null);
            first = aux;
            last = aux;
        }else{
            DinListNode<T> actualFisrt = first;
            aux = new DinListNode<>(element, actualFisrt);
            first = aux;
        }
        size++;
        return first.getElement();
    }
    public T add(T element, int index){
        if(index == 0){
            return addFirst(element);
        }else if(index == Size()){
            return addLast(element);
        }else if((index < 0 || index >= Size())){
            return null;
        }else{
            DinListNode<T> beforeSearched = getNode(index - 1);
            DinListNode<T> actualSearched = getNode(index);
            DinListNode<T> aux = new DinListNode<>(element, actualSearched);
            beforeSearched.setNext(aux);
            size++;
            return getNode(index).getElement();
        }
    }
    public String toString(){
        String content = "";
        if(isEmpty()){
            content = "Lista Vacía";
        }else{
            DinListNode<T> aux = first;
            while (aux != null){
                content += aux.toString();
                aux = aux.getNext();
            }
        }
        return content;
    }
    public boolean exists(T element){
        if(isEmpty()) {
            return false;
        }else{
            DinListNode<T> aux = first;
            while (aux != null){
                if (element.equals(aux.getElement())){
                    return true;
                }
                aux = aux.getNext();
            }
            return false;
        }
    }
    public int indexOf(T element){
        if(isEmpty()){
            return -1;
        }else{
            DinListNode<T> aux = first;
            int position = 0;
            while (aux != null){
                if(element.equals(aux.getElement())){
                    return position;
                }
                position++;
                aux = aux.getNext();
            }
            return -1;
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }else{
            T element = first.getElement();
            DinListNode<T> aux = first.getNext();
            first = null;
            first = aux;
            if (Size() == 1){
                last = null;
            }
            size--;
            return element;
        }
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }else {
            T element = last.getElement();
            DinListNode<T> aux = getNode(Size()-2);
            if (aux == null){
                last = null;
                if(Size() == 2){
                    last = first;
                }else{
                    first = null;
                }
            }else{
                last = null;
                last = aux;
                last.setNext(null);
            }
            size--;
            return element;
        }
    }
    public T remove(int index){
        if(isEmpty() || (index < 0 || index >= Size())){
            return null;
        }else if(index == 0){
            return removeFirst();
        }else if(index == Size()-1){
            return removeLast();
        }else{
            DinListNode<T> before = getNode(index-1);
            DinListNode<T> actual = getNode(index);
            T element = actual.getElement();
            DinListNode<T> nextN = actual.getNext();
            actual = null;
            before.setNext(nextN);
            size--;
            return element;
        }
    }
    public T modify(T element, int index){
        if (isEmpty() || (index < 0 || index >= Size())){
            return null;
        }else {
            DinListNode<T> aux = getNode(index);
            aux.setElement(element);
            return aux.getElement();
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new NewIterator();
    }

    private class NewIterator<DinamicList> implements Iterator<T>{

        private int next;

        @Override
        public boolean hasNext() {
            return getNode(next) != null;
        }

        @Override
        public T next() {
            T element = getNode(next).getElement();
            next++;
            return element;
        }
    }
}
