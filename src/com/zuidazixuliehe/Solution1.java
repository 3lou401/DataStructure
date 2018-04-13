package com.zuidazixuliehe;

/**
 * Created by LeaderHoo on 2018/3/23
 * 一分为二，最大子序列只有三种情况
 *        在左边
 *        在右边
 *        左边最大值+右边最大值
 */
public class Solution1{
    public static int MaxSumRec(int a[],int left,int right){
//        if (left == right){
//            if (a[left] >0)
//                return a[left];
//        }
        int center = (left+right) >> 1;
        int maxLeftSum = MaxSumRec(a,left,center);
        int maxRightSum = MaxSumRec(a,center+1,right);

        return 0;

    }
    public static int Max3(int a, int b,int c){
        if(a < b) a=b;
        if(a<c)a= c;
        return a;
    }

     public static void main(String[] args) {
         System.out.println(8/2+"=="+(8>>1));
     }
}