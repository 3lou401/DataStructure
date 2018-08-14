package com.Algorithm.fenzhi;

public class GetMaxSumInArray {
    private static int getSum(int [] a, int left,int right){
       //子序列中只有一个值，如果这个值是正数，就是当前值，否则取0
       if (left == right){
            if (a[left] > 0){
                return a[left];
            }else{
                return 0;
            }
       }

       //拆分
        int center = (left +right ) / 2 ;
       int maxLeft = getSum(a,left,center);
       int maxRight = getSum(a,center+1,right);

       //整合比较左边最大值和右边最大值 还有包含左右的子序列的最大值
        int maxLeftBorderSum = 0,leftBorderSum = 0;
        for (int i = center; i> left;i--){
            leftBorderSum+=a[i];
            if (leftBorderSum > maxLeftBorderSum ){
                maxLeftBorderSum = leftBorderSum;
            }
        }
        int maxRightBorderSum = 0,rightBorderSum = 0;
        for (int i = center+1; i < right;i++){
            rightBorderSum+=a[i];
            if (rightBorderSum > maxRightBorderSum ){
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeft,maxRight,maxLeftBorderSum+maxRightBorderSum);
    }

    private  static  int max3(int a,int b,int c){
        int temp = a;
        if (temp < b){
            temp =b;
        }
        if (temp < c){
            temp = c;
        }
        return temp;
    }

    public static void main(String[] args) {

    }
}
