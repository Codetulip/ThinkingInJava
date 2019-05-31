import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * FileName: code
 * Author:   Code
 * Date:     2019/4/12 20:56
 * Description: 训练集
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

public class Code {

    static Random rand = new Random(47);

    // 权重集
    public static Double[] weight = new Double[]{
            0.0609,
            0.1017,
            0.07,
            0.0813,
            0.1003,
            0.111,
            0.0775,
            0.1123,
            0.0423,
            0.095,
            0.038,
            0.0391,
            0.039,
            0.0113,
            0.0195
    };


    // 指标随机生成
    public static double nextDouble() throws Exception {

        // 设置随机范围
        double max = 9;
        double min = 5;

        if (max < min) {
            throw new Exception("min < max");
        }
        if (min == max) {
            return min;
        }
        return min + ((max - min) * rand.nextDouble());
    }

    // 结果波动
    public static double wave() throws Exception {

        // 设置随机范围
        double max = 0.2;
        double min = -0.2;

        if (max < min) {
            throw new Exception("min < max");
        }
        if (min == max) {
            return min;
        }
        return min + ((max - min) * rand.nextDouble());
    }

    // 生成一组训练集
    public static Double[] generateSet() throws Exception {

        Double[] temp = new Double[16];
        int i = 0;

        // 格式化数据
        // 设置保留两位小数
        DecimalFormat df = new DecimalFormat("0.00");

        // 存放模糊评价结果
        Double sum = new Double(0);

        for (; i < 15; i++) {

            temp[i] = Double.valueOf(df.format(nextDouble()));

            sum += temp[i] * weight[i];

        }
        // 结果波动
        sum += wave();

        temp[i] = Double.valueOf(df.format(sum));

        return temp;

    }

    // 输出函数
    public static String out(Double[] temp) {

        String set = "";
        for (Double temp1 : temp) {
            set = set + temp1 + " ";
        }

        return set;
    }

    public static void main(String[] args) throws Exception {

        // 输出到txt文件
        FileWriter writer = new FileWriter("C:\\Users\\Code\\Desktop\\code.txt", true);
        for (int i = 0; i < 50; i++) {
            Double[] temp = generateSet();
            writer.write(out(temp)+"\r\n");
        }

        writer.close();
    }
}
