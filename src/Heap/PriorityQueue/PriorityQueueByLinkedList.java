package Heap.PriorityQueue;

import java.util.LinkedList;

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
    private int size = 0;//链表的长度

    public PriorityQueueByLinkedList() {
        this.first = null;
    }

    @Override
    key poll() {
        return null;
    }

    @Override
    void add(key key) {
        Link link = new Link();

    }

    @Override
    boolean isEmpty() {
        return false;
    }
}
