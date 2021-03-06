package com.code.tulip.thinking_in_java.designPatterns.command;

/**
 * @Classname Command
 * @Description 抽象的Command
 * @author code-tulip
 * @Date 2019/7/3 9:02 PM
 * @Version 1.0
 */
public abstract class Command {

    // 每个命令都必须有个执行命令的方法
    public abstract void execute();
}
