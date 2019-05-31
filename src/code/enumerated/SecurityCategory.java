package code.enumerated;

/**
 * @Classname SecurityCategory
 * @Description 枚举的管理
 * @Author tujing
 * @Date 2019/5/23 11:46 PM
 * @Version 1.0
 */
public enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);

    private Security[] values;

    private SecurityCategory(Class<? extends Security> c) {
        values = c.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelector() {
        return Enums.random(values);
    }
}
