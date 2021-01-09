package jvm.javabytecode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2021/1/7 12:09
 */

public class LocalVariableTest {
    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage();
        int num1 = 1;
        int num2 = 2;
        ma.submit(num1);
        ma.submit(num2);
        double avg = ma.getAvg();
    }
}
