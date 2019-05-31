/**
 * FileName: CompType
 * Author:   Code
 * Date:     2019/5/9 12:27
 * Description: 数组元素的比较
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// 也可以自己实现Comparator接口放入Arrays.sort(数组，comparator)
class CompTypeComparator implements Comparator<CompType> {
    @Override
    public int compare(CompType o1, CompType o2) {
        return ( o1.j < o2.j ? -1 : (o1.j > o2.j ? 1 : 0));
    }
}

public class CompType implements Comparable<CompType> {

    int i;

    int j;

    private static int count = 1;

    public String toString() {
        String result = "[i = " + i + ", j = " + j + "]";
        if (count++ % 3 == 0)
            result += "\n";
        return result;
    }

    @Override
    public int compareTo(CompType o) { // 指定泛型类型与参数类型相同
        return ( i < o.i ? -1 : (i > o.i ? 1 : 0));
        // 当前对象小于参数返回负值，等于返回0，大于返回正值
    }

    public static void main(String[] args) {
        CompType[] a = new CompType[10];
        Random rand = new Random(47);
        for (int i = 0; i < a.length; i++) {
            a[i] = new CompType();
        }
        for (CompType c : a) {
            c.i = rand.nextInt(100);
            c.j = rand.nextInt(100);
        }
        // Arrays.binarySearch()
        int[] ints = {1, 5, 3, 4};
        int location = Arrays.binarySearch(ints, 3);
        //若找到了，返回等于或大于0的值（表示其位置），若为找到返回负值，其绝对值-1表示应该插入的位置
        System.out.println("key = 3 " + "location = " + location);
        System.out.println("before sorting :");
        System.out.println(Arrays.toString(a));
        System.out.println("after sorting with i :");
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("after sorting with j");
        Arrays.sort(a, new CompTypeComparator());
        System.out.println(Arrays.toString(a));
    }
}
