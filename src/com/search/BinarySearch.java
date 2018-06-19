package com.search;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearch {
    private  static  int getValIndexInArr(int [] a,int value){
        int left = 0,right= a.length -1;

        while (left < right){
            int mid = (left + right) /2;
            if (a[mid] > value) {
                right = mid;
            }else  if (a[mid] < value){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return  -1;//表示没有找到
    }

    public static void main(String[] args) {
    }

}
