package code.designPatterns.composite.universalCode;

import java.util.ArrayList;

/**
 * @Classname Composite
 * @Description 树枝构件
 * @Author tujing
 * @Date 2019/6/16 9:10 PM
 * @Version 1.0
 */
public class Composite extends Component {

    // 存放构件的容器
    private ArrayList<Component> componentsArrayList = new ArrayList<>();

    // 增加一个树叶或树枝构件
    public void add(Component component) {
        component.setParent(this); // 设置父节点(实现从各位置开始的遍历)
        this.componentsArrayList.add(component);
    }

    // 删除一个树叶或树枝构件
    public void remove(Component component) {
        this.componentsArrayList.remove(component);
    }

    // 获得分支下所有的叶子和树枝构件
    public ArrayList<Component> getChildren() {
        return this.componentsArrayList;
    }
}
