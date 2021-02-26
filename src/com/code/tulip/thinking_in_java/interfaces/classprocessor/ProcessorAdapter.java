/**
 * FileName: ProcessorAdapter
 * @author:   Code
 * Date:     2019/4/24 15:20
 * Description: 适配器模式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.code.tulip.thinking_in_java.interfaces.classprocessor;

public class ProcessorAdapter extends Processor {
    Processor p; // 代理？

    public ProcessorAdapter(Processor p ) {
        this.p = p;
    }

    @Override
    public String process(Object input) {
        return (String) p.process(input);
    }

    public static void main(String[] args) {
        Apply.process(new ProcessorAdapter(new Upcase()), Apply.s);
        Apply.process(new ProcessorAdapter(new Downcase()), Apply.s);
        Apply.process(new ProcessorAdapter(new Splitter()), Apply.s);
    }
}
