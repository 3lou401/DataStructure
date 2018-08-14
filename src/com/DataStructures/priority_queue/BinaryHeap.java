package com.DataStructures.priority_queue;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/11 17:31
 * @desc ：二叉堆
 */
public class BinaryHeap<E extends Comparable<? super E>>   {
    public static int Default_capicity = 10;
    private int currentSize;
    private E[] array; //the heap array

//    public void insert11(E e){
//        //堆扩容
//            if (currentSize == array.length-1){
//            enlargeArray(array.length *2 +1);
//        }
//        //先插入对应的位置
//        array[currentSize++] = e;
//
//        //判断堆序
//        int destination = currentSize;
//        while (destination > 0 && array[destination].compareTo(array[destination/2]) > 0){
//            swap( array[destination],array[destination/2]);
//            destination/=2;
//        }
//
//    }
    public void insert(E e){
        //堆扩容
        if (currentSize == array.length-1){
            enlargeArray(array.length *2 +1);
        }
        int hole = ++ currentSize;
        for (array[0] = e;e.compareTo(array[hole/2])<0;hole/=2){
            array[hole] =array[hole/2];
        }
        array[hole] =e;
    }

    private void enlargeArray(int i) {

    }

    public void swap (E e1,E e2){

    }
}
