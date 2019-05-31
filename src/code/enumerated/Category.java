package code.enumerated;

import java.util.EnumMap;

import static code.enumerated.Input.*;

/**
 * @EnumName Category
 * @Description 实现Input中的枚举管理
 * @Author tujing
 * @Date 2019/5/24 3:19 PM
 * @Version 1.0
 */
public enum Category {

    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private Input[] values; // values对应常量（）里的数据

    private Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> map = new EnumMap<Input, Category>(Input.class);

    static {
        for (Category c : values()) {
            for (Input input : c.values) {
                map.put(input, c);
            }
        }
    }

    public static Category categorize(Input input) {
        return map.get(input);
    }

    public static void main(String[] args) {
        System.out.println(categorize(NICKEL));
    }
}
