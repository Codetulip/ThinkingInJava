package com.code.tulip.thinking_in_java.designPatterns.decorator;

/**
 * @Classname HighScoreDecorator
 * @Description
 * @author code-tulip
 * @Date 2019/6/17 10:59 PM
 * @Version 1.0
 */
public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    // 定义装饰方法
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
