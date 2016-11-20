package chap8;

import java.math.BigDecimal;

/**
 * 第48条：如果需要精确的戴安，请避免使用float和double。
 * <p>
 * 原因：它们无法提供完全精确的结果，尤其是不适合货币计算。
 * 解决方法：使用BigDecimal int 或者long进行货币计算。
 */
public class Law48 {

    public static void main(String[] args) {
        // 总资产
        double found = 1.00;
        // 买入的商品
        int itemBought = 0;
        // 分别买价格为0.1 0.2 0.3 依次类推的商品，正常情况应该刚好买入4个商品
        for (double price = 0.10; found >= price; price += 0.10) {
            found -= price;
            itemBought++;
        }
        System.out.println("itemBought: " + itemBought);
        // 最后剩下0.3999999999999999的找零，double和float都是不精确的
        System.out.println("Change: " + found);

        System.out.println("----------Using BigDecimal----------");
        BigDecimal tenCents = new BigDecimal(0.10);
        BigDecimal found2 = new BigDecimal(1.00);
        int itemBought2 = 0;
        for (BigDecimal price = new BigDecimal(1.00); found2.compareTo(price) >= 0; price = price.add(tenCents)) {
            found2 = found2.subtract(price);
            itemBought2++;
        }
        // 这样就正确了
        System.out.println("itemBought: " + itemBought2);
        System.out.println("Change: " + found2);
    }
}
