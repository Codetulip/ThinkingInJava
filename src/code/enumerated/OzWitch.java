package code.enumerated;

/**
 * @EnumName OzWitch
 * @Description enum中可以有方法，并可以对每个常量进行描述
 * @Author tujing
 * @Date 2019/5/23 4:43 PM
 * @Version 1.0
 */

// 可见除了少许限制，完全可以把enum当做一个类
public enum OzWitch {
    // WEST、NORTH等都是OzWitch对象
    WEST("Miss gulch,aka the"), // 这个实际上创建对象的过程OzWitch WEST = new OzWitch（"Miss gulch,aka the"）;
    NORTH("asdasda"),
    EAST("asdijasod"),
    SOUTH("asdasdsa");

    private String description;

    // 必须先定义构造器，且构造器必须是private或者包访问权限的
    private OzWitch(String description) {
        // description对应了括号里面的值
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
//        OzWitch.EAST.getDescription();
        for (OzWitch w : OzWitch.values()) {
            System.out.println(w + " " + w.getDescription());
        }

    }
}
