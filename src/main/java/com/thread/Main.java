package com.thread;

import com.thread.Reader;

public class Main {

    public static void main(String[] args) {

        Reader reader=new Reader();

        Thread t1=new Thread(reader,"t1");
        Thread t2=new Thread(reader,"t2");
        Thread t3=new Thread(reader,"t3");
        Thread t4=new Thread(reader,"t4");
        Thread t5=new Thread(reader,"t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
