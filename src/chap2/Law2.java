package chap2;

class NutritionFacts{

    // 设为final保证这几个参数都是必须的，且不会被内部随意修改
    private final int mSize;
    private final int mServings;
    private final int mCalories;
    private final int mFat;
    private final int mSodium;
    private final int mCarbohydrate;

    /**
     * 用Builder对象的参数初始化各成员变量
     * */
    private NutritionFacts(Builder builder) {
        mSize = builder.mSize;
        mServings = builder.mServings;
        mCalories = builder.mCalories;
        mFat = builder.mFat;
        mSodium = builder.mSodium;
        mCarbohydrate = builder.mCarbohydrate;
    }

    public int getSize() {
        return mSize;
    }

    public int getServings() {
        return mServings;
    }

    public int getCalories() {
        return mCalories;
    }

    public int getFat() {
        return mFat;
    }

    public int getSodium() {
        return mSodium;
    }

    public int getCarbohydrate() {
        return mCarbohydrate;
    }

    public static class Builder{
        // 要求参数
        private final int mSize;
        private final int mServings;

        // 可选参数
        private int mCalories;
        private int mFat;
        private int mSodium;
        private int mCarbohydrate;

        public Builder(final int size, final int servings) {
            mSize = size;
            mServings = servings;
        }

        /*
         * 设置各个可选参数
         * */
        public Builder calories(int val) {
            mCalories = val;
            return this;
        }

        public Builder fat(int val) {
            mFat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            mCarbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            mSodium = val;
            return this;
        }

        /**
         * 根据已有参数返回外部对象
         * */
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}


/**
 * 第2条：遇到多个构造器参数时考虑使用构建器（Builder模式）
 */
public class Law2 {

    public static void main(String[] args) {
        int size = 5;
        int servings = 3;

        // 通过Builder对象设置参数，最后调用build方法生成不可变的NutritionFacts对象
        NutritionFacts facts = new NutritionFacts.Builder(size, servings)
                // 可以有多个可变参数
                .calories(300)
                .carbohydrate(2000)
                .fat(20)
                .sodium(5)
                .build();
    }
}
