package chap4;

import java.util.Comparator;

/**
 * 第21条：用函数对象表示策略。
 *
 * 函数指针的主要用途就是实现策略模式。Java中实现这种模式，就必须先声明一个接口，并且为每个具体策略声明一个实现该接口的类。
 */
public class Law21 {
}

class Host{

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCom();

    static class StrLenCom implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}