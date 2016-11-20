package chap4;

/**
 * 第14条：在公有类中使用访问方法而非公有域
 */
public class Law14 {

    public class Point{
        /**
         * 不要用公有域暴露数据
         * */
        private double x;
        private double y;

        public Point(double x) {
            this.x = x;
        }

        /**
         * 而是用setter或者getter获取数据
         * */
        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }


    public static final class Time{
        private static final int HOURS_PER_DAY = 24;
        private static final int MINUTES_PER_HOUR = 60;

        /**
         * 当域是final时，危害也比直接暴露域要小一点
         * */
        public final int hour;
        public final int minute;

        public Time(int hour, int minute) {
            if (hour < 0 || hour > HOURS_PER_DAY) {
                throw new IllegalArgumentException("Hour: " + hour);
            }
            if (minute < 0 || minute > MINUTES_PER_HOUR) {
                throw new IllegalArgumentException("Minute: " + minute);
            }

            this.hour = hour;
            this.minute = minute;
        }

    }
}