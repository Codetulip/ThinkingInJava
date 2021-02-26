package com.code.tulip.thinking_in_java.designPatterns.composite.universalCode;

/**
 * @Classname Leaf
 * @Description 树叶构件
 * @author code-tulip
 * @Date 2019/6/16 9:13 PM
 * @Version 1.0
 */
public class Leaf extends Component {



    /**
     * 可以覆盖父类的方法
     * public void doSomething()
     */

    private Component parent = null; // 存放父节点（这样就可以实现从任何一个位置都可以遍历了）

    @Override
    public void setParent(Component parent) {
        this.parent = parent;
    }
}
