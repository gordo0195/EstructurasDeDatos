package com.binarySearchTree;


public class BinTree<T extends Comparable<T>> {

    public BinNode<T> Root;

    public BinTree(){
        this.Root = null;
    }
    public boolean isEmpy(){
        return this.Root == null;
    }
   public BinNode<T> getRoot(){
        return Root;
   }
   public boolean isRoot(BinNode<T> binNode){
        return Root == binNode;
   }
   public boolean isLeaf(BinNode<T> node){
        return node.getLeftChld() == null && node.getRightChld() == null;
   }
   public boolean isInternal(BinNode<T> nodo){
        return !isLeaf(nodo);
   }
   public BinNode<T> add(BinNode<T> origin, T element){
        BinNode<T> node =  null;
        if (Root == null){
            node = new BinNode<>(element);
            Root = node;
        }else if(origin == null){
            System.out.println("Origen Nulo");
        }else{
            if(origin.getElement().compareTo(element) > 0){
                if (origin.getLeftChld() != null){
                    node = add(origin.getLeftChld(), element);
                }else{
                    node = new BinNode<>(element);
                    node.setFather(origin);
                    node.setLeftChld(node);
                }
            }else{
                if(origin.getRightChld() != null){
                    node = add(origin.getRightChld(), element);
                }else{
                    node = new BinNode<>(element);
                    node.setFather(origin);
                    origin.setRightChld(node);
                }
            }
        }
        return node;
   }
   public BinNode<T> add(T element){
        BinNode<T> node = null;
        if (Root == null){
            node = new BinNode<>(element);
            Root = node;
        }else{
            BinNode<T> aux = Root;
            boolean inserted = false;
            while(!inserted){
                if(aux.getElement().compareTo(element) > 0){
                    if(aux.getLeftChld() != null){
                        aux = aux.getLeftChld();
                    }else{
                        node = new BinNode<>(element);
                        node.setFather(aux);
                        aux.setLeftChld(node);
                        inserted = true;
                    }
                }else{
                    if(aux.getRightChld() != null){
                        aux = aux.getRightChld();
                    }else{
                        node = new BinNode<>(element);
                        node.setFather(aux);
                        aux.setRightChld(node);
                        inserted = true;
                    }
                }
            }
        }
        return node;
   }
   public void preOrder(BinNode<T> node){
        System.out.println(node.getElement().toString());
        if(node.getLeftChld() != null){
            preOrder(node.getLeftChld());
        }
        if(node.getRightChld() != null){
            preOrder(node.getRightChld());
        }
   }
   public void postOrder(BinNode<T> node){
        if(node.getLeftChld() != null){
            postOrder(node.getLeftChld());
        }
        if(node.getRightChld() != null){
            postOrder(node.getRightChld());
        }
        System.out.println(node.getElement().toString());
   }
   public void inOrder(BinNode<T> node){
        if(node.getLeftChld() != null){
            inOrder(node.getLeftChld());
        }
        System.out.println(node.getElement().toString());
        if(node.getRightChld() != null){
            inOrder(node.getRightChld());
        }
    }
    public int Height(BinNode<T> node){
        int height = 0;
        if(isInternal(node)){
            if(node.getLeftChld() != null){
                height = Math.max(height, Height(node.getLeftChld()));
            }
            if(node.getRightChld() != null){
                height = Math.max(height, Height(node.getRightChld()));
            }
            height ++;
        }
        return height;
    }
    public int Depth(BinNode<T> node){
        int depth = 0;
        if(node != getRoot()){
            depth = 1 + Depth(node.getFather());
        }
        return depth;
    }
    private final int ONE_NODE_LEFT = 1;
    private final int ONE_NODE_RIGHT = 2;
    private final int TWO_NODES = 3;

