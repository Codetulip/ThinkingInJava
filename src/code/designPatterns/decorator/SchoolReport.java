package code.designPatterns.decorator;

/**
 * @Classname SchoolReport
 * @Description 成绩单抽象类
 * @Author tujing
 * @Date 2019/6/17 10:32 PM
 * @Version 1.0
 */
public abstract class SchoolReport {

    // 展示学习成绩
    public abstract void report();

    // 家长签字
    public abstract void sign(String name);
}
