package chap5;

import java.util.ArrayList;
import java.util.List;

/**
 * 第23条：不要再新代码中使用原生态类型。
 */
public class Law23 {

    public static void main(String[] args) {
        // 表示可以添加任何对象的List
        List<Object> objectList = new ArrayList<>();
        // 表示只能包含某种未知对象类型的List
        List<?> whateverList = new ArrayList<>();
        // 原生类型的List，脱离了泛型系统
        List rawList = new ArrayList();

        // 前两种是安全的，最后一种是不安全的，不要这样写
    }
}
