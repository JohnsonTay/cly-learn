/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * linying@yiji.com 2017/2/7 19:46 创建
 *
 */
package com.cly.learn.biz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 只允许5个线程同时进入执行acquire()和release()之间的代码
 *
 * @author linying@yiji.com
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try{
                        // 获取许可
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 10000));
                        // 访问完后，释放 ，如果屏蔽下面的语句，则在控制台只能打印5条记录，之后线程一直阻塞
                        semp.release();
                    }catch (InterruptedException e){
                    }
                }
            };
            pool.execute(run);
        }
        // 退出线程池
        pool.shutdown();
    }
}
