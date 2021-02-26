package com.code.tulip.thinking_in_java.designPatterns.decorator.universalCode;

/**
 * @Classname ConcreteComponent
 * @Description 具体构件
 * @author code-tulip
 * @Date 2019/6/17 11:12 PM
 * @Version 1.0
 */
public class ConcreteComponent extends Component{
    @Override
    public void operate() {
        System.out.println("do something");
    }
}
