/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * linying@yiji.com 2017/2/8 16:27 创建
 *
 */
package com.cly.learn.biz.thread.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author linying@yiji.com
 */
public class Basket {
    private List bascket =new ArrayList(10);
    Semaphore mutex = new Semaphore(1);
    Semaphore isFull = new Semaphore(10);

    Semaphore isEmpty = new Semaphore(0);

    public void put(Apple app) throws InterruptedException{
        //大于0，就放行
        //acquire，就是减操作，如果小于0，就阻塞
        //release，就是加操作，如果大于0，就不会被阻塞
        isFull. acquire();
        try{
            mutex. acquire();
            bascket.add( app);
        }
        finally{
            mutex.release();
            isEmpty.release();
        }
    }

    public Apple take() throws InterruptedException{
        Apple app;
        isEmpty. acquire();
        try{
            mutex. acquire();
            app= (Apple) bascket.remove(0);
        }
        finally{
            mutex.release();
            isFull.release();
        }
        return app ;
    }
}
