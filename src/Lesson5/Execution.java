package Lesson5;

public class Execution {
    public static void main(String[] args){
        Multithread mult1 = new Multithread();
        Multithread mult2 = new Multithread();
        //1
        long start = System.currentTimeMillis();
        mult1.singleThreadCalculation();
        System.out.println("one thread calculation = "+(System.currentTimeMillis()-start + " millis"));

        //2
        start = System.currentTimeMillis();
        mult2.doubleThreadCalculation();
        System.out.println("two threads calculation= "+(System.currentTimeMillis()-start) + " millis");

        //correctness check
        System.out.println(mult1.getArray()[3000000]);
        System.out.println(mult2.getArray()[3000000]);
    }
}