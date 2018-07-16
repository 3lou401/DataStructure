package SymbolTable;

import org.omg.CORBA.PUBLIC_MEMBER;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/15 16:31
 * @desc: 有序符号表的优化：二叉搜索树
 * @apiNote  : 二叉搜索树BST : 左儿子 < 根 < 右儿子
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;
    //利用节点表示
    private class  Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;//以该节点为根的子节点的总数

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        return size(root);
    }
    private int size(Node x){
        return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node node,Key key){
        if (node == null) return  null;
        int cmp = node.key.compareTo(key);
        if (cmp < 0) return get(node.right,key);
        else if (cmp > 0) return get(node.left,key);
        else return node.value;
    }
    public  void  put(Key key, Value value){
        root=put(root,key,value);
    }

    private Node put(Node x ,Key key,Value value){
        if (x == null ) return  new Node(key,value,1);
        int cmp = x.key.compareTo(key);
        if (cmp < 0 ) x.right =  put(x.right,key,value);
        else if (cmp > 0 )x.left= put(x.left,key,value);
        else  x.value = value;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    /**
    * @author leaderHoo
    * @date 2018/7/16 17:36
    * @Desc  删除任意节点
    */
    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node root, Key key) {
        return  null;
    }


    /**   
    * @author leaderHoo
    * @date 2018/7/16 17:30
    * @Desc   删除最小值
     *   递归方法接受一个父节点，并返回一个指向节点的连接，便于修改树的结构
     *   不断深入根节点的左子树，知道遇到一个空链接，然后改
    */
    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node x){
        if (x.left == null)
            return x.right;
        //如果左儿子多级的话，需要一级一级的递归
        x.left = deleteMin(x.left);
        //每一个节点的子节点的个数，需要重新计算
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }

    public int rank(){
        return 0;
    }

}
