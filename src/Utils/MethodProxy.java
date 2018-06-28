package Utils;

import com.sun.org.apache.xml.internal.serializer.Method;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/28 17:40
 * @desc： 利用反射调用指定类的方法
 */
public class MethodProxy {
    public  static void run(String className,String methodName,Object ... args){
        try {
            Class<?> claz =  Class.forName(className);
            Object obj = claz.newInstance();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
