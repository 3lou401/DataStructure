package com.Algorithm.sort.quickSort;

import com.Algorithm.sort.base.Basetemplate;
import com.Algorithm.sort.merge.Merge;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/27 14:26
 * @desc: 快速排序
 *        和归并排序区别在于 ：归并排序对于数组处理在递归调用之后，
 *        快速排序是 对数组二分之后，先处理数组，在递归分别处理
 */
public class Quick extends Basetemplate {


    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=1)
            return;
        quick(a,0,a.length-1);
    }

    private void quick(Comparable[] a, int left, int right) {
        if (left <= right){
            int p = position(a,left,right);
            quick(a,left,p-1);
            quick(a,p+1,right);
        }
    }
    //将数组以a[left]为基准点，大于a[left]的在右边，小于a[left]在左边
    private int position(Comparable[] a, int left, int right) {
        Comparable key = a[left];
        int i = left;
        int j = right;
        while ( i < j ){
            while (less(key,a[j]) && i < j)
                j--;
            while (less(a[i],key) && i < j)
                i++;
            //TODO Very Important 只有i < j的情况下，才可以交换
            if (i >= j)
                break;
             exch(a,i,j);
        }
        //TODO Very Important 最后需要把 a[left] 与 a[i]交换
        exch(a,left,j);
        return j;
    }

    public static void main(String[] args) {
        Integer [] a = {21,1,23,34,22,5,6,8,2,4,7,12234,22,44,5667,88,9090,3345,22434,11};
        Quick quick = new Quick();
        quick.sort(a);
        show(a);
    }

}
