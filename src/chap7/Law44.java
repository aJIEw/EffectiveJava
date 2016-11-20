package chap7;

/**
 * 第44条：为所有导出的API元素编写文档注释
 */
public class Law44 {

    /**
     * Javadoc can produce a very good documentation comment, like this one.
     * <p>
     * You can add HTML tags in Javadoc,<i>like this</i>.
     * <p>
     * If you want to use HTML tags, you can use {@literal @literal with two big brace.
     * Then you can use '<' '>' and '&'}
     * <p>
     * if you want to add links, use {@literal @link} like this one {@link #test(int)}
     * <p>
     * You can also add code {@code for(int i = 0; i < 10; i++)}.
     * <p>
     * if there are multiple line, please use {@literal <pre>}
     * <p>
     * You can use {@literal @inheritDoc} to inherit super class's documentation.
     * <pre>if(i < 0){
     *     throws new ArithmeticException();
     * }
     * </pre>
     * Remember you do not have to add period in {@literal @return @param or @throws}
     *
     * @param i explain why this parameter is needed
     * @return return type
     * @throws ClassNotFoundException explain why this Exception will be thrown
     */
    public int test(int i) throws ClassNotFoundException {
        return i;
    }

}
