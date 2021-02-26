/**
 * FileName: FailFast
 * @author:   Code
 * Date:     2019/5/14 13:34
 * Description: 快速报错
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;


// 快速报错，不是使用复杂的算法在时候来检查问题
// 探查容器上的任何除了你的进程所进行的操作以外的所有变化，一旦发现其他进程修改了容器，就会抛出ConcurrentModificationException
public class FailFast {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        Iterator<String> it = c.iterator();
        // 一定要避免这种操作,或者使用同步类
        // 获得迭代器后，对容器进行修改，导致迭代器和容器的状态不一致了
        c.add("An object");
        try {
            String next = it.next();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
