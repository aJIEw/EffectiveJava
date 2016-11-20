package chap7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 第43条：返回零长度的数组或者集合而不是null
 */
public class Law43 {
}

class Shop{

    private List<Cheese> mCheeseInStock = new ArrayList<>();

    /**
     * 如果这返回null那么客户端的调用就必须处理null
     * */
    public Cheese[] getCheeses() {
        if (mCheeseInStock.size() == 0) {
            return null;
        }
        return (Cheese[]) mCheeseInStock.toArray();
    }
}

enum  Cheese {
    STILTON;
}

class Customer{
    Shop mShop = new Shop();
    Cheese[] mCheeses = mShop.getCheeses();

    /**
     * 每次调用API都要判空，这是不必要的
     * */
    public void eatCheese() {
        if (mCheeses != null &&
                Arrays.asList(mCheeses).contains(Cheese.STILTON)) {
            System.out.println("yummy");
        }
    }
}
