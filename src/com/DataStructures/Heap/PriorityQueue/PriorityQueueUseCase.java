package com.DataStructures.Heap.PriorityQueue;

import java.util.PriorityQueue;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/9 14:09
 * @desc: 优先队列使用例子
 * @note：
 *      add offer类似，向队列尾部添加元素，
 *          区别是 队列已满，add则抛出一个IIIegaISlabEepeplian异常;offer是返回false
 *      pool remove类似，移除队列元素
 *          区别是 队列为空 poll返回false ;remove抛出异常
 *
 * @output: I O P I R R T Y E Q U U
 */
public class PriorityQueueUseCase {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("P");
        pq.add("R");
        pq.add("I");
        pq.add("O");
        System.out.printf(" "+pq.poll());
        pq.add("R");
        System.out.printf(" "+pq.poll());
        System.out.printf(" "+pq.poll());
        pq.add("I");
        System.out.printf(" "+pq.poll());
        pq.add("T");
        System.out.printf(" "+pq.poll());
        pq.add("Y");
        System.out.printf(" "+pq.poll());
        System.out.printf(" "+pq.poll());
        System.out.printf(" "+pq.poll());
        pq.add("Q");
        pq.add("U");
        pq.add("E");
        System.out.printf(" "+pq.poll());
        System.out.printf(" "+pq.poll());
        System.out.printf(" "+pq.poll());
        pq.add("U");
        System.out.printf(" "+pq.poll());
        pq.add("E");
    }
}
