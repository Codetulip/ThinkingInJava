package code.designPatterns.decorator;

/**
 * @Classname FourthGradeSchoolReport
 * @Description 具体成绩单
 * @Author tujing
 * @Date 2019/6/17 10:33 PM
 * @Version 1.0
 */
public class FourthGradeSchoolReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("尊敬的xxx家长： ");
        System.out.println("  ......");
        System.out.println("  语文 62  数学 65  体育 98  自然  63");
        System.out.println("  ......");
        System.out.println("            家长签字：       ");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名为: " + name);
    }
}
