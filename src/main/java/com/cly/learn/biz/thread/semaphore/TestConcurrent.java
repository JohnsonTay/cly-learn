/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * linying@yiji.com 2017/2/8 16:55 创建
 *
 */
package com.cly.learn.biz.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linying@yiji.com
 */
public class TestConcurrent {

    public static void main(String args[]){
        Basket basket = new Basket();
        //生产者
        Producer p1 = new Producer(basket, "p1");
        Producer p2 = new Producer(basket, "p2");
        //消费者
        Consumer c1 = new Consumer(basket, "c1");

        //线程池管理
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(c1);
        pool.execute(p1);
        pool.execute(p2);
    }

}
