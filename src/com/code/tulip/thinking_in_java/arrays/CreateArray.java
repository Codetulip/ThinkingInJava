/**
 * FileName: CreateArray
 * @author:   Code
 * Date:     2019/5/8 21:21
 * Description: 创建数组的几种方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.arrays;

import java.util.Arrays;

public class CreateArray {

    public static void main(String[] args) {
        Integer[] i = new Integer[5]; //创建时就需要指定数组大小
        System.out.println("i : " + Arrays.toString(i));
        i[1] = 12;
        System.out.println("i : " + Arrays.toString(i));
        Integer[] m = new Integer[]{1,2};//这里不需在[]里面指定大小，因为后面{}就说明了大小
        System.out.println("m : " + Arrays.toString(m));
        int k = m[1];
        Integer[] n = {1, 2, 3};
        System.out.println("n : " + Arrays.toString(n));

        // 多维数组
        int[][] a = new int[][]{
                {1, 2, 3}, // a[1]
                {2, 3, 4}, // a[2] 所以输出的是其地址
        };
        System.out.println(Arrays.toString(a));// 输出[[I@4c203ea1, [I@27f674d]
        System.out.println(Arrays.deepToString(a)); //输出为[[1, 2, 3], [2, 3, 4]]
    }


}
