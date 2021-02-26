/**
 * FileName: ShowMethods
 * @author:   Code
 * Date:     2019/5/8 12:07
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ShowMethods {

    private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n"
            + "To show all methods in class or:\n" + "ShowMethods qualified.class.name word\n"
            + "To search for methods involving 'word'";

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        int lines = 0;
        try {
            Class<?> c = Class.forName("com.code.tulip.thinking_in_java.strings.Splitting");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors(); // 包含默认构造器，即使没有定义构造器
//            Constructor constructor = c.getConstructor(); // 获取默认构造器
//            Constructor constructor1 = c.getConstructor(int.class); // 获取参数为Int的构造器
//            Constructor constructor2 = c.getConstructor(float.class); // 获取参数为float的构造器
//            System.out.println(constructor + " : " + constructor1 + " : " + constructor2 );
            System.out.println(Arrays.toString(methods));
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor ctor : ctors) {
                System.out.println(p.matcher(ctor.toString()).replaceAll(""));
            }
            lines = methods.length + ctors.length;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
