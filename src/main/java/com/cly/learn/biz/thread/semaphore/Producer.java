/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * linying@yiji.com 2017/2/8 16:29 创建
 *
 */
package com.cly.learn.biz.thread.semaphore;

import java.util.Random;

/**
 * @author linying@yiji.com
 */
public class Producer implements Runnable{
    private Basket bascket ;
    private String name ;
    public Producer(Basket bascket ,String name ){
        this .bascket =bascket ;
        this .name =name ;
    }
    public void run(){

        while (true ){
            try {
                System.out.println(name +" produce.." );
                bascket.put( new Apple( "name" +new Random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread. sleep(1000);
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }

        }

    }


}
