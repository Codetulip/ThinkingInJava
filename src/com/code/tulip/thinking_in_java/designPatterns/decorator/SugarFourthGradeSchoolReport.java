package com.code.tulip.thinking_in_java.designPatterns.decorator;

/**
 * @Classname SugarFourthGradeSchoolReport
 * @Description 装饰下原有类
 * @author code-tulip
 * @Date 2019/6/17 10:40 PM
 * @Version 1.0
 */
// 通过继承进行装饰，扩展性太差(类爆炸，类的数量激增)
// 继承层次越多维护成本越多（继承超过两层就应该考虑别的方法）
public class SugarFourthGradeSchoolReport extends FourthGradeSchoolReport{

    // 定义装饰方法
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    // 定义装饰方法
    private void reportSort() {
        System.out.println("排名第38名...");
    }

    @Override
    public void report() {
        this.reportHighScore(); // 先说最高成绩
        super.report(); // 然后给老爸看成绩单
        this.reportSort(); // 然后告诉老爸排名
    }
}
