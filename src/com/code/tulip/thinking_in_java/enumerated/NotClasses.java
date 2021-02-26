package com.code.tulip.thinking_in_java.enumerated;

/**
 * @Classname NotClasses
 * @Description enum实例是类的相似之处
 * @author code-tulip
 * @Date 2019/5/24 12:59 PM
 * @Version 1.0
 */


enum LikeClasses {

    // 常量实例都是static final的
    // static实例无法访问外部类的非static元素和方法
    WINKEN {
        @Override
        void behavior() {
            System.out.println(
                    "behevior1"
            );
        }
    },

    BLINKEN {
        @Override
        void behavior() {
            System.out.println("behavior2");
        }
    },

    NOD {
        @Override
        void behavior() {
            System.out.println("behavior3");
        }
    };

//    abstract void behavior();

    // 覆盖方法，不能缩小方法的使用范围
    // enum中也可以覆盖方法
    void behavior() {
        System.out.println("default behavior");
    };
}


public class NotClasses {

    //    void f1(LikeClasses.WINKEN instance) {} // 这样并不行，常量不能当做Class类型参数放进去


    public static void main(String[] args) {
        for (LikeClasses likeClasses : LikeClasses.values()) {
            likeClasses.behavior();
        }
    }


}
