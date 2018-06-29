package Utils;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: leaderHoo
 * @Date: 2018/6/28 17:40
 * @desc： 利用反射调用指定类的方法
 */
public class MethodProxy {
    /**   
    * @author leaderHoo
    * @date 2018/6/29 15:18
    * @param [className, methodName, args]
    * @Desc  修改BUG,第一：传入参数时，改为具体类型 ，然后getMethod需要制定参数类型，Comparable[].class
     *              第二： 调用方法时，传入参数是数组的情况下，需要规定为Object,否则会认为是多个参数
    * @return void
    */ 
    public  static void run(String className,String methodName,Comparable [] args){
        try {
            Class<?> claz =  Class.forName(className);
            Object obj = claz.newInstance();
            Method method = claz.getMethod(methodName,Comparable[].class);
            method.invoke(obj,(Object) args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
             e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
