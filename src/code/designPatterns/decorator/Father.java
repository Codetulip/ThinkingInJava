package code.designPatterns.decorator;

/**
 * @Classname Father
 * @Description 老爸查看成绩单
 * @Author tujing
 * @Date 2019/6/17 10:35 PM
 * @Version 1.0
 */
public class Father {

    public static void main(String[] args) {
        // 拿到成绩单
//        SchoolReport report = new FourthGradeSchoolReport(); // 装饰前
//        SchoolReport report = new SugarFourthGradeSchoolReport(); // 装饰后
        // 使用装饰器模式之后
        SchoolReport report = new FourthGradeSchoolReport();
        // 利用重写的多态性完成的
        report = new HighScoreDecorator(report);
        report = new SortDecorator(report);
        // 查看成绩单
        report.report();
        /**
         * 看到结果后并不一定签字了
         * 于是，我们想办法将报告装饰一下
         */
    }
}
