package com.code.tulip.thinking_in_java.designPatterns.prototype;

import java.util.ArrayList;

/**
 * @Classname Thing1
 * @Description 浅拷贝
 * @author code-tulip
 * @Date 2019/6/13 5:09 PM
 * @Version 1.0
 */
public class Thing implements Cloneable{

    // 定义一个私有变量
    private ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
//            thing.arrayList = (ArrayList<String>) this.arrayList.clone(); // 深拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    // 添加arrayList值
    public void setValue(String value) {
        this.arrayList.add(value);
    }

    // 取出整个arrayList
    public ArrayList<String> getValue() {
        return this.arrayList;
    }

    public static void main(String[] args) {
        // 产生一个对象
        Thing thing = new Thing();
        // 添加一个值
        thing.setValue("张三");
        // 拷贝一个对象
        Thing thingClone = thing.clone();
        thingClone.setValue("李四"); // 共用了一个List
        System.out.println(thing.getValue()); // 输出结果为[张三,李四]
    }
}
