package com.logn;

/**
 * Created by LeaderHoo on 2018/3/23
 * 给定一个排序数据，找一个数字A在数组中的下标位置
 *   1,2,3,5,7,23,123 找7
 */
public class BinarySearch {
    public static int getIndex(int[]a,int val){
        int index = -1;
        int low =0,high = a.length-1;
        while (low<high){
            int mid = (low + high)/2;
            if (a[mid]< val)
                low = mid + 1;
            else if (a[mid] > val)
                high =mid - 1;
            else
                return mid;
        }
        return  -1;
    }
}
