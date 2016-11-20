package chap6;

/**
 * 第34条：用接口模拟可伸缩的枚举。
 */
public class Law34 {
}

/**
 * 将操作放在接口中
 * */
interface Operation{
    double apply(double x, double y);
}

/**
 * 可以扩展枚举
 * */
enum BasicOperation implements Operation {
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*"){
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    },
    ;

    private final String mSymbol;

    BasicOperation(String symbol) {
        mSymbol = symbol;
    }

    @Override
    public String toString() {
        return mSymbol;
    }
}

/**
 * 轻松扩展接口
 * */
enum ExtendedOperation implements Operation {

    EXP("^"){
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%"){
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    },
    ;
    private final String mSymbol;

    ExtendedOperation(String symbol) {
        mSymbol = symbol;
    }

    @Override
    public String toString() {
        return mSymbol;
    }
}