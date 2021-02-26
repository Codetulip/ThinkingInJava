/**
 * FileName: Wind
 * @author:   Code
 * Date:     2019/4/23 22:29
 * Description: 管乐
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.polymorphism.music;

public class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("wind.play() " + n);
    }

    private void xixi(){}

    public static void main(String[] args) {
        Wind wind = new Wind();
        wind.xixi();  // private只能在本类中使用
    }

}
