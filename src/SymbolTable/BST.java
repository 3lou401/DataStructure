package SymbolTable;

import edu.princeton.cs.algs4.Queue;
import jdk.nashorn.internal.ir.IfNode;
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
        if(x == null)
            return 0;
        return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node node,Key key){
        if (node == null) return  null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0) return get(node.right,key);
        else if (cmp < 0) return get(node.left,key);
        else return node.value;
    }

    public Key min(){
        if(min(root) == null)
            return null;
        return min(root).key;
    }

    private Node min(Node root){
        if (root == null) return  null;
        return min(root.left);
    }

    public  void  put(Key key, Value value){
        root=put(root,key,value);
    }
    /**
    * @author leaderHoo
    * @date 2018/7/17 10:48
    * @Desc   递归重置每一个父节点指向子节点的连接，并修改子节点的连接
    */
    private Node put(Node x ,Key key,Value value){
        if (x == null ) return  new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        //key小于当前节点的值，操作左子树，并让当前节点指向修改后的子树
        if (cmp < 0 ) x.left =  put(x.left,key,value);
        //key大于当前节点，修改右子树，，并让当前节点的右儿子指向修改后的右儿子
        else if (cmp > 0 )x.right= put(x.right,key,value);
        else  x.value = value;
        x.N = size(x.left)+size(x.right)+1;
        return x;
    }
    /**
    * @author leaderHoo
    * @date 2018/7/17 10:53
    * @Desc   向下取整（不大于key的最大值）
    */
    public Key floor(Key key){
        Node t = floor(root,key);
        if (t == null)
            return null;
        return t.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp= key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
             return floor(x.left,key);
        //如果当前节点值小于key值
        Node t = floor(x.right,key);
        if (t == null )
            return x;
        else
            return t;

    }


    /**
    * @author leaderHoo
    * @date 2018/7/16 17:36
    * @Desc  删除任意节点
    */
    public void delete(Key key){
        root = delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return  null;
        int cmp = key.compareTo(x.key);

        if (cmp == 0 ){
            //当前节点是要删除的节点
            if (x.right == null)
                return  x.left;
            if (x.left == null)
                return x.right;
            //如果左右儿子节点都不为空，则取出右儿子中最小值，作为
            Node t = x;
            x = min(t.right); //要返回的当前节点
            x.right = deleteMin(t.right);
            x.left = t.left;
        }else if(cmp > 0)
            return delete(x.right,key);
        else if (cmp < 0)
            return delete(x.left,key);
        x.N = size(x.right) +size(x.left)+1;
        return x;
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
    //TODO 待开发
    public int rank(){
        return 0;
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<>();
         keys(root,queue,lo,hi);
         return queue;
    }

    private void  keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)  keys(x.left,queue,lo,hi);
        if (cmphi >0) keys(x.right,queue,lo,hi);
        if (cmplo >=0 && cmphi <=0)
            queue.enqueue(x.key);
    }

}
