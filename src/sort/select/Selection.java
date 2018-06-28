package sort.select;


import sort.base.Basetemplate;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/14 16:20
 */
public class Selection extends Basetemplate {

    //核心就是:外层循环控制 每一个位置；内层循环 找 每一个位置对应的最小值
    @Override
    public void sort(Comparable[] a) {
        if (a == null || a.length <= 1)
            return ;
        //最小的位置一定是从0开始
        for (int i = 0; i < a.length;i++){
            Comparable temp = a[i];
            int min = i;
            for (int j =i+1; j<a.length;j++){
                if (less(a[j],temp)){
                    min = j;
                }
            }
            exch(a,min,i);
        }
    }


    public static void main(String[] args) {
        Selection sel = new Selection();
        Integer [] a = {1,3,2,1123,23,56,29,9,-2};
        sel.sort(a);
        show(a);
    }
}
