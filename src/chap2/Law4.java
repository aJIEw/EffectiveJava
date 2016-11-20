package chap2;


class UtilityClass{
    private UtilityClass(){
        // 可以避免不小心在类的内部调用了构造器
        throw new AssertionError();
    }
}

/**
 * 第4条：通过私有构造器强化不可实例化的能力。
 */
public class Law4 {
}
