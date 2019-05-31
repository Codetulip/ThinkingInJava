package code.innerclasses;

public interface ClassInInterface {

    void hello();

    // 接口中的内部类
    class Test implements ClassInInterface {

        @Override
        public void hello() {
            System.out.println("hello");
        }

        public static void main(String[] args) {
            new Test().hello();
        }
    }

}
