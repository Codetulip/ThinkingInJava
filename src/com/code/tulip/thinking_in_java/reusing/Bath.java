/**
 * FileName: Bath
 * @author:   Code
 * Date:     2019/4/22 15:51
 * Description: 组合
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.reusing;

// 初始化的四种方法：1、定义的位置初始化；2、构造器中初始化；3、使用的时候初始化；4、实例初始化
class Soap {

    Soap() {
    }

    @Override
    public String toString() {
        return "Soap Object";
    }
}

public class Bath {

    private Soap soap;

    Bath() {
    }

    @Override
    public String toString() {
        if (soap == null) {
            soap = new Soap(); // 惰性初始化和实例初始化
        }

        return " " + soap + "/r/n" + "Bath Object";
    }

    public static void main(String[] args) {
        Bath bath = new Bath();
        System.out.println(bath);
    }
}
