/**
 * FileName: Wind
 * @author:   Code
 * Date:     2019/4/24 14:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.interfaces.AbstractTest;

public class Wind extends Instrument {

    private int i = 1;

    @Override
    public void print() {
        System.out.println("Wind" + i );
    }

    Wind(){

    }

    public static void main(String[] args) {
        new Wind().print();
    }

}
