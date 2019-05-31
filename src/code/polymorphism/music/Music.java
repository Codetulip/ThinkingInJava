/**
 * FileName: Music
 * Author:   Code
 * Date:     2019/4/23 22:30
 * Description: 音乐
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.polymorphism.music;

public class Music {

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        // wind.xixi(); // private方法，在其他类中即使生成了对象，也无法调用
        tune(wind); // upcasting 将方法调用同一个方法体关联起来的称为绑定
        wind.hello();
    }

}
