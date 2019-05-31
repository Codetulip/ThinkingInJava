/**
 * FileName: SList
 * Author:   Code
 * Date:     2019/5/9 19:31
 * Description: 单向链表类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.containers;


class Link {

    public Link next = null;

}


public class SList {

    public Link head = null; // 存放第一个Link

    public Link cursor = null; //指示当前的Link对象

    class SListIterator {

        public void add() {
            if (head == null) {
                head = new Link();
                cursor = head;
            } else {
                cursor.next = new Link();
                cursor = cursor.next;
            }
        }

        public void remove() {
            Link temp = head;
            while (temp.next != cursor) {
                temp = temp.next;
            }
            temp.next = null;
            cursor = null;
            cursor = temp;
        }

    }

    public SListIterator iterator() {

        return new SListIterator();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        SList sList = new SList();
        SListIterator sListIterator = sList.iterator();
        sListIterator.add();
        System.out.println(sList.head + " " + sList.cursor);
        sListIterator.add();
        System.out.println(sList.head + " " + sList.head.next + " " + sList.cursor);
        sListIterator.add();
        System.out.println(sList.head + " " + sList.head.next + " " + sList.cursor);
        sListIterator.remove();
        System.out.println(sList.head + " " + sList.head.next + " " + sList.cursor);
    }
}
