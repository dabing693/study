package com.lyh.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TtlSample1 {

    static ThreadLocal<String> TTL = new TransmittableThreadLocal<>();
    static ThreadLocal<String> tl=new ThreadLocal<>();

    public static void main(String[] args) throws Exception {

        System.out.println(810_000L==810000);
        new Thread(() -> {
            // 在父线程中设置变量
            TTL.set("throwable");
            //tl.set("throwable-tl"); //java.lang.NullPointerException
            new Thread(() -> {
                tl.set("throwable-tl");
                methodFrame();
            }).start();
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        // 额外的处理，生成修饰了的对象executorService
        executorService = TtlExecutors.getTtlExecutorService(executorService);
        TransmittableThreadLocal<String> context = new TransmittableThreadLocal<String>();

        ExecutorService finalExecutorService = executorService;
        new Thread(() -> {
            context.set("value-set-in-parent");
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println(context.get());
                }
            };
            finalExecutorService.submit(task);
            try {
                TimeUnit.SECONDS.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void methodFrame() {
        System.out.println(TTL.get());
        System.out.println(tl.get());
    }
}
