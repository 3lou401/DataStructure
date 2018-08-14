package com.Algorithm.sort.base;

import com.Utils.MethodProxy;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/28 16:52
 * @desc： 计算程序运行时间
 */
public class CalcTime {

    //查看一个算法执行时间
    public static long calcLastTime(String className,String method,Comparable [] arg){
        long starTime=System.currentTimeMillis();
        MethodProxy.run(className,method,arg);
        long endTime=System.currentTimeMillis();
        return  endTime-starTime;
    }
}
