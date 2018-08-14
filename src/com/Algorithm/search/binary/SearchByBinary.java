package com.Algorithm.search.binary;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 10:30
 */
public class SearchByBinary {

    public static void main(String[] args) {
        int  [] a = {1,4,6,22,24,56,114,311};
        int key = 114;
        int left = 0;
        int right = a.length;
        int index = -1;
        while (left <= right){
            int mid = (left +right)/2;
            if (a[mid] > key) right = mid;
            if (a[mid] < key) left = mid;
            if (a[mid] == key){
                index = mid;
                break;
            }
        }
        if (index == -1){
            System.out.printf("未找到数据");
        }else {
            System.out.printf("对应数据位于数组的"+index);

        }

    }
}
