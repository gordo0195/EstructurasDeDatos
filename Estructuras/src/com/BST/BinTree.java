package com.BST;

import com.DinList.DinamicList;

/**import com.Parser.CallJson;
import java.io.IOException;
import java.io.StringWriter;

import com.sun.glass.ui.Size;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.DinList.DinListNode;
import com.Parser.CallJson;
import com.Parser.User;*/


public class BinTree {

    public BinNode Root;

    public BinTree(){
        this.Root = null;
    }
    public boolean isEmpy(){
        return this.Root == null;
    }
   public BinNode getRoot(){
        return Root;
   }
   public boolean isRoot(BinNode binNode){
        return Root == binNode;
   }
   public boolean isLeaf(BinNode node){
        return node.getLeftChld() == null && node.getRightChld() == null;
   }
   public boolean isInternal(BinNode nodo){
        return !isLeaf(nodo);
   }
   private BinNode add(BinNode origin, Object element){
	   
        BinNode node =  null;
        if (Root == null){
            node = new BinNode(element);
            Root = node;
        }else if(origin == null){
            System.out.println("Origen Nulo");
        }else{
            if(origin.getClass().getName().compareTo(element.getClass().getName()) > 0){
                if (origin.getLeftChld() != null){
                    node = add(origin.getLeftChld(), element);
                }else{
                    node = new BinNode(element);
                    node.setFather(origin);
                    node.setLeftChld(node);
                }
            }else{
                if(origin.getRightChld() != null){
                    node = add(origin.getRightChld(), element);
                }else{
                    node = new BinNode(element);
                    node.setFather(origin);
                    origin.setRightChld(node);
                }
            }
        }
        return node;
   }
   public BinNode add(Object element){
        BinNode node = null;
        if (Root == null){
            node = new BinNode(element);
            Root = node;
        }else{
            BinNode aux = Root;
            boolean inserted = false;
            while(!inserted){
                if(aux.getClass().getName().compareTo(element.getClass().getName()) > 0){
                    if(aux.getLeftChld() != null){
                        aux = aux.getLeftChld();
                    }else{
                        node = new BinNode(element);
                        node.setFather(aux);
                        aux.setLeftChld(node);
                        inserted = true;
                    }
                }else{
                    if(aux.getRightChld() != null){
                        aux = aux.getRightChld();
                    }else{
                        node = new BinNode(element);
                        node.setFather(aux);
                        aux.setRightChld(node);
                        inserted = true;
                    }
                }
            }
        }
        return node;
   }
   public void preOrder(BinNode node){
        System.out.println(node.getElement().toString());
        if(node.getLeftChld() != null){
            preOrder(node.getLeftChld());
        }
        if(node.getRightChld() != null){
            preOrder(node.getRightChld());
        }
   }
   public void postOrder(BinNode node){
        if(node.getLeftChld() != null){
            postOrder(node.getLeftChld());
        }
        if(node.getRightChld() != null){
            postOrder(node.getRightChld());
        }
        System.out.println(node.getElement().toString());
   }
   public void inOrder(BinNode node){
        if(node.getLeftChld() != null){
            inOrder(node.getLeftChld());
        }
        System.out.println(node.getClass().getName());
        if(node.getRightChld() != null){
            inOrder(node.getRightChld());
        }
    }



    public int Height(BinNode node){
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
    public int Depth(BinNode node){
        int depth = 0;
        if(node != getRoot()){
            depth = 1 + Depth(node.getFather());
        }
        return depth;
    }
    private final int ONE_NODE_LEFT = 1;
    private final int ONE_NODE_RIGHT = 2;
    private final int TWO_NODES = 3;

    public void Remove(BinNode node){
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
    private void removeLeaf(BinNode node){
        if (isRoot(node)) {
            Root = null;
        }else{
            BinNode Father = node.getFather();
            if(Father.getLeftChld() == node){
                Father.setLeftChld(null);
            }
            if(Father.getRightChld() == node){
                Father.setRightChld(null);
            }
            node = null;
        }
    }
    private void removeWithChild(BinNode node, int type_node){
        BinNode next = null;

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
    private BinNode minSubTree(BinNode node){
        if(node != null && node.getLeftChld() != null){
            while(!isLeaf(node)) {
                node = minSubTree(node.getLeftChld());
            }
        }
        return node;
    }
    public BinNode getNode(BinNode node, Object element){
        BinNode  aux = null;
        if(node.getClass().getName().compareTo(element.getClass().getName())  == 0){
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

    public Object getElement(BinNode node, Object element){
        BinNode aux = getNode(node, element);
        if(aux == null){
            return null;
        }
        return aux.getElement();
    }
    public void getNodes(BinNode node, Object element, DinamicList<BinNode> lista_nodos){
        if(node.getClass().getName().compareTo(element.getClass().getName()) == 0){
            lista_nodos.addLast(node);
        }
        if (node.getLeftChld() != null){
            getNodes(node.getLeftChld(), element, lista_nodos);
        }
        if(node.getRightChld() != null){
            getNodes(node.getRightChld(), element, lista_nodos);
        }
    }

    public DinamicList getElements(BinNode node, Object element){
        DinamicList elements = new DinamicList<>();
        DinamicList<BinNode> lista_nodos1 = new DinamicList<>();
        getNodes(node, element, lista_nodos1);
        for(BinNode aux : lista_nodos1) {
            elements.addLast(aux.getElement());
        }
        return elements;
    }
    public void Show(BinNode node){
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

