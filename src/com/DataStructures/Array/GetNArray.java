package com.DataStructures.Array;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/21 10:29
 * @desc: 生成N*N数组；a[i][j]当且仅当ij互斥时，结果为true
 */
public class GetNArray {
    //判断该两个数是否互质 :如果两个数不互质，大数%小数一定不为0
    public  static Boolean arePremeNumbers(int a,int b){
        //让a作为最大数
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        int c;
        while (( c=(a % b) )!= 0){
            a = b;
            b = c;
        }
        if (b == 1)
            return true;
        return false;
    }

    public boolean [][] getArray(int N){
        boolean [][] res = new boolean[N][N];
        
        return res;
    }

    public static void main(String[] args) {
        System.out.printf("3与6是否互斥"+arePremeNumbers(3,6));
        System.out.printf("3与4是否互斥"+arePremeNumbers(3,4));
    }
}
