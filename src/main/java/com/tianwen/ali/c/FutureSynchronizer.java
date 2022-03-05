package com.tianwen.ali.c;

import java.util.concurrent.*;

/**
 * wangjq
 * 2021年05月24日  21:26
 */

/*题目2
        在分布式环境下，我们有时为了提升系统吞吐量，会采用异步处理，同步轮训结果的机制.要求
        使用JUC框架写出一个同步受理，异步处理，再同步多次轮训结果的代码，轮训次数及间隔为:200ms,300ms,500ms,1000ms，整个轮训的超时时间为3s.*/
public class FutureSynchronizer {

    private static ThreadPoolExecutor executors = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100000));

    public static void main(String args[]) throws Exception{
        // 解析参数
        String key = "key";
        String value = "value";
        Task task = new Task(key,value);
        // 开始处理
        FutureSynchronizer futureSynchronizer = new FutureSynchronizer();
        futureSynchronizer.process(task);
    }

    /**
     * 具体的处理过程
     */
    public String process(Task task) {
        Future<String> future = executors.submit(new TaskCallable(task));
        String result = "";
        try {
            for (int i = 0; i < 5; i++) {
                if (future.isDone()) {
                    return future.get();
                } else if (i == 0) {
                    result = future.get(200, TimeUnit.MILLISECONDS);
                } else if (i == 1) {
                    result = future.get(300, TimeUnit.MILLISECONDS);
                } else if (i == 2) {
                    result = future.get(500, TimeUnit.MILLISECONDS);
                } else if (i == 3) {
                    result = future.get(1000, TimeUnit.MILLISECONDS);
                } else {
                    result = future.get(1000, TimeUnit.MILLISECONDS);
                }
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return result;
    }
}

class TaskCallable implements Callable<String> {

    private Task task;

    public TaskCallable(Task task) {
        this.task = task;
    }

    @Override
    public String call() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task.execute();
    }
}


/**
 * 待执行任务，是个辅助类，不用修改
 */
class Task{

    /** 任务key */
    private String key;

    /** 任务加工的数据 */
    private String value;

    /**
     * 默认构造函数
     */
    public Task(){
    }

    /**
     * 构造函数
     */
    public Task(String key, String value){
        this.key = key;
        this.value = value;
    }

    /**
     * 任务执行
     */
    public String execute(){
        String result = value;
//        Cache. put(String key, String result);
        return result;
    }
}

/**
 * 缓存工具，是个辅助类，不用修改
 */
/*
public class Cache{

    */
/**
     * 写入缓存
     *//*

    public static boolean put(String key, String value){
        //
    }

    */
/**
     * 从缓存读
     *//*

    public static value get(String key){

    }
}*/
