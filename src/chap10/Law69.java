package chap10;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * 第70条：并发工具优先于wait和notify
 * <p>
 * 1）应该优先使用并发集合，而不是使用外部同步的集合。比如使用ConcurrentHashMap而不是Collections.synchronizedMap
 * 2）有些集合接口可以进行阻塞操作，会一直等待（阻塞）直达可以成功执行为止。比如BlockingQueue
 * 3）同步器是一些使线程能够等待另一个线程，允许他们协调动作。比如CountDownLatch和Semaphore，不常用的CyclicBarrier和Exchanger
 *
 * 如果必须使用wait和notify，请确保：
 * 1）始终是利用标准的模式从while内部循环调用wait
 * 2）优先使用notifyAll而不是notify
 * 3）如果使用notify，必须确保程序的活性。
 */
public class Law69 {

    boolean conditionDoesNotHold;

    /**
     * 始终应该使用while循环模式来调用wait方法，永远不要在循环之外调用wait方法
     * */
    public void useWaitInWhile(Object obj) throws InterruptedException {
        synchronized (obj) {
            while (conditionDoesNotHold) {
                // 释放锁
                obj.wait();
            }
        }
    }

    /**
     * 用三个倒计数锁存器控制线程执行任务，返回执行的时间。
     * */
    public static long time(Executor executor, int concurrency, final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        // 执行1次
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 准备
                    ready.countDown();
                    try {
                        // 等待准备好
                        start.await();
                        // 执行操作
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        // 一次执行完毕
                        done.countDown();
                    }
                }
            });
        }
        // 等待所有线程准备好
        ready.await();
        // 对于间歇式的定时，应该优先使用System.nanoTime()而不是System.currentTimeMills()
        long startNanos = System.nanoTime();
        // 工作线程开始执行
        start.countDown();
        // 等待所有线程执行完毕
        done.await();
        // 返回执行时间
        return System.nanoTime() - startNanos;
    }
}
