/**
 * FileName: StringHashCode
 * Author:   Code
 * Date:     2019/5/12 20:01
 * Description: String的HashCode是基于内容的
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;

public class StringHashCode {

    public static void main(String[] args) {
        String a = new String("hha");
        String b = new String("hha");
        // 如果程序中多个String对象的内容为相同的字符串，它们都映射到同一块内存区域
        // 虽然它们彼此是相互独立的，但是hashCode()产生的结果相同
        // String.hashCode()是基于内容的
        System.out.println(a.hashCode() + "--" + b.hashCode());
    }
}
