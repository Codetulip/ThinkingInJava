package code.designPatterns.abstractFactory;

/**
 * @Classname FemaleHumanFactory
 * @Description 女性工厂
 * @Author tujing
 * @Date 2019/6/1 11:16 PM
 * @Version 1.0
 */
public class FemaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
//        return new FemaleWhiteHuman();
        return null;
    }

    @Override
    public Human createBlackHuman() {
//        return new FemaleBlackHuman();
        return null;
    }
}
