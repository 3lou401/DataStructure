package sort.base;

import Utils.MethodProxy;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/28 16:52
 * @desc： 计算程序运行时间
 */
public class CalcTime {

    //查看一个算法执行时间
    public static long calcLastTime(String func,String method,Object ... arg){
        long starTime=System.currentTimeMillis();
        MethodProxy.run(func,method,arg);
        long endTime=System.currentTimeMillis();
        return  endTime-starTime;
    }
}
