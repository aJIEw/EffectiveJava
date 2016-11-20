package chap3;

import java.util.HashMap;
import java.util.Map;

/**
 * 第9条：覆盖equals总要覆盖hashCode()方法
 */
public class Law9 {

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<>();
        PhoneNumber phoneNumber = new PhoneNumber(1, 2, 3);
        map.put(phoneNumber, "Aaron");

        // 没有覆写hashCode返回null
        System.out.println(map.get(new PhoneNumber(1, 2, 3)));
    }
}
