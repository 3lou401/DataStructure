package com.DataStructures.Heap.PriorityQueue;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/5 17:26
 * @desc: 利用链表实现优先队列 : 用升序的链表
 */
public class PriorityQueueByLinkedList <key extends Comparable<key>>
        extends PriorityQueueTemplate<key>{

    /**链表中的节点类，保存数据和节点信息*/
    class Link{
        key priority;//优先级值
        Link next;

        public Link() {
        }

        public Link(key priority) {
            this.priority = priority;
        }
    }

    private Link first;//新的头节点
    private Link current;//保存中间节点信息，保证节点在移动过程中不丢失上一个节点信息
    private Link previous;//旧的头节点
    private boolean flag = false;
    private int size = 0;//链表的长度


    public PriorityQueueByLinkedList() {
        this.first = null;
    }

    @Override
    key poll() {
        return null;
    }

    @Override
    void add(key k) {
        /*把数据插入到链表的第一个节点*/
        Link link = new Link();
        link.priority = (key) k;
        link.next = first;
        first = link;

        current = first;
        previous = first.next;

        /*得到数据插入的位置，flag用来控制是否要对节点移动*/
        while (current.next != null && link.priority.compareTo(current.next.priority) >= 0)  {
            flag = true;
            if(current.next == null){break;}
            current = current.next;
        }

        /*移动节点到目标位置*/
        if(flag)  {
            link.next = current.next;
            current.next = link;
            first = previous;
            flag  = false;
        }
        size++;
    }

    @Override
    boolean isEmpty() {
        return false;
    }
}
