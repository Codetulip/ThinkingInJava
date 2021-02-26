/**
 * FileName: Individual
 * @author:   Code
 * Date:     2019/5/12 20:38
 * Description:如何写出hashCode()指导第二个示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.Set;
import java.util.TreeSet;

// 通过泛型限定类型
public class Individual implements Comparable<Individual> {

    private static long count = 0;

    private final long id = count++;

    private String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + id +
                (name == null ? "" : " " + name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = result * 37 + name.hashCode();
        }
        result = result * 37 + (int) id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Individual && id == ((Individual) o).id;
//                && name == null ? true : (name.equals(((Individual) o).name))
    }

    @Override
    public int compareTo(Individual o) {
        String first = getClass().getSimpleName();
        String oFirst = o.getClass().getSimpleName();
        int firstCompare = first.compareTo(oFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && o.name != null) {
            int secondCompare = name.compareTo(o.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
//        return o.id < id ? -1 : (o.id == id ? 0 : 1); // 降序
        return id < o.id ? -1 : (id == o.id ? 0 : 1); // 升序
    }

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<Individual>();
        for (int i = 0; i < 5; i++) {
            pets.add(new Individual());
        }
        System.out.println(pets);
    }
}
