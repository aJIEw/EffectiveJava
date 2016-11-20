package chap2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 第6条;消除过期的对象引用
 *
 * 内存泄漏的三个来源：类自己管理内存，缓存，监听器和其他回调。
 */
public class Law6 {
}

class Stack{
    public static final int DEFAULT_SIZE = 10;
    private Object[] mArray;
    private int mTop;

    public Stack() {
        mArray = new Object[DEFAULT_SIZE];
    }

    public Stack(int mTop) {
        this.mTop = mTop;
    }

    public void push(Object obj){
        if (mArray.length == mTop) {
            mArray = Arrays.copyOf(mArray, 2 * mTop + 1);
        }
        mArray[mTop++] = obj;
    }

    /**
     * @return 返回当前栈顶元素
     *
     * 但是这样的写法会造成内存泄漏。
     * 数组活动部分是已分配的而其余部分则是自由的，此时被“删除”的对象不会被gc回收。
     * 但是垃圾回收器不知道这一点，它将所有对象引用都视为同等有效。
     * */
    public Object pop() {
        if (mTop == 0) throw new EmptyStackException();
        return mArray[--mTop];
    }

    public int size() {
        return mTop + 1;
    }
}

class Stack2{
    public static final int DEFAULT_SIZE = 10;
    private Object[] mArray;
    private int mTop;

    public Stack2() {
        mArray = new Object[DEFAULT_SIZE];
    }

    public Stack2(int mTop) {
        this.mTop = mTop;
    }

    public void push(Object obj){
        if (mArray.length == mTop) {
            mArray = Arrays.copyOf(mArray, 2 * mTop + 1);
        }
        mArray[mTop++] = obj;
    }

    /**
     * 正确的做法是将清空过期的对象引用
     * */
    public Object pop() {
        if (mArray.length == 0) throw new EmptyStackException();

        Object result = mArray[--mTop];
        mArray[mTop] = null;
        return result;
    }

    public int size() {
        return mTop + 1;
    }
}