package code.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname InetAddressTest
 * @Description
 * @Author codetulip
 * @Date 2019/8/12 20:04
 * @Version 1.0
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                // 假设参数为 www.baidu.com
                String host = args[0];
                InetAddress[] inetAddress = InetAddress.getAllByName(host);
                for (InetAddress address : inetAddress) {
                    System.out.println(address);
                }
            } else {
                InetAddress localHostAddress = InetAddress.getLocalHost();
                System.out.println(localHostAddress);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
