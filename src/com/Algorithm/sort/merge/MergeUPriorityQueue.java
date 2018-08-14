package com.Algorithm.sort.merge;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: leaderHoo
 * @Date: 2018/7/3 16:11
 * @Desc: 归并排序常用于对于两个排序好的数组做归并,如果存在多个排序号的数组，则只能用多路归并
 */
public class MergeUPriorityQueue {

    private static class Element implements Comparable<Element> {
        int value;
        int whichArray;
        int whichIndex;

        Element(int value, int whichArray, int whichIndex) {
            this.value = value;
            this.whichArray = whichArray;
            this.whichIndex = whichIndex;
        }

        @Override
        public int compareTo(Element o) {
            if (value < o.value)
                return -1;
            if (value > o.value)
                return 1;
            return 0;
        }
    }
    public static void main(String[] args) {
        // The arrays used for multi merge com.Algorithm.sort
        Integer[] a = { 6, 19, 24, 31 };
        Integer[] b = { 2, 5, 9, 67 };
        Integer[] c = { 8, 20, 76, 389, 399 };
        Integer[] d = { 266, 388, 736, 736, 3923 };
        Integer[] e = { 38, 234, 1021, 7136, 39342 };

        HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
        map.put(0, a);
        map.put(1, b);
        map.put(2, c);
        map.put(3, d);
        map.put(4, e);

        int arrSize = map.size();
        // The PriorityQueue used for com.Algorithm.sort
        PriorityQueue<Element> pq = new PriorityQueue<Element>(arrSize);

        // Put the first element of each array to the PriorityQueue
        for (int i = 0; i < arrSize; i++) {
            pq.offer(new Element(map.get(i)[0], i, 0));
        }

        Element tem = null;
        int i = 1;
        while ((tem = pq.poll()) != null) {
            System.out.print(tem.value + "\t");
            if (i % 6 == 0)
                System.out.println();
            i++;
            // Put the next element to array if have
            if (tem.whichIndex + 1 < map.get(tem.whichArray).length)
                pq.offer(new Element( map.get(tem.whichArray)[tem.whichIndex + 1], tem.whichArray, tem.whichIndex + 1));
        }
    }
}
