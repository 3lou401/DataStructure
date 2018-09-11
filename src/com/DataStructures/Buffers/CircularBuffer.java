package com.DataStructures.Buffers;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Note : http://www.360doc.com/content/17/0219/08/478627_630209821.shtml
 * @Author: leaderHoo
 * @Date: 2018/8/14 22:58
 * @desc : 环形缓冲区
 *        环形缓冲区一般有一个读指针和一个写指针，
 *  在网络IO线程中，我们会为每一个连接都准备一个环形缓冲区，用于临时存放接收到的数据，以应付半包及粘包的情况
 */
public class CircularBuffer {

    //数据结构

    private char [] _buffer;

    private final int _buffer_size;

    private int _write_index = 0;

    private int _read_index = 0 ;

    private AtomicInteger _readable_data = new AtomicInteger(0);

    public CircularBuffer(int buffer_size) {
        if(!IsPowerOfTwo(buffer_size)) {
            throw new IllegalArgumentException();
        }
        this._buffer_size = buffer_size;
        _buffer = new char[buffer_size];
    }

    // & 如果相对应位都是1，则结果为1
    // 判断一个数是否为2的次方数
    private boolean IsPowerOfTwo(int i) {
        return (i & (i - 1)) == 0;
    }

    private int getTrueIndex(int i) {
        return i % _buffer_size;
    }


    public Character readOutChar (){
        Character result = null;

        //if we have data to read
        if (_readable_data.get() > 0){
          result = new Character(_buffer[getTrueIndex(_read_index)]);
          _readable_data.decrementAndGet();
          _read_index++ ;
        }
        return result;
    }

    public boolean writeToCharBuffer(char c) {
        boolean result = false;

        if (_readable_data.get() < _buffer_size){
            _buffer[getTrueIndex(_write_index)] = c;
            _readable_data.incrementAndGet();
            _write_index++;
            result = true;
        }

        return result;
    }

    //写线程
    private static class TestWriterWorker implements Runnable{

        String _alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";

        Random _random = new Random();

        CircularBuffer _buffer;

        public TestWriterWorker(CircularBuffer cb) {
            this._buffer = cb;
        }

        private char getRandomChar() {
            return _alphabet.charAt(_random.nextInt(_alphabet.length()));
        }


        @Override
        public void run() {
            while (!Thread.interrupted()){
                if (!_buffer.writeToCharBuffer(getRandomChar())){
                    Thread.yield();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                       return;
                    }
                }
            }
        }
    }
    //读线程
    private static class TestReadWorker implements Runnable{

        CircularBuffer _buffer;
        public TestReadWorker(CircularBuffer cb) {
            this._buffer = cb;
        }

        @Override
        public void run() {
            System.out.println("Printing Buffer:");

            while(!Thread.interrupted()) {
                Character c = _buffer.readOutChar();
                if(c != null) {
                    System.out.println(c.charValue());
                } else {
                    Thread.yield();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println();
                        return;
                    }
                }
            }
        }
    }

    //测试程序
    public static void main(String[] args) {
        int buffer_size = 2048;

        CircularBuffer cb = new CircularBuffer(buffer_size) ;

        Thread write_thread = new Thread(new TestWriterWorker(cb));
        Thread read_thread = new Thread(new TestReadWorker(cb));

        read_thread.start();
        write_thread.start();

        try {
            Thread.sleep(10000);
            write_thread.interrupt();
            read_thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
