package code.designPatterns.priciple.lawOfDemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Client
 * @Description 场景类
 * @Author tujing
 * @Date 2019/6/5 3:58 PM
 * @Version 1.0
 */
public class Client {


    public static void main(String[] args) {
        /*// point 1
        Teacher teacher = new Teacher();
        teacher.commond(new GroupLeader());*/

        // point 2
        List<Girl> list = new ArrayList<Girl>();
        // 初始化女生
        for (int i = 0; i < 10; i++) {
            list.add(new Girl());
        }
        Teacher teacher = new Teacher();
        // 清点女生
        teacher.commond(new GroupLeader(list));
    }
}
