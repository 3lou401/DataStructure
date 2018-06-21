package com.recursive;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/21 09:54
 */
public class JavaMathUseCase {
    // 递归求出n的阶乘
    public static long factorial(int n){
        //0和1的阶乘
        if (n==0|| n==1)
            return 1;
        return n*factorial(n-1);
    }

    //求出n!的对数
    public static double lonN(int n){
        if (n < 0)
            return -1;
        return Math.log(factorial(n));
    }

    public static void main(String[] args) {
        System.out.printf("3的ln(n!)是"+lonN(3));
    }
}
