package code.designPatterns.iterator.withIterator;

/**
 * @Classname IProject
 * @Description 项目信息接口，使用迭代器
 * @Author tujing
 * @Date 2019/6/16 2:39 PM
 * @Version 1.0
 */
public interface IProject {

    // 增加项目
    public void add(String name, int num, int cost);

    // 项目信息
    public String getProjectInfo();

    // 获得一个可以遍历的对象
    public IProjectIterator iterator();
}
