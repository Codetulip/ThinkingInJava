/**
 * FileName: References
 * @author:   Code
 * Date:     2019/5/15 10:53
 * Description: 持有引用（使用Reference类包装普通对象）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.containers;

import java.lang.ref.*;
import java.util.LinkedList;

class VeryBig {

    private static final int SIZE = 10000;

    private long[] la = new long[SIZE];

    private String ident;

    public VeryBig(String id) {
        this.ident = id;
    }

    @Override
    public String toString() {
        return ident;
    }

    // 被回收的时候执行
    @Override
    protected void finalize() {
        System.out.println("Finalizing" + ident);
    }
}

// 如果想继续持有对某个对象的引用，希望以后还能访问到该对象，
// 但是也希望垃圾回收期可以释放它，这个时候就需要使用Refercen对象
// 可以继续使用该对象，在内存耗尽时又允许释放该对象
public class References {

    // ReferenceQueue是用作回收前清理工作的工具
    // RegerenceQueue总是生成一个包含null对象的Reference
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null) {
            // Reference.get()返回此引用对象的指示对象
            System.out.println("In queue : " + inq.get());
        }
    }

    public static void main(String[] args) {

        int size = 10;
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<SoftReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            // 将VeryBig对象的引用交给SoftReference对象包装
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft" + i), rq));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }

        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<WeakReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak" + i), rq));
            System.out.println("Just creater: " + wa.getLast());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<VeryBig>(new VeryBig("soft"));
        WeakReference<VeryBig> w = new WeakReference<VeryBig>(new VeryBig("weak"));
        System.gc(); //提醒虚拟机，希望在这里回收对象，具体回收与否由虚拟机决定

        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<PhantomReference<VeryBig>>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom" + i), rq));
            System.out.println("Just creater: " + pa.getLast());
            checkQueue();
        }

    }
}
