package chap9;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * 第61条：抛出与抽象相对应的异常。
 *
 * 异常转译：更高层次的实现应该捕获低层的异常，同时抛出可以按照高层抽象进行解释的异常。
 */
public class Law61 {

    class ExceptionList<E>{

        List<E> mList = new ArrayList<E>();

        /**
         * 使用异常转译
         * */
        public E get(int index) {
            ListIterator<E> itr = mList.listIterator();
            try {
                // 如果没有该index上的元素，说明index超出了List的范围，因此需要进行异常转译
                return itr.next();
            } catch (NoSuchElementException e) {
                throw new IndexOutOfBoundsException("Index " + index);
            }
        }
    }
}
