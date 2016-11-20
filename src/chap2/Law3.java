package chap2;

/**
 * 使用public static final域的Singleton，对象只能创建一次，客户端可以直接访问到该域。
 * 缺点是客户端可以通过反射机制访问到私有构造器。
 * */
class Elvis1{
    public static final Elvis1 INSTANCE = new Elvis1();
    private Elvis1(){
        // ...
    }
}

/**
 * 利用静态工厂方法创建单例对象。
 * 工厂方法的好处是更为灵活，且可以清楚的看出这是一个单例类。
 * */
class Elvis2{
    // 私有的只能创建一次的Elvis2实例
    private static final Elvis2 INSTANCE = new Elvis2();
    private Elvis2(){
        // ...
    }
    // 公有的静态方法返回对象实例
    public static Elvis2 getInstance() {
        return INSTANCE;
    }
}

/**
 * 利用枚举创建单例对象。
 * 与利用公有域创建单例对象类似，但是更为简洁，提供了序列化机制，在任何情况下都可以防止多次实例化，即时是复杂的序列化和反射。
 * 单元素的枚举类型已经成为实现Singleton的最佳方法。
 * */
enum Elvis3{
    INSTANCE;

    public void otherMethod(){}
}

/**
 * 第3条：用私有构造器或者枚举类型强化Singleton属性
 */
public class Law3 {
}
