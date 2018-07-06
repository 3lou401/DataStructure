package Heap.PriorityQueue;

import Heap.BinaryHeap.MaxMQ;

import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/5 11:35
 * @desc： 使用优先队列解决现代计算问题：top问题
 * @apiNote PriorityQueue是非线程安全的，所以Java提供了PriorityBlockingQueue
 *          核心就是add poll
 */
public class TopM {
    public static void main(String[] args) {
        MaxMQ<Integer> pq = new MaxMQ<>(20);
        Scanner sc = new Scanner(System.in);
        String val = "";

        while (true){
            val = sc.nextLine();
            if (val.equals("#")) break;
            pq.add(Integer.parseInt(val));
        }
        pollDataFromQueue(pq);
    }
    //用于从队列取数据的通用方法
    private static void pollDataFromQueue(MaxMQ<Integer> customerPriorityQueue) {
        while(true){
            Integer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Processing  with ID="+cust);
        }
    }
}
