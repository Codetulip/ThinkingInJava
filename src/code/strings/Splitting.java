/**
 * FileName: Splitting
 * Author:   Code
 * Date:     2019/5/6 20:01
 * Description: split、replace方法可以使用正则表达式进行分割
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.strings;

import java.util.Arrays;

public class Splitting {

    public Splitting(){}

    public Splitting(int i){}

    public Splitting(float f){}


    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down dffs the mightiest tree in the forest..." +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(
                Arrays.toString(knights.split(regex))
                // 自身没有重载toString的方法，只有Object.toString()
//                knights.split(regex).toString()
        );
    }

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");

        // 并不是所有replace**()方法都能接受正则表达式，有的需要具体被替换的sting
        // 比如:replace(char oldChar, char newChar)
        System.out.println(knights.replace("found", "haha"));
        // 替换f开头的单词
        System.out.println(knights.replaceFirst("f\\w+", "located"));
        // 替换三个单词
        System.out.println(knights.replaceAll("shrubbery|tree|herring", "banana"));
    }
}
