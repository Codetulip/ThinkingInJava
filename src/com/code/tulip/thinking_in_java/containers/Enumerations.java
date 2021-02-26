/**
 * FileName: Enumerations
 * @author:   Code
 * Date:     2019/5/15 14:38
 * Description: Vector和Enumeration
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.*;

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER
}

public class Enumerations {

    public static void main(String[] args) {
        Vector<String> v = new Vector<String>(Utilities.list);
        Enumeration<String> e = v.elements();// 以前的迭代器
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + ", ");
        }
        e = Collections.enumeration(new ArrayList<String>());

        //Java1.0/1.1中Stack继承Vector
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        System.out.println("stack = " + stack);
        stack.addElement("the last line");
        System.out.println("element 5 = " + stack.elementAt(5));
        System.out.println("poping elements:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
