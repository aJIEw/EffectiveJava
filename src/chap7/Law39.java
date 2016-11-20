package chap7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 第39条：必要时进行防御性拷贝（defensive copy）。
 */
public class Law39 {

    public static final String[] STRINGS = {};
    /**
     * 将数组转换为不可变视图
     * */
    public static final List<String> STRING_LIST = Collections.unmodifiableList(Arrays.asList(STRINGS));

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        Period period = new Period(start, end);
        System.out.println(period);

        // 使用了防御性拷贝，域不会被修改
        end.setTime(133);
        System.out.println(period);
    }
}

final class Period{
    /**
     * 虽然是final域，但Date对象是可变的
     * */
    private final Date mStart;
    private final Date mEnd;

    public Period(Date start, Date end) {

        // 使用防御性拷贝，防止域被篡改，比如调用Date.setTime()更改时间
        // 在检查参数有效性之前进行防御性拷贝是为了避免TOC攻击
        mStart = new Date(start.getTime());
        mEnd = new Date(start.getTime());

        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }

        //mStart = start;
        //mEnd = end;
    }

    /**
     * 同样为了防御调用get方法修改域，我们也必须修改get方法，使它返回可变内部域的防御性拷贝
     * */
    public Date getStart() {
        return new Date(mStart.getTime());
    }

    public Date getEnd() {
        return new Date(mEnd.getTime());
    }

    @Override
    public String toString() {
        return mStart + " to " + mEnd;
    }
}
