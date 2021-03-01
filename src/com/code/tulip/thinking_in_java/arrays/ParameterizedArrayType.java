/**
 * FileName: ParameterizedArrayType
 * @author:   Code
 * Date:     2019/5/8 22:23
 * Description: 参数化数组本身的类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.arrays;

import java.util.ArrayList;
import java.util.List;

class ClassParameter<T> {
    public T[] f(T[] arg) { //参数化方法
        return arg;
       // return new T[2]; // 无法创建泛型数组
    }
}

public class ParameterizedArrayType {
    public static void main(String[] args) {
        String[] f = new ClassParameter<String>().f(args);
        // 泛型数组编译器会报错
//        ClassParameter<String>[] a = new ClassParameter<String>[2];

        List<String>[] ls; //可以创建这种引用，但是无法使用new初始化
        List[] li = new List[5];
        ls = (List<String>[]) li; // 不会报错
        ls[0] = new ArrayList<String>();
        // ls[1] = new ArrayList<Integer>(); //泛型确实起作用了，会爆粗
        Object[] o = ls; // 这也是对的
        o[1] = new ArrayList<Integer>();
        //
        List<ClassParameter>[] list = (List<ClassParameter>[]) new ArrayList[2];
    }


}
