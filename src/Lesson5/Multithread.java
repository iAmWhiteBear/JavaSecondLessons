package Lesson5;

import java.util.Arrays;

public class Multithread {
    private final int SIZE = 4000000;
    private final int HALF = SIZE/2;
    private final float[] result;

    public Multithread() {
        result = new float[SIZE];
        Arrays.fill(result,1);
    }

    public void doCalculation(float[] arr, int start, int last){
        for (int i = start, j=0; i < last; i++, j++) {
            arr[j] = (float)(arr[j] * Math.sin(0.2f + (float)i / 5) * Math.cos(0.2f + (float)i / 5) * Math.cos(0.4f + (float)i / 2));
        }
    }

    public void singleThreadCalculation(){
        doCalculation(result,0,SIZE);
    }

    public void doubleThreadCalculation(){
        float[] first = new float[HALF];
        float[] second = new float[HALF];
        //разделение массива на 2
        System.arraycopy(result,0,first,0,HALF);
        System.arraycopy(result,HALF,second,0,HALF);
        //запуск потоков
        Thread firstThread = new Thread(() -> doCalculation(first,0,HALF));
        Thread secondThread = new Thread(() -> doCalculation(second,HALF,SIZE));
        firstThread.start();
        secondThread.start();
        try{
            firstThread.join();     //ожидание, пока они оба будут выполнены,
            secondThread.join();    //что бы слияние прошло корректно
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //слияние массивов обратно
        System.arraycopy(first,0,result,0,HALF);
        System.arraycopy(second,0,result,HALF,HALF);
    }

    public float[] getArray() {
        return result;
    }
}