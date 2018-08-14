package com.Algorithm.sort.merge;

import com.Algorithm.sort.base.Basetemplate;

import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/22 18:53
 * @desc： 归并排序 ：利用内存，创建一个大小是两个子序列之和的数组，进行插入
 *  NlogN
 * @Note
 *      1.归并操作，将两个数组合二为一
 */
public class Merge extends Basetemplate {

    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <=1)
            return;
        mergeSort(a,0,a.length-1);
    }

    private  void mergeSort(Comparable [] a, int left, int right){
        //递归方法两种写法：第一种是判断如果不符合条件直接退出；第二种判断满足条件才可以进入
        if (left < right){
            int center = (left + right)/2;
            mergeSort(a,left ,center);
            mergeSort(a,center+1 ,right);
            merge(a,left,center,right);
        }
    }

    private void merge(Comparable[] a, int left, int center, int right) {
        int i = left;
        int j = center + 1;
        Comparable [] temp = new Comparable[right-left+1];
        int k = 0;
        while (i <= center && j <= right){
            if (less(a[i],a[j])){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        while (i <= center){
            temp[k++] = a[i++];
        }
        while (j <=right){
            temp[k++] = a[j++];
        }
        for (int l = 0;l<temp.length;l++){
            a[left+l] = temp[l];
        }
    }


    public static void main(String[] args) {
        Integer [] a = {21,1,23,34,22,5,6,8,2,4,7,12234,22,44,5667,88,9090,3345,22434,11};
        Merge merge = new Merge();
        merge.sort(a);
        show(a);
    }
}
