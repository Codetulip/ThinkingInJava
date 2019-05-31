/**
 * FileName: ProcessFiles
 * Author:   Code
 * Date:     2019/5/16 10:29
 * Description: 文件处理工具（基于策略模式）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;

    private String ext; // 文件扩展名

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    /**
     * 利用Directory工具获得指定目录中所有符合要求的文件，并交给Strategy处理
     *
     * @param root 起始目录
     * @throws IOException
     */
    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    /**
     * 文件处理程序
     * @param args 文件参数
     */
    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File file = new File(arg);
                    if (file.isDirectory())
                        // 如果是目录
                        processDirectoryTree(file);
                    else {
                        // 如果是文件
                        // 允许使用者忘记限定文件扩展名
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());

                    }
                }
            }
        } catch (IOException e) {
            // 异常链
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}
