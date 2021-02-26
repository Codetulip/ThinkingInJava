package com.code.tulip.thinking_in_java.designPatterns.bridge.universalCode;

/**
 * @Classname RefinedAbstraction
 * @Description
 * @author code-tulip
 * @Date 2019/6/27 10:57 PM
 * @Version 1.0
 */
public class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    // 修正父类的行为
    @Override
    public void request() {
        super.request();
        super.getImpl().doAnything();
    }
}
