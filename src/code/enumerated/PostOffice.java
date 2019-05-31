package code.enumerated;

import java.util.Iterator;

/**
 * @Classname PostOffice
 * @Description 使用enum构建职责链,职责链设计模式
 * @Author tujing
 * @Date 2019/5/24 1:46 PM
 * @Version 1.0
 */
// 定义一封邮件的属性
class Mail {

    enum GeneralDelivery {
        YES, NO1, NO2, NO3, NO4, NO5
    }

    enum Scannablity {
        UNSCANNABLE, YES1, YES2, YES3, YES4
    }

    enum Readability {
        ILLEGIBLE, YES1, YES2, YES3, YES4
    }

    enum Address {
        INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
    }

    enum ReturnAddress {
        MISSING, OK1, OK2, OK3, OK4, OK5
    }

    GeneralDelivery generalDelivery;
    Scannablity scannablity;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;

    long id = counter++;

    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() + ", General Delivery: " + generalDelivery +
                ", Address Scannablity: " + scannablity + ", Address Readability: " + readability +
                ", Address Address: " + address + ", Return Address: " + readability;
    }

    // 生成一封测试邮件
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannablity = Enums.random(Scannablity.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    /**
     * 通过指定邮件数量count，生成邮件并返回所有邮件的迭代器
     *
     * @param count 邮件数量
     * @return
     */
    public static Iterable<Mail> generator(final int count) { // 匿名内部类使用外部类变量需要final，虽然已测试过不加final也没有影响
        return new Iterable<Mail>() {
            int n = count;

            public Iterator<Mail> iterator() {
                return new Iterator<Mail>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

}

public class PostOffice {

    // 定义邮政单位处理邮件的所有方式，实现职责链
    enum MailHandler {
        // 每一个常量实例对应处理邮件属性的方式(策略)
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("using general delicery " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannablity) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + "automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivery " + m + "normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("Returning " + m + "to sender");
                        return true;
                }
            }
        };

        abstract boolean handle(Mail m); // 定义邮件的处理方法
    }

    static void handle(Mail m) {
        // 观察这里，职责链的形成，依次调用所有的处理方式处理邮件
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(m)) {
                return;
            }
        }
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail m : Mail.generator(3)) {
            System.out.println(m.details());
            handle(m);
            System.out.println("***********");
        }
    }
}
