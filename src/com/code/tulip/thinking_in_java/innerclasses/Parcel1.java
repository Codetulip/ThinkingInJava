/**
 * FileName: Parcel1
 * @author:   Code
 * Date:     2019/4/24 21:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.innerclasses;

public class Parcel1 {

    private int j = 0;

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereto) {
            label = whereto;
        }

        String readLabel() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());

    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        Destination d = p.new Destination("ss"); // 内部类创建方式（本类中使用方法）
        // Parcel1.Destination d = p.new Destination("ss"); // 内部类创建方式（外部类使用方法）
        p.ship("tasmania");
    }
}
