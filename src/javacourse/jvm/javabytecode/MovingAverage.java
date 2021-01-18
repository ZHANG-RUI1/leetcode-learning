package javacourse.jvm.javabytecode;

/**
 * @author zhangrui
 * @version 1.0
 * @date 2021/1/7 12:05
 */

public class MovingAverage {
    private int count = 0;
    private double sum = 0.0D;
    public void submit(double value){
        this.count ++;
        this.sum += value;
    }
    public double getAvg(){
        if(0 == this.count){ return sum; }
        return this.sum/this.count;
    }


}
