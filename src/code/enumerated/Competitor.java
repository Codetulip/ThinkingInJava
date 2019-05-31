package code.enumerated;

/**
 * @Interfacename Competitor
 * @Description
 * @Author tujing
 * @Date 2019/5/24 11:31 PM
 * @Version 1.0
 */
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
