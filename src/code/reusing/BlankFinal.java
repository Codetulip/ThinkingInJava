/**
 * FileName: BlankFinal
 * Author:   Code
 * Date:     2019/4/22 20:55
 * Description: 空白的final
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package code.reusing;

public class BlankFinal {

    private final int i = 0;

    private final int j;

    public BlankFinal() {
        // System.out.println(j); // 使用前必须初始化
        this.j = 2;
    }


    public BlankFinal(int j) {
        this.j = j;
    }

    public static void main(String[] args) {
        BlankFinal blankFinal = new BlankFinal();
        new BlankFinal(2);
        // blankFinal.i = 2;  // 不允许
    }
}
