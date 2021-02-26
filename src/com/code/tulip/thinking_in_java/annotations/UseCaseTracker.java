package com.code.tulip.thinking_in_java.annotations;

import com.code.tulip.thinking_in_java.util.BinaryFile;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname UseCaseTracker
 * @Description 使用反射机制构建注解处理器
 * @author code-tulip
 * @Date 2019/5/26 10:28 PM
 * @Version 1.0
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class<?> c) {
        for (Method m : c.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case: " + uc.id() + " " + uc.description());
                useCases.remove(uc.id());
            }
        }
        for (int i : useCases) {
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, BinaryFile.class);
    }
}
