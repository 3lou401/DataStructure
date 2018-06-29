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
        Integer [] a = new Integer[90001];
        Integer [] b = new Integer[90001];
        for (int i = 90000;i >0 ;i--){
            a[i] = 90000-i;
            b[i] = 90000;
        }
        String claz1 = "sort.select.Selection";
        String func1 = "sort";
        System.out.println("Selection spended time is "+  CalcTime.calcLastTime(claz1,func1,a));
        String claz2 = "sort.insert.Insertion";
        String func2 = "sort";
        System.out.println("Insertion spended time is "+  CalcTime.calcLastTime(claz2,func2,b));

    }
}
