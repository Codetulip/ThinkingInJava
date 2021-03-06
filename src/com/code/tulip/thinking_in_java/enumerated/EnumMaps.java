package com.code.tulip.thinking_in_java.enumerated;

import java.util.EnumMap;
import java.util.Map;

/**
 * @Classname EnumMap
 * @Description
 * @author code-tulip
 * @Date 2019/5/24 12:23 AM
 * @Version 1.0
 */

interface Command {
    void action();
}

public class EnumMaps {

    public static void main(String[] args) {
        // EnumMap和其他的Map没多大区别，只是要求键必须来自一个enum，和EnumSet创建时一样需要指定enum的来源
        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        enumMap.put(AlarmPoints.KITCHEN, new Command() {
            @Override
            public void action() {
                System.out.println("Kitchen fire);");
            }
        });
        enumMap.put(AlarmPoints.BATHROOM, new Command() {
            @Override
            public void action() {
                System.out.println("Bathroom alert");
            }
        });
        for (Map.Entry<AlarmPoints, Command> m : enumMap.entrySet()) {
            System.out.print(m.getKey() +  " : ");
            m.getValue().action();
        }

        try {
            enumMap.get(AlarmPoints.UTILITY).action(); // 如果EnumMap中不包含某个enum常量，会出现NullPointerException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
