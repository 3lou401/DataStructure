package com.DataStructures.Heap.PriorityQueue;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/5 14:28
 * @desc：优先队列的模板类
 */
public abstract class PriorityQueueTemplate<key extends Comparable<key>> {

    abstract key poll();

    abstract void add(key key);

    abstract boolean isEmpty();

    //交换数组元素
    public static void exch(Comparable []a ,  int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
