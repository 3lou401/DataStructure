package sort.hillSort;
import sort.base.Basetemplate;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * @Author: leaderHoo
 * @Date: 2018/6/22 10:19
 * @desc： 希尔排序:在数组中采用跳跃式分组的策略，通过某个增量将数组元素划分为若干组
 *          然后逐渐缩小增量。实际使用时，便可以避免出现直接插入排序移动元素过多的问题
 *      注意：希尔排序为不稳定性排序。因为相同的元素可能在各自的插入排序中移动
 * @Notify :
 *      1.希尔排序 ：核心就是保证间隔为N的数组有序，逐渐减小N
 *          while(h >=1) //最外层 减小
 *              for(int i =h;i<len;i++) //内层控制数据比较
 *                  for（int j =i ;j-h>0 && a[j] <a[j-h];i-=h）
 *           h/=2;
 *      2. 计算最开始h的时候； 可以直接用 len/2 或者 while(h < len/2) h=h*2+1;
 * @Notify2 :
 *      1. 希尔排序最核心的是 "h每次都是递减，i=h递增到a.lenght, 注意j（j 只要是大于h就会比较a[j]与a[j-h]，
 *              也就是 会对数组 a[i],a[i+h],a[i+2h],a[i+3h] ...a[j] 排序）"
 */

public class Shell extends Basetemplate {


    @Override
    public void sort(Comparable[] a) {
        //核心就是选择一个h
        int N = a.length;
        int h = N/2;
        while (h >=1){
            for (int i = h; i < a.length;i++){
                for (int j = i;j >h && less(a[j],a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            System.out.println(Arrays.toString(a));
            h/=2;
        }
    }

    //通过移动元素排序
    public void sortByMoveInsert(Comparable[] a) {
        //核心就是选择一个h
        int N = a.length;
        int h = N/2;
        while (h >=1){
            for (int i = h; i < a.length;i++){
                Comparable temp = a[i];
                int j = i;
                for (;j >h && less(temp,a[j]);j-=h){
                    a[j] = a[j-h];
                }
                a[j] = temp;
            }
            h/=2;
        }
    }



    public static void main(String []args){
        Integer []arr ={1,4,2,7,9,8,3,4};
        Shell shell = new Shell();
        shell.sort(arr);
    }

}