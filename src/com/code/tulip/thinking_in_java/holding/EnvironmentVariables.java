package com.code.tulip.thinking_in_java.holding;

import java.util.Map;

/**
 * FileName: EnviromentVariables
 *
 * @author code-tulip
 * Date:     2019/4/28 22:57
 * Description: 操作系统环境变量
 */
public class EnvironmentVariables {

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
