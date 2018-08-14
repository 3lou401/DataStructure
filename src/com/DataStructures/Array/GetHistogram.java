package com.DataStructures.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/19 23:21
 * @Desc: 获取一个数组：每一个节点的的值为i在数组中出现的次数 (统计用的直方图)
 */
public class GetHistogram {
    /**
     * @param [array, M]
     * @return int[]
     * @author leaderHoo
     * @createTime 2018/6/19 23:23
     * @desc
     */
    public int[] getArray(int[] a, int M) {
        if (a == null || a.length < 1)
            return null;
        int[] b = new int[M];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.isEmpty() && map.containsKey(Integer.valueOf(a[i]))) {
                map.put(Integer.valueOf(a[i]), (map.get(Integer.valueOf(a[i])) + 1));
            } else {
                map.put(Integer.valueOf(a[i]), 1);
            }
        }
        for (int i = 0; i < M; i++) {
            if (map.containsKey(Integer.valueOf(a[i]))) {
                b[i] = map.get(Integer.valueOf(a[i]));
            } else {
                b[i] = 0;
            }
        }
        return b;
    }

    //存在限制条件 ：a[n]取值范围 [1,n]，所以才可以。
    public static void main(String[] args) {
      /*  int []a = {1,1,2,1,3,2,5,2,5,2,5,0,12,55};
        GetHistogram gh = new GetHistogram();
        System.out.printf(Arrays.toString(gh.getArray(a,5)));*/
        int n = 6;
        int[] a = new int[]{6, 2, 4, 1, 2, 5};
        int i = 0;

        //采用while循环
        while (i < n) {
            //由于元素取值范围为[1,N]，因此，可以将（当前元素值-1）作为下标值，找到相应位置处的元素，
            // 将其存储的值作为-times，因为原来存储值都为正值，为防止混淆，用负值存储
            int temp = a[i] - 1; //表示当前值对应下标
            if (temp < 0) { //表示该元素已经处理过了，跳过
                i++;
                continue;
            } else if (a[temp] > 0) {//第一次处理一个值
                a[i] = a[temp];//暂存新元素
                a[temp] = -1;
            } else {//已经不是第一次处理该值了

                a[i] = 0; //没有新的元素要处理，置0
                a[temp]--;
            }
        }

        for (int j = 0; j < n; ++j) {
            System.out.print(j + 1 + " , " + -a[j] + "\t");
        }
    }
}