    public void Remove(BinNode<T> node){
        if(Root == null){
            System.out.println("No hay nodos en el Árbol");
        }else if(isLeaf(node)){
            removeLeaf(node);
        }else if(node.getRightChld() != null && node.getLeftChld() ==null){
            removeWithChild(node, ONE_NODE_RIGHT);
        }else if(node.getRightChld() == null && node.getLeftChld() != null ){
            removeWithChild(node, ONE_NODE_LEFT);
        }else{
            removeWithChild(node, TWO_NODES);
        }
    }
    private void removeLeaf(BinNode<T> node){
        if (isRoot(node)) {
            Root = null;
        }else{
            BinNode<T> Father = node.getFather();
            if(Father.getLeftChld() == node){
                Father.setLeftChld(null);
            }
            if(Father.getRightChld() == node){
                Father.setRightChld(null);
            }
            node = null;
        }
    }
    private void removeWithChild(BinNode<T> node, int type_node){
        BinNode<T> next = null;

        switch (type_node){
            case ONE_NODE_LEFT:
                next = node.getLeftChld();
                break;
            case ONE_NODE_RIGHT:
                next = minSubTree(node.getRightChld());
                break;
            case TWO_NODES:
                next = minSubTree(node.getRightChld());
                if(!isRoot(next.getFather())){
                    node.getLeftChld().setFather(next);
                    node.getRightChld().setFather(next);
                    if(next.getFather().getLeftChld() == next){
                        next.getFather().setLeftChld(null);
                    }else if(next.getFather().getRightChld() == next){
                        next.getFather().setRightChld(null);
                    }
                }

                break;
        }
        next.setFather(node.getFather());

        if(!isRoot(node)){
            if(node.getFather().getLeftChld() == node){
                node.getFather().setLeftChld(next);
            }else if(node.getFather().getRightChld() == node) {
                node.getFather().setRightChld(next);
            }
        }else{
            Root = next;
        }
        if(node.getRightChld() != null && node.getRightChld() != next){
            next.setRightChld(node.getRightChld());
        }
        if(node.getLeftChld() != null && node.getLeftChld() != next){
            next.setLeftChld(node.getLeftChld());
        }
        node = null;

    }
    private BinNode<T> minSubTree(BinNode<T> node){
        if(node != null && node.getLeftChld() != null){
            while(!isLeaf(node)) {
                node = minSubTree(node.getLeftChld());
            }
        }
        return node;
    }
    public BinNode<T> getNode(BinNode<T> node, T element){
        BinNode<T>  aux = null;
        if(node.getElement().compareTo(element)  == 0){
            aux = node;
        }else{
            if(node.getLeftChld() != null){
                aux = getNode(node.getLeftChld(), element);
            }
            if(node.getRightChld() != null){
                aux = getNode(node.getRightChld(), element);
            }
        }
        return aux;
    }

    public T getElement(BinNode<T> node, T element){
        BinNode<T> aux = getNode(node, element);
        if(aux == null){
            return null;
        }
        return aux.getElement();
    }
    public void getNodes(BinNode<T> node, T element, DinamicList<BinNode<T>> lista_nodos){
        if(node.getElement().compareTo(element) == 0){
            lista_nodos.addLast(node);
        }
        if (node.getLeftChld() != null){
            getNodes(node.getLeftChld(), element, lista_nodos);
        }
        if(node.getRightChld() != null){
            getNodes(node.getRightChld(), element, lista_nodos);
        }
    }
    public DinamicList<T> getElements(BinNode<T> node, T element){
        DinamicList<T> elements = new DinamicList<>();
        DinamicList<BinNode<T>> lista_nodos1 = new DinamicList<>();
        getNodes(node, element, lista_nodos1);
        for(BinNode<T> aux : lista_nodos1) {
            elements.addLast(aux.getElement());
        }
        return elements;
    }
    public void Show(BinNode<T> node){
        int deep = this.Depth(node);
        for(int i=0; i<deep; i++){
            System.out.println((" "));
        }
        System.out.println("- "+node.getElement().toString());
        if(node.getLeftChld() != null){
            Show(node.getLeftChld());
        }
        if (node.getLeftChld() != null){
            Show(node.getRightChld());
        }
    }



}
