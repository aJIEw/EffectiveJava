package chap4;

/**
 * 第20条：类层次优于标签类。
 *
 * 标签类的缺点：过于冗长、容易出错，并且效率低下。
 */
public class Law20 {
    /**
     * 典型的标签类
     * */
    static class Figure{
        enum Shape{
            RECTANGLE,CIRCLE;
        }

        // 标签域，当前图像的形状
        final Shape mShape;

        double mLength;
        double mWidth;
        double mRadius;

        // 圆形的初始化
        public Figure(double radius) {
            mShape = Shape.CIRCLE;
            mRadius = radius;
        }

        // 矩形的初始化
        public Figure(double length, double width) {
            mShape = Shape.RECTANGLE;
            mLength = length;
            mWidth = width;
        }

        // 返回面积
        double area(){
            switch (mShape) {
                case RECTANGLE:
                    return mLength * mWidth;
                case CIRCLE:
                    return Math.pow(mRadius, 2) * Math.PI;
                default:
                    throw new UnsupportedOperationException("Shape " + mShape);
            }
        }
    }
}

/**
 * 用类层次结构实现Figure，子类型化
 * */
abstract class Figure{
    abstract double area();
}

class Circle extends Figure {

    final double mRadius;

    public Circle(double radius) {
        mRadius = radius;
    }

    @Override
    double area() {
        return Math.PI * mRadius * mRadius;
    }
}

class Rectangle extends Figure {

    final double mWidth;
    final double mLength;

    public Rectangle(double width, double length) {
        mWidth = width;
        mLength = length;
    }

    @Override
    double area() {
        return mWidth * mLength;
    }
}