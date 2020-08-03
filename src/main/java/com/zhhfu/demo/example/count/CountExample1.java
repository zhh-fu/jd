package com.zhhfu.demo.example.count;

import com.zhhfu.demo.annotations.UnSafeThread;
import lombok.extern.slf4j.Slf4j;


import java.util.concurrent.*;

@Slf4j
@UnSafeThread
public class CountExample1 {
    //请求总数
    public static int clientTotal = 5000;
    //同时执行并发的线程数
    public static int threadTotal = 200;
    public static int count = 0;

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            executorService.execute(() ->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception ex){
                    log.error("Exception" + ex);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}" ,count);
    }

    private static void add(){
        count++;
    }
}
