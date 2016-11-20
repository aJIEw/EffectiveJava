package chap5;

import java.util.HashMap;
import java.util.Map;

/**
 * 第29条：优先考虑类型安全的异构容器。
 */
public class Law29 {

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.putFavorite(String.class, "Aaron");
        favorites.putFavorite(Integer.class, 22);
        favorites.putFavorite(Float.class, 160.5f);

        System.out.println("name: " + favorites.getFavorite(String.class));
        System.out.println("age: " + favorites.getFavorite(Integer.class));
        System.out.println("height: " + favorites.getFavorite(Float.class));
    }
}

class Favorites {

    Map<Class<?>, Object> mFavorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        // 用cast方法保证添加进的key永远是T类型的实例，只要执行了一个动态转化就可以了
        mFavorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        // 将Object对象转换为T对象
        return type.cast(mFavorites.get(type));
    }
}