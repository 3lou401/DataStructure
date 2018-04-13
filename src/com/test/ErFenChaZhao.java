package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by LeaderHoo on 2018/3/29
 */
public class ErFenChaZhao {
    public static int  get(int [] a,int k){
        int left = 0;
        int right = a.length;

        while (left < right){
            int mid = (left +right)/2;
            if(k == a[mid]){
                return mid;
            }
            if (k < a[mid]){
                right = mid -1;
            }
            if (k> a[mid]){
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,5};
        System.out.println(ErFenChaZhao.get(a,15));
    }
}
