package com.code.tulip.thinking_in_java.util;

/**
 * @Classname Generator
 * @Description
 * @author code-tulip
 * @Date 2019/5/30 1:10 PM
 * @Version 1.0
 */
public class Generator<T> {

    Class<T> c;

    public Generator(Class<T> c) {
        this.c = c;
    }

    public T next() throws Exception{
        return (T)c.newInstance();
    }

}
