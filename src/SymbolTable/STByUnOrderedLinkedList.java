package SymbolTable;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/13 10:51
 * @Desc: 利用无序链表实现符号表
 */
public class STByUnOrderedLinkedList<K extends Comparable<K>,V> implements ST<K ,V> {

     private  int size;

     private Node head;

     private class Node{
         private K key;

         private V value;

         private Node next;

         public Node(K key, V value, Node next) {
             this.key = key;
             this.value = value;
             this.next = next;
         }

     }

    @Override
    public void put(K key, V value) {
        //查询是否存在重复的key值
        for (Node temp = head;temp != null;temp=temp.next){
            if(Objects.equals(temp.key,key)){
                //找到相同的key,直接替换值
                  temp.value = value;
                  return;
            }
        }
        //没有相同元素可以直接放链表头部
        head = new Node(key,value,head);
        size++;
    }

    @Override
    public V get(K key) {
         V value = null;
        for (Node temp = head;temp != null;temp=temp.next){
            if(Objects.equals(temp.key,key)){
                //找到相同的key,直接替换值
                value = temp.value;
            }
        }
        return value;
    }
    //分情况判断原因： 再删除元素时，需要记录 tempNode,preNode,所以比较的只能从第二个节点比较
    @Override
    public void delete(K key) {

         //如果删除元素是表头元素
        if (Objects.equals(head.key,key)){
            head = head.next;
            size--;
            return;
        }

        //如果删除元素在表头的下一个元素到结束元素怒
         for (Node node = head,pre= head;node !=null;pre = node,node = node.next){
             if (node.next != null){
                 Node  checkNode = node.next;
                 if (Objects.equals(checkNode.key,key)){
                     //要删除的元素就是node.next
                     pre.next=checkNode.next;
                     size--;
                     return;
                 }
             }

         }
    }

    @Override
    public boolean contains(K key) {
        boolean value = false;
        for (Node temp = head;temp != null;temp=temp.next){
            if(Objects.equals(temp.key,key)){
                //找到相同的key,直接替换值
                value = true;
            }
        }
        return value;
    }

    @Override
    public Iterator<K> keys() {
        List<K> keys = new ArrayList<>(size);
        for (Node node = head;node != null;node = node.next){
            keys.add(node.key);
        }
        return (Iterator<K>) keys.iterator();
    }

    public static void main(String[] args) {
        ST<String, String> st = new STByUnOrderedLinkedList<>();
        st.put(null, "null");
        st.put(null, null); //测试覆盖
        st.put("computer", "电脑");
        st.put("SymbolTable", "符号表");
        System.out.println("containsKey:null "+st.contains(null));
        st.delete("computer");
        Iterator<String> iterator = st.keys();
        while (iterator.hasNext()) {
            System.out.println(st.get(iterator.next()));
        }
    }
}
