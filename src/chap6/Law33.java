package chap6;

import java.util.Set;

/**
 * 第33条：用EnumMap代替序数索引。
 */
public class Law33 {
}

class Herb {
    enum Type {
        ANNUAL, PERENNIAL, BIENNIAL
    }

    private final String mName;
    private final Type mType;

    public Herb(String name, Type type) {
        mName = name;
        mType = type;
    }

    @Override
    public String toString() {
        return mName;
    }
}
