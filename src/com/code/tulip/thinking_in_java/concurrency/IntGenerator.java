package com.code.tulip.thinking_in_java.concurrency;

/**
 * @Classname IntGenerator
 * @Description
 * @author code-tulip
 * @Date 2019/5/28 12:58 PM
 * @Version 1.0
 */
public abstract class IntGenerator {

    // 原子性,volatile保持可视性
    private volatile boolean canceled = false;

    public abstract int next();

    // 允许对象被取消
    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
