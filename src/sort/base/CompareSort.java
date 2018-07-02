package sort.base;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/29 11:40
 * @desc: 比较各种排序算法的执行时间
 *        测试算法执行时间时，第一个问题：传入的数组长度是 new Integer[10000],但是可能 a[20]为null
 */
public class CompareSort {

    public static void main(String[] args) {
        Integer [] a = new Integer[90000];
        Integer [] b = new Integer[90000];
        Integer [] c = new Integer[90000];

        for (int i = 0;i < 90000 ;i++){
            int num = (int) (Math.random() * (9000)) + 1;
            a[i] = num;
            b[i] = num;
            c[i] = num;
        }
//        for (int i=0;i<40000;i++){
//            a[i] = 9000;
//            b[i] = 9000;
//        }
        String func = "sort";
//        String claz1 = "sort.select.Selection";
//        System.out.println("Selection spended time is "+  CalcTime.calcLastTime(claz1,func,a));
//        String claz2 = "sort.insert.Insertion";
//        System.out.println("Insertion spended time is "+  CalcTime.calcLastTime(claz2,func,b));

//        String claz3 = "sort.hillSort.Shell";
//        System.out.println("Shell spended time is "+  CalcTime.calcLastTime(claz3,func,c));
//        System.out.println("Shell spended Array is "+ Arrays.toString(c));

        String claz4 = "sort.quickSort.Quick";
        System.out.println("Quick spended time is "+  CalcTime.calcLastTime(claz4,func,a));

    }
}
