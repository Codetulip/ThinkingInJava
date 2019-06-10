package code.designPatterns.builder;

import java.util.ArrayList;

/**
 * @Classname BMWBuilder
 * @Description 宝马车组装者
 * @Author tujing
 * @Date 2019/6/11 12:08 AM
 * @Version 1.0
 */
public class BMWBuilder extends CarBuilder{

    private BMWModel bmwModel = new BMWModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }
}
