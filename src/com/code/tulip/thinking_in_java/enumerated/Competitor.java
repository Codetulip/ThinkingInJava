package com.code.tulip.thinking_in_java.enumerated;

/**
 * @Interfacename Competitor
 * @Description
 * @author code-tulip
 * @Date 2019/5/24 11:31 PM
 * @Version 1.0
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
