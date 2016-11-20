package chap4;

/**
 * 第19条：接口只用于定义类型。
 */
public class Law19 {

    // 不要写这种常量接口
    interface PhysicalConstant {
        float FLOAT_NUMBER = 2.3f;
        double DOUBLE_NUMBER = 34.5;
    }
}
