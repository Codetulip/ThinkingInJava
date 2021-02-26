package com.code.tulip.thinking_in_java.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname BenzBuilder
 * @Description 奔驰车组装者
 * @author code-tulip
 * @Date 2019/6/11 12:07 AM
 * @Version 1.0
 */
public class BenzBuilder extends CarBuilder {

    private BenzModel benzModel = new BenzModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
