package code.designPatterns.chainOfResponsibility.case2;

/**
 * @Interfacename Handler
 * @Description 有处理权的人员接口
 * @Author tujing
 * @Date 2019/7/2 10:25 PM
 * @Version 1.0
 */
// 修改后的Handler
public abstract class Handler {

    public static final int FATHER_LEVEL_REQUEST = 1;
    public static final int HUSBAND_LEVEL_REQUEST = 2;
    public static final int SON_LEVEL_REQUEST = 3;

    // 处理者对应的处理级别
    private int level = 0;

    // 责任传递
    private Handler nextHandler;

    public Handler(int level) {
        this.level = level;
    }

    // 一个女性要求咋咋咋，你要处理这个请求
    public final void handleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            // 如果有后续环节，将请求向后传递
            if (this.nextHandler != null) {
                this.nextHandler.handleMessage(women);
            } else {
                System.out.println("没有地方请示了，按不同意处理...");
            }
        }
    }

    /**
     * 如果不是属于你处理的请求，就让下一个责任人处理
     */
    public void setHandler(Handler handler) {
        this.nextHandler = handler;
    }

    // 请示的回应
    public abstract void response(IWomen women);
}
