package code.designPatterns.composite;

import java.util.ArrayList;

/**
 * @Interfacename IBranch
 * @Description 树枝节点接口
 * @Author tujing
 * @Date 2019/6/16 8:55 PM
 * @Version 1.0
 */
public interface IBranch extends ICorp{

    // 能够增加连接的下属（树叶或树枝）
    public void addSubordinate(ICorp corp);

    // 能够获取下属的信息
    public ArrayList<ICorp> getSubordinate();
}
