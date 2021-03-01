/**
 * FileName: Instrument
 * @author:   Code
 * Date:     2019/4/24 14:34
 * Description: 和Wind类测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.interfaces.AbstractTest;

public abstract class Instrument {

    public abstract void print();

    Instrument() {
        print();
    }

    // 抽象类中的方法可以是静态的，静态的方法必须有方法体
    public static void hello1(){}

}
