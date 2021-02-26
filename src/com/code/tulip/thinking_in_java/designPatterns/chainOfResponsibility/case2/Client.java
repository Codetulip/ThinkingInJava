package com.code.tulip.thinking_in_java.designPatterns.chainOfResponsibility.case2;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Classname Client
 * @Description 场景类
 * @author code-tulip
 * @Date 2019/7/2 10:59 PM
 * @Version 1.0
 */

// 责任链模式：使多个对象都有机会处理请求，从而避免请求的发送者和接受者之间的耦合关系。
// 将处理着连成一条链，并沿着这条链处理请求，直到有对象处理它为止
public class Client {

    public static void main(String[] args) {
        // 随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4), "我要出去旅游"));
        }
        // 定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        // 设置请示顺序(形成了责任链)
        father.setHandler(husband);
        husband.setHandler(son);
        for (IWomen women : arrayList) {
            father.handleMessage(women);
        }
    }
}

// 利用enum类的常量相关方法形成职责链
class EnumChain {
    // 定义邮政单位处理邮件的所有方式，实现职责链
    enum Handler {
        // 每一个常量实例对应处理邮件属性的方式(策略)
        FATHER {
            @Override
            boolean handle(IWomen women) {
                return true;
            }
        },
        HUSBAND {
            @Override
            boolean handle(IWomen women) {
                return true;
            }
        },

        SON {
            @Override
            boolean handle(IWomen women) {
                return true;
            }
        };

        abstract boolean handle(IWomen women); // 定义处理请示的方法
    }

    void handleMessage() {
        // 随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWomen> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4), "我要出去旅游"));
        }
        for (IWomen women : arrayList) {
            for (Handler handler : Handler.values()) {
                // 任何一个处理者处理成功即表示请求处理成功
                if (handler.handle(women)) {
                    return;
                }
            }
        }
    }
}
