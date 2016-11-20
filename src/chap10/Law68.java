package chap10;

/**
 * 第68条：Executor和Task优于线程。
 * <p>
 * 执行机制一般使用线程池，比如经常使用的Executors.newCachedThreadPool，大负载下使用的Executors.newFixedThreadPool，
 * 定时调度使用的ScheduledThreadPoolExecutor。
 * <p>
 * 工作单元使用的Task处理有Runnable外，还有Callable，它可以返回值，由ExecutorService执行。
 */
public class Law68 {
}
