package com.code.tulip.thinking_in_java.designPatterns.templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Classname ClientExtension
 * @Description 场景类扩展
 * @author code-tulip
 * @Date 2019/6/8 11:14 AM
 * @Version 1.0
 */
public class ClientExtension {

    public static void main(String[] args) throws IOException {
        System.out.println("------H1型号悍马------");
        System.out.println("H1型号是否需要喇叭声？0-不需要   1-需要");
        String type = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        HummerModelExtension1 hummerModelExtension1 = new HummerModelExtension1();
        if (type.equals("0")) {
            hummerModelExtension1.setAlarmFlag(false);
        }
        hummerModelExtension1.run();
        System.out.println("\n------H2型号悍马------");
        HummerModelExtension2 hummerModelExtension2 = new HummerModelExtension2();
        hummerModelExtension2.run();
    }
}
