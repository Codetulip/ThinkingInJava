package code.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @Classname Pool
 * @Description Semaphore简单示例
 * @Author tujing
 * @Date 2019/5/30 12:32 PM
 * @Version 1.0
 */

// 正常的锁在任何时刻只允许一个任务访问同一个资源，而计数信号量允许n个任务同时访问资源
public class SemaphorePool<T> {
    private int size;

    private List<T> items = new ArrayList<T>();

    private volatile boolean[] checkedOut; // 标记指定对象是否可用

    private Semaphore available;

    public SemaphorePool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true); // 指定同时访问的任务数量

        for (int i = 0; i < size; i++) {
            try {
                items.add(classObject.newInstance()); // 调用无参构造器
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 如果签出，则减少一个Semaphore资源
    public T checkOut() throws InterruptedException{
        available.acquire(); // 检查许可是否可用，可用前都阻塞
        return getItem();
    }

    // 如果签入，则增加一个Semaphore资源
    public void checkIn(T x) {
        if (releaseItem(x)) {
            available.release(); // 添加一个许可，释放一个阻塞的获得者
        }
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) return false;
        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false;
     }
}
