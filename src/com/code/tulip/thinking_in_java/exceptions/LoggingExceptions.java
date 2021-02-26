/**
 * FileName: LoggingExceptions
 * @author:   Code
 * Date:     2019/5/5 14:31
 * Description: 异常与记录日志
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException2");

    public LoggingException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException2();
        } catch (LoggingException2 e) {
            System.err.println("Caught " + e);
        }
    }
}
