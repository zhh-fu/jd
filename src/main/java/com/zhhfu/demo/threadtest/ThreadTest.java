package com.zhhfu.demo.threadtest;

import java.util.concurrent.*;

/**
 * @author ：fuzhihang5
 * @date ：Created in 2020/6/28 17:34
 * @email ：fuzhihang5@jd.com
 * @description：：多线程测试类
 */
public class ThreadTest {
    /**
     * @param  args
     * @return void
     * @author fuzhihang5
     * @date   2020/6/28 18:30
     */
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3,5,10,
                TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(1),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i=0;i<10;i++){
            executorService.execute(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + ":" + "执行任务");
                    }
            );
            //System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    /**
     * @param  i
     * @param  j
     * @return java.lang.String
     * @author fuzhihang5
     * @date   2020/6/28 18:29
     */

    public String test(int i, int j){

        return "this is a test";
    }
}
