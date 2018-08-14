package com.Algorithm.sort.insert;

import com.Algorithm.sort.base.Basetemplate;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/14 17:16
 * @desc: 插入排序 实现方式：for循环到i槽位时（此时，0到i-1有序），
 * 可以拿每一个位置的元素与a[i](数组可能发生变化，用temp记录a[i])比较 ，可以想象成差扑克
 * 第二种方式 就是从i位置开始 每次都是比较 a[i]和a[i-1]
 */
public class Insertion extends Basetemplate {

    //插入排序：外层控制要插入的操作，内层控制每次插入时要移动的元素
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1)
            return;
        //直接交换的不需要用临时变量记录a[i]
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    //这种方式比第一种方式效率要高
    public void sortLikePoke(Comparable[] a) {
        if (a == null || a.length <= 1)
            return;
        //难点在于移动的时候，控制好j的位置
        for (int i = 1; i < a.length; i++) {
            Comparable temp = a[i];
            int j = i;
            for (; j > 0 && less(temp, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            //这个地方：j表示移位之后空出的位置
            a[j] = temp;
        }

    }

    public static void main(String[] args) {

        Insertion sel = new Insertion();
        Integer[] a = {1, 3, 2, 1123, 23, 56, 29, 9, -2};
        sel.sortLikePoke(a);
        show(a);

    }

}
