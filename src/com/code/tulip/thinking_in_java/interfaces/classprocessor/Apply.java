/**
 * FileName: Apply
 * @author:   Code
 * Date:     2019/4/24 15:00
 * Description:策略模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.interfaces.classprocessor;


import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toUpperCase(); // 注意协变返回类型
    }
}

class Downcase extends Processor {
    @Override
    String process(Object input) {
        return ((String) input).toLowerCase(); // 注意协变返回类型
    }
}


class Splitter extends Processor {
    @Override
    String process(Object input) {
        return Arrays.toString(((String) input).split(" ")); // 协变返回类型
    }
}

public class Apply {

    public static void process(Processor p, Object s) {
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";

    // 策略模式，根据不同书的参数对象，得到不同的行为
    public static void main(String[] args) {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }

}
