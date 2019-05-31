/**
 * FileName: GenericClassReferences
 * Author:   Code
 * Date:     2019/5/7 16:32
 * Description: 泛化的class引用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.typeinfo;

public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class;
        intClass = Integer.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;
        intClass = double.class; // 允许
//        genericIntClass = double.class; // 不允许

        // 如果想放松点泛型的限制
//        Class<Number> genericNumberClass = int.class;
        // 虽然Integer继承自Number，但是这样并不可以
        Class<?> intClass2 = int.class;
        intClass2 = double.class;

        // 因此通配符?可以解决放松泛型限制的问题
        Class<? extends Number> intClass3 = int.class;
        intClass3 = double.class;
        intClass3 = Number.class;
    }
}
