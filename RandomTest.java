import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Random test class
 * @author xqliu
 */
public class RandomTest {

    public static void main(String[] args) {
        Random r = new Random();

        //生成[0,1.0)区间的小数
        double d1 = r.nextDouble();
        System.out.println("d1=" + d1);

        //生成[0,5.0)区间的小数：将该区间扩大5倍即是要求的区间。
        double d2 = r.nextDouble() * 5;
        System.out.println("d2=" + d2);

        //生成[1,2.5)区间的小数：只需要首先生成[0,1.5)区间的随机数字，然后将生成的随机数区间加1即可。
        double d3 = r.nextDouble() * 1.5 + 1;
        System.out.println("d3=" + d3);

        //生成任意整数：直接使用nextInt方法即可。
        int n1 = r.nextInt();
        System.out.println("n1=" + n1);

        //生成[0,10)区间的整数
        int n2a = r.nextInt(10);
        System.out.println("n2a=" + n2a);
        int n2b = Math.abs(r.nextInt() % 10);
        System.out.println("n2b=" + n2b);

        //生成[-3,15)区间的整数
        int n4 = r.nextInt(18) - 3;
        System.out.println("n4=" + n4);

        //题目：如何写出随机生成一个整数，该整数以55%的几率生成1，以40%的几率生成2，以5%的几率生成3，Java代码？
        int n5 = r.nextInt(100);
        int m; //结果数字
        if(n5 < 55){ //55个数字的区间，55%的几率
            m = 1;
        }else if(n5 < 95){//[55,95)，40个数字的区间，40%的几率
            m = 2;
        }else{
            m = 3;
        }
        System.out.println("m=" + m);

        //分析：因为每个数字的几率都是1%，则任意55个数字的区间的几率就是55%，为了代码方便书写，这里使用[0,55)区间的所有整数。原理都一样。
        //当然，这里的代码可以简化，因为几率都是5%的倍数，所以只要以5%为基础来控制几率即可，下面是简化的代码实现：

        int n6 = r.nextInt(20);
        int m1;
        if(n6 < 11){
            m1 = 1;
        }else if(n6 < 19){
            m1 = 2;
        }else{
            m1 = 3;
        }
        System.out.println("m1=" + m1);

        testRandom();
    }

    private static void testRandom() {
        Random r = new Random(100);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<100000; i++) {
            String m = String.valueOf(gen123(r));
            Integer count = map.get(m);
            if (count == null) {
                map.put(m, 1);
            } else {
                map.put(m, count+1);
            }
        }
        for (String str : map.keySet()) {
            System.out.println(str+" : "+map.get(str));
        }
    }

    /**
     * 随机生成一个整数，该整数以55%的几率生成1，以40%的几率生成2，以5%的几率生成3
     * @param r
     * @return
     */
    private static int gen123(Random r) {
        int n6 = r.nextInt(20);
        int m1;
        if(n6 < 11){
            m1 = 1;
        }else if(n6 < 19){
            m1 = 2;
        }else{
            m1 = 3;
        }
        return m1;
    }

}
