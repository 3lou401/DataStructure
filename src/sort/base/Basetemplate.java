package sort.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/28 15:41
 * @desc： 排序需要的基础模板
 */
public abstract class Basetemplate {


    public abstract void sort(Comparable[] a);
    
   public static boolean less(Comparable a, Comparable b){
       return a.compareTo(b) < 0;
   }
   //交换数组元素
   public static void exch(Comparable []a ,  int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
   }
   //判断是否升序有序
   public static boolean isSorted(Comparable [] a){
       if (a.length < 0)
           return false;
       if (a.length == 1)
           return true;
       for (int i = 1;i < a.length;i++){
           if (less(a[i],a[i-1]))
               return false;
       }
       return true;
   }

   public static void show(Comparable [] a){
       System.out.printf(Arrays.toString(a));
   }

    public static void main(String[] args) {
       String []a = {"a","ss"};
        // System.out.printf("array is sort - "+ isSorted(a));
        long time = CalcTime.calcLastTime("sort.base.Basetemplate","test");
        System.out.printf("time == "+ time);
    }


}
