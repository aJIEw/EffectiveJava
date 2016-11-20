package chap7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 第41条：慎用重载。
 */
public class Law41 {

    public static void main(String[] args) {
        // 重载不像多态，无法动态选择执行的方法
        Collection<String> collection = new ArrayList<>();
        print(collection);

        System.out.println("----------dynamicPrint----------");
        dynamicPrint(collection);
    }

    public static void print(Collection<?> collection) {
        System.out.println("Collection");
    }

    public static void print(List<?> list) {
        System.out.println("List");
    }

    public static void print(Set<?> set) {
        System.out.println("Set");
    }

    public static void dynamicPrint(Collection<?> collection) {
        System.out.println(collection instanceof List ? "List" :
                collection instanceof Set ? "Set" : "Unknown Collection");
    }
}
