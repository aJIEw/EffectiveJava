package chap6;

import java.util.EnumSet;
import java.util.Set;

/**
 * 第32条：用EnumSet代替位域。
 */
public class Law32 {

    enum Style{
        BOLD,ITALIC,UNDERLINE,STRIKETHROUGH;
    }

    public void applyStyle(Set<Style> styles) {
        System.out.println(styles);
    }

    public static void main(String[] args) {
        // 用EnumSet显然可读性更好
        new Law32().applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

/**
 * 用位域实现
 * */
class Text{
    private static final int STYLE_BOLD = 1 << 0;
    private static final int STYLE_ITALIC = 1 << 1;
    private static final int STYLE_UNDERLINE = 1 << 2;
    private static final int STYLE_STRIKETHROUGH = 1 << 3;

    public void applyStyles(int styles) {
        System.out.println(styles);
    }

    public static void main(String[] args) {
        Text text = new Text();
        // 位域以数字形式，难以理解
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }
}