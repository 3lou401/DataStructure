package com.Algorithm.zuidazixuliehe;

/**
 * Created by LeaderHoo on 2018/3/23
 * 计算一个序列中，连续的一个序列，和最大的
 * 比如  ：
 *      1,-2,3,-1,4,5,-8,-2
 *      结果就是 3,-1,4,5
 */
public class Test {
}

class Solution{
    /**
     * i是下标；用来向前走，
            i=0时，利用j、thisNum、maxNum 计算出当前序列中最大值
            i向前移，计算出以a[i+1]为开始的最大子序列
     */
    public static int getMaxSum(int [] a){
        int maxNum = 0;
        for (int i=0;i<a.length;i++){
            int thisNum = 0;
            for (int j=i;j<a.length;j++){
                thisNum+=a[j];
                if (thisNum>maxNum)
                    maxNum = thisNum;
            }
        }
        return maxNum;
    }

}