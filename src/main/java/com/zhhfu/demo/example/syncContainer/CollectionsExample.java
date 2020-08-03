package com.zhhfu.demo.example.syncContainer;

import com.zhhfu.demo.annotations.UnSafeThread;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@UnSafeThread
public class CollectionsExample {
    //请求总数
    public static int clientTotal = 5000;
    //同时执行并发的线程数
    public static int threadTotal = 200;
    private static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws Exception {
        list =  Collections.synchronizedList(list);
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            final int count = i;
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (Exception ex){
                    log.error("Exception" + ex);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}" ,list.size());
    }

    private static void add(int i){
        list.add(i);
    }
}
