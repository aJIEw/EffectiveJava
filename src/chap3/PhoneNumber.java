package chap3;

/**
 * 本章用于示例所有对象都适用的方法类
 */
public class PhoneNumber {
    private final short mAreaCode;
    private final short mPrefix;
    private final int mLineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 9999, "prefix");
        rangeCheck(lineNumber, 99999999, "line number");
        mAreaCode = (short) areaCode;
        mPrefix = (short) prefix;
        mLineNumber = lineNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof PhoneNumber)) return false;

        PhoneNumber theOther = (PhoneNumber) obj;
        return theOther.mAreaCode == mAreaCode
                && theOther.mPrefix == mPrefix
                && theOther.mLineNumber == mLineNumber;
    }

    /**
     * 根据关键域返回hashCode，相等的对象会有相等的hashCode
     * */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + mAreaCode;
        result = 31 * result + mPrefix;
        result = 31 * result + mLineNumber;
        return result;
    }

    /**
     * 所有对象都应该覆写toString方法，推荐使用String.format()方法格式化返回值
     * */
    @Override
    public String toString() {
        return String.format("(%03d) %04d-%08d", mAreaCode, mPrefix, mLineNumber);
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }
}
