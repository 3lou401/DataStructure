package com.Math;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 22:58
 * @Desc:
 */
public class GetBigNumBeforeLog {
    /*
     *
     * @author leaderHoo
     * @createTime 2018/6/19 23:00
     * @param [n]
     * @return int
     * @desc 获取小于logN最大整数
     */
    public int getBigNum(int n){
        int res = -1;
        if (n <= 0)
            return -1;
        if (n <= 1)
            return 0;
        if (n > 1){
            int temp = 1;
            while (temp <= n){
                res++;
                temp*=2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GetBigNumBeforeLog gbl = new GetBigNumBeforeLog();
        int [] a = {-1,0,12,3,555,1,4,16,17,1,1024,2048,65535};
        for (int i = 0;i<a.length;i++){
            System.out.println("a["+i+"]="+a[i]+" bigNumberBeforeLog"+a[i]+" = "+gbl.getBigNum(a[i]));
        }
    }
}
