package Heap.PriorityQueue;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/5 14:25
 * @Desc： 采用数组实现优先队列：
 *             优先队列要求：可以删除最大元+可以插入（不一定是队列有序）
 *         当前类，采用有序数组进行
 */
public class PriorityQueueByArray<key extends Comparable<key>>
        extends PriorityQueueTemplate<key>{

    //初始容量
    private static final int DEFAULT_CAPACITY  = 10;

    private key [] a;

    private int tempSize ;

    public PriorityQueueByArray(int capcity) {
        tempSize = 0;
        a = (key[])new Comparable[capcity];
    }

    public PriorityQueueByArray(key[] a) {
         tempSize = a.length;
         a = (key[])new Comparable[(tempSize +2)*11/10]; //计算规则 瞎算的

         //插入元素
        for (key k: a) {
            add(k);
        }
    }

    @Override
    key poll() {
        if (tempSize == 0)
            return null;
        return a[--tempSize];
    }
    //插入的时候，保证数组顺序
    @Override
    void add(key key) {
        if (tempSize == 0){
            a[0] = key;
            tempSize++;
            return;
        }
        //如果数组容量不足，需要扩容
        if (tempSize >= a.length)
            ensureCapcity(a);

        a[tempSize] = key;
        //插入到指定元素位置
        for (int i = tempSize ; i > 0;i--){
            if (a[i].compareTo(a[i-1]) > 0){
                exch(a,i,i-1);
            }
        }
        tempSize++;
    }

    @Override
    boolean isEmpty() {
        return tempSize == 0;
    }

    //数组扩容方法
    public void ensureCapcity(key [] a){
        Arrays.copyOf(a,a.length*2);
    }
}
