package BehavioralPatterns;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个计数器，初始值为 3（有3个工作线程）
        int workerCount = 3;
        CountDownLatch latch = new CountDownLatch(workerCount);

        System.out.println("主线程：启动工作线程...");

        // 创建并启动3个工作线程
        for (int i = 1; i <= workerCount; i++) {
            new Thread(new WorkerThread(latch, i), "Worker-" + i).start();
        }

        System.out.println("主线程：等待所有工作线程完成...");

        // 主线程在此等待，直到计数器归零（即所有工作线程都调用了countDown）
        latch.await();

        System.out.println("主线程：所有工作线程已完成，继续执行后续任务...");
    }

    // 工作线程类
    static class WorkerThread implements Runnable {
        private final CountDownLatch latch;
        private final int workerId;

        public WorkerThread(CountDownLatch latch, int workerId) {
            this.latch = latch;
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "：开始工作...");

                // 模拟工作耗时
                TimeUnit.SECONDS.sleep(workerId * 1L); // 每个线程工作时间不同

                System.out.println(Thread.currentThread().getName() + "：工作完成！");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + "：被中断！");
            } finally {
                // 非常重要！无论线程正常完成还是异常，都必须调用countDown
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + "：调用countDown()，当前计数：" + latch.getCount());
            }
        }
    }
}