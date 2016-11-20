package chap4;


import java.math.BigInteger;

/**
 * Law15的示例，使类成为不可变的类。
 * 该类表示一个复数，包含实部和虚部。
 */
public final class Complex {
    private final double mRealPart;
    private final double mImaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        mRealPart = realPart;
        mImaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return mRealPart;
    }

    public double getImaginaryPart() {
        return mImaginaryPart;
    }

    public Complex add(Complex complex) {
        return new Complex(mRealPart + complex.mRealPart,
                mImaginaryPart + complex.mImaginaryPart);
    }

    public Complex subtract(Complex complex) {
        return new Complex(mRealPart - complex.mRealPart,
                mImaginaryPart - complex.mImaginaryPart);
    }

    public Complex mutiply(Complex complex) {
        return new Complex(mRealPart + complex.mRealPart,
                mImaginaryPart * complex.mImaginaryPart);
    }

    public Complex divide(Complex complex) {
        return new Complex(mRealPart / complex.mRealPart,
                mImaginaryPart / complex.mImaginaryPart);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }

        Complex c = (Complex) obj;
        return Double.compare(mRealPart, c.mRealPart) == 0
                && Double.compare(mImaginaryPart, c.mImaginaryPart)==0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(mRealPart);
        result = 31 * result + hashDouble(mImaginaryPart);
        return result;
    }

    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(mRealPart);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + mRealPart + " + " + mImaginaryPart;
    }
}
