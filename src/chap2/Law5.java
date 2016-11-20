package chap2;

/**
 * 第5条：避免创建不必要的对象。
 */
public class Law5 {

    public static void main(String[] args) {

        long before = System.currentTimeMillis();
        sumWithHighCost();
        long after = System.currentTimeMillis();
        System.out.println("sumWithHighCost cost: " + (after - before));

        // 可以看到除去多余对象，运行时间缩短到原来的1/7左右
        sumWithLowCost();
        System.out.println("sumWithLowCost cost: " + (System.currentTimeMillis() - after));

        // 不要这样写
        String str = new String("s");
    }

    /**
     * 创建多余对象会造成程序速度减慢
     * */
    private static void sumWithHighCost() {
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // 由于自动装箱与拆箱的存在，所以这里一共构造了2^31个Long实例
            sum += i;
        }
    }

    /**
     * 没有多余对象
     * */
    private static void sumWithLowCost() {
        long sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }
}
