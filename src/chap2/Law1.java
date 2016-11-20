package chap2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 第1条：考虑用静态工厂方法代替构造器。
 *
 * 这里用服务提供者框架作为演示，P.6
 */
public class Law1 {

    public static void main(String[] args) {
        Services.registerProvider(Services.DEFAULT_PROVIDER_NAME, new Provider() {
            @Override
            public Service newService() {
                // 返回服务接口的实现类
                return null;
            }
        });

        Service service = Services.newInstance(Services.DEFAULT_PROVIDER_NAME);
    //    do other things
    }
}

/**
 * 服务接口
 * */
interface Service{}

/**
 * 服务者提供者接口（可选）
 * */
interface Provider{
    Service newService();
}

class Services{
    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    private Services() {}// 防止被实例化
    private static final Map<String, Provider> PROVIDERS =
            new ConcurrentHashMap<>();

    /**
     * 注册提供者
     * */
    public static void registerProvider(String name, Provider provider) {
        PROVIDERS.put(name, provider);
    }

    /**
     * 根据Provider获取一个Service实例
     * */
    public static Service newInstance(String name){
        Provider provider = PROVIDERS.get(name);
        if (provider == null) {
            throw new IllegalArgumentException("No provider registered with name " + name);
        }
        return provider.newService();
    }
}
