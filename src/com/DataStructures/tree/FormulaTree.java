package com.DataStructures.tree;

import java.util.Stack;

/**
 * Created by LeaderHoo on 2018/3/24
 */
public class FormulaTree {
    private  String s;
    private Node root;
    //返回树只需要返回根节点即可
    public Node createTree(String str){
        Stack<Node> treeStack = new Stack<>();
        //声明一个数组列表，存放节点的数据
        for (int i = 0; i< str.length();i++){
            char c = str.charAt(i);
            if (c>='0' && c<='9'){
                treeStack.push(new Node(""+c));
            }else{
                //操作符
                Node right = treeStack.pop();
                Node left= treeStack.pop();
                treeStack.push(new Node(c+"",left,right));
            }
        }
        return treeStack.pop();
    }

    public void printTree(int depth,Node tempNode){
//        先打印深度
        for(int i = 0;i < depth;i++){
            System.out.print(" ");
        }
        if (tempNode.left != null){
            printTree(depth+1,tempNode.left);
        }

        System.out.println(tempNode.data);
        if (tempNode.right != null){
            printTree(depth+1,tempNode.right);
        }
    }

    public static void main(String[] args) {
        String s = "12+34+-";
        FormulaTree f  = new FormulaTree();
        Node rootTree = f.createTree(s);
        f.printTree(0,rootTree);
    }
}

class  Node{
    String data;
    Node left;
    Node right;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}