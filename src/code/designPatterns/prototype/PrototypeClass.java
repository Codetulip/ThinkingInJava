package code.designPatterns.prototype;

/**
 * @Classname PrototypeClass
 * @Description
 * @Author tujing
 * @Date 2019/6/13 4:51 PM
 * @Version 1.0
 */
public class PrototypeClass implements Cloneable {

    // 直接拷贝，不经过构造器
    // clone()方法的原理是直接从内存中（堆内存）以二进制流的方式进行拷贝，重新分配一个内存块，所以不经过构造器。
    @Override
    public PrototypeClass clone() {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototypeClass;
    }
}
