package com.zhhfu.demo.example.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreExample3 {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i=0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    //尝试获取一个许可，如果获取到则执行
                    //获取不到则不执行
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){
                        test(threadNum);
                        semaphore.release();
                    }
                } catch (Exception ex){
                    log.info("exception",ex);
                }
            });
        }
        log.info("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        //Thread.sleep(200);
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
