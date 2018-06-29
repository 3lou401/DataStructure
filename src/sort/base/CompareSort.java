package sort.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/29 11:40
 * @desc: 比较各种排序算法的执行时间
 *        测试算法执行时间时，第一个问题：传入的数组长度是 new Integer[10000],但是可能 a[20]为null
 */
public class CompareSort {

    public static void main(String[] args) {
        Integer [] a = new Integer[900001];
        Integer [] b = new Integer[900001];

        for (int i = 900000;i >0 ;i--){
            int num = (int) (Math.random() * (9000)) + 1;
            a[i] = num;
            b[i] = num;
        }
//        String claz1 = "sort.select.Selection";
//        String func1 = "sort";
//        System.out.println("Selection spended time is "+  CalcTime.calcLastTime(claz1,func1,a));
//        String claz2 = "sort.insert.Insertion";
//        String func2 = "sort";
//        System.out.println("Insertion spended time is "+  CalcTime.calcLastTime(claz2,func2,b));
        String claz3 = "sort.hillSort.Shell";
        String func3 = "sort";
        System.out.println("Insertion spended time is "+  CalcTime.calcLastTime(claz3,func3,a));

    }
}
