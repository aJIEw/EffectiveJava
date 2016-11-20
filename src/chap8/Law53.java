package chap8;

import java.util.Arrays;
import java.util.Set;

/**
 * 第53条：接口优先于反射机制。
 *
 * 反射机制是一种功能强大的机制，对于特定的复杂系统的编程任务，它是必要的，但是它也有一些缺点
 */
public class Law53 {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("you need to put in args!");
            return;
        }

        Class<?> klass = Class.forName(args[0]);
        Set<String> set = (Set<String>) klass.newInstance();

        set.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(set);
    }
}
