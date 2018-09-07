package com.Concurrent;

/**
 * @Author: leaderHoo
 * @Date: 2018/9/3 17:54
 * @desc ：线程安全
 *
 * @apiNote : 当多个线程访问某个类时，不管运行时环境采用何种调度方式或者这些线程将如何交替执行，
 *      并且在主调代码中不需要任何额外的同步或协同，这个类都能表现出正确的行为，
 *      那么这个类就是线程安全的
 *
 * @Situation : 实现一个功能来统计网页访问量，你可能想到用count++ 来统计访问量
     *  但是这个自增操作不是线程安全的。count++ 可以分成三个操作：
     *
     * 获取变量当前值
     * 给获取的当前变量值+1
     * 写回新的值到变量
 * @method
 *      public final int getAndSet(int newValue)       //给AtomicInteger设置newValue并返回加oldValue
 *      public final boolean compareAndSet(int expect, int update)    //如果输入的值和期望值相等就set并返回true/false
 *      public final int getAndIncrement()     //对AtomicInteger原子的加1并返回当前自增前的value
 *      public final int getAndDecrement()   //对AtomicInteger原子的减1并返回自减之前的的value
 *      public final int getAndAdd(int delta)   //对AtomicInteger原子的加上delta值并返加之前的value
 *      public final int incrementAndGet()   //对AtomicInteger原子的加1并返回加1后的值
 *      public final int decrementAndGet()    //对AtomicInteger原子的减1并返回减1后的值
 *      public final int addAndGet(int delta)   //给AtomicInteger原子的加上指定的delta值并返回加后的值
 *
 * @apiNote  CAS ：乐观锁 compareandswap
 *          Unsafe 是做一些Java语言不允许但是又十分有用的事情，具体的实现都是native方法，
 *      AtomicInteger里调用的 Unsafe 方法 基于的是CPU 的 CAS指令来实现的。
 *      所以基于 CAS 的操作可认为是无阻塞的，一个线程的失败或挂起不会引起其它线程也失败或挂起。
 *      并且由于 CAS 操作是 CPU 原语，所以性能比较好
 * @apiNote  CAS 乐观锁的实现形式
 *
 */
public class ThreadSafe {

}
