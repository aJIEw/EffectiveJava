package chap10;

import java.util.concurrent.TimeUnit;

/**
 * 第66条：同步访问共享的可变数据。
 *
 * 为了在线程之间进行可靠的通信，也为了互斥访问，同步是必要的。
 * 当多个线程共享可变数据的时候，每个读或写数据的线程都必须执行同步。
 *
 * 安全发布对象引用主要有以下几种方法：
 * 1）保存在静态域中
 * 2）使用volatile
 * 3）使用final
 * 4）通过给域加锁
 * 5）放到并发的集合中(java.util.concurrent)
 */
public class Law66 {

    private static boolean sStopRequest;

    private static synchronized void requestStop() {
        sStopRequest = true;
    }

    private static synchronized boolean isStopRequest(){
        return sStopRequest;
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStopRequest()) {
                    i++;
                }
            }
        }).start();

        // 休眠一秒
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }

    /**
     * 另一种版本，使用volatile关键字使得修改可以被立即读取到。
     * */
    static class UsingVolatile{

        /**
         * 使用volatile不执行互斥访问，但是可以保证线程间的最近的修改可以马上被读取到
         * */
        private static volatile boolean sInnerStopRequested;

        public static void main(String[] args) throws InterruptedException {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (!sInnerStopRequested) {
                        i++;
                    }
                }
            }).start();

            TimeUnit.SECONDS.sleep(1);
            sInnerStopRequested = true;
        }
    }
}
