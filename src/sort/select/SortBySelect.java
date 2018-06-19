package sort.select;


import java.util.Arrays;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/14 16:20
 */
public class SortBySelect {
    public void sortBySel(int []a){
        for (int i=0; i< a.length;i++){
            int min = i;//索引
            for (int j =i+1;j<a.length;j++){
                if (a[j] < a[min])
                    min=j;
            }
            swap(a[min],a[i]);
        }
    }
    //TODO 交换的时候，是传值调用，不可以直接调用
    private static void swap(int a,int b){
        int temp =a;
        a=b;
        b=temp;
    }
    //核心就是 ： 外层循环控制 每一个位置；内层循环 找 每一个位置对应的最小值
    public static void main(String[] args) {
        int [] a={1,3,5,2,4,9,6};
        for (int i=0; i< a.length;i++){
            int min = i;//索引
            for (int j =i+1;j<a.length;j++){
                if (a[j] < a[min])
                    min=j;
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        System.out.printf(""+Arrays.toString(a));
    }
}
