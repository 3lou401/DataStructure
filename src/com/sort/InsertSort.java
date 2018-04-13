package com.sort;

import java.util.Arrays;

/**
 * Created by LeaderHoo on 2018/3/30
 */
public class InsertSort {
    public static void insertSort(int [] a){
        int j;
        for(int i = 1;i < a.length;i++){
            for ( j = i; j>0&& a[i] < a[j-1];j--){
                a[j] =a[j-1];
            }
            a[j] = a[i];
        }
    }

    public static void main(String[] args) {
        int [] a = {1,3,4,32,2,2};
        System.out.println(Arrays.toString(a));
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
