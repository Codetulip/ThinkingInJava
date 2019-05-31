/**
 * FileName: PriorityQueueDemo
 * Author:   Code
 * Date:     2019/4/28 15:09
 * Description: 有些队列的测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.holding;

import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random(47);
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        // 格式化
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for (int i = 0; i < 10; i++) {
            Double temp = rand.nextDouble();
            System.out.print(temp + " ");
            priorityQueue.offer(Double.valueOf(decimalFormat.format(temp)));
        }
        System.out.println();

        // 第一种输出表示(0.05 0.16 0.26 0.19 0.52 0.53 0.27 0.73 0.8 0.76 )
        for (Double i : priorityQueue){
            System.out.print(i + " ");
        }
        System.out.println();

        // 第二种输出表示([0.05, 0.16, 0.26, 0.19, 0.52, 0.53, 0.27, 0.73, 0.8, 0.76])
        System.out.println(priorityQueue);

        // 第三种输出表示(0.05 0.16 0.19 0.26 0.27 0.52 0.53 0.73 0.76 0.8)
        while (priorityQueue.peek() != null)
            System.out.print(priorityQueue.poll() + " ");

        // 第一种和第二种是队列数据本身的存放顺序(并不是按照插入顺序存放的)，
        // 而第三种基于某个优先顺序取出来的结果
        // 插入时排序，移除时选择最重要的元素

        // 测试不能将多个Simple放入priorityQueue中
        PriorityQueue<Simple> priorityQueue2 = new PriorityQueue<>();
        // priorityQueue2.offer(new Simple()); // 异常
        // priorityQueue2.offer(new Simple()); //
        //java.lang.ClassCastException:
        // code.holding.Simple cannot be cast to java.base/java.lang.Comparable
    }
}
