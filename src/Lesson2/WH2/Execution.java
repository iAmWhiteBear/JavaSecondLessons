package Lesson2.WH2;

import Lesson2.MyException;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 3. В методе main() вызвать полученный метод,
 * обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.
 */
public class Execution {
    public static final int DEPTH = 4;
    public static void main(String[] args) {
        String[][] correct = {
                {"1","2","3","4"},
                {"10","11","12","13"},
                {"20","21","22","23"},
                {"30","31","32","33"}
        };
        String[][] incorrect1 = {
                new String[4],
                new String[2],
                new String[4],
                new String[5]
        };

        String[][] incorrect2 = {
                {"10","20","30","43"},
                {"12","23","34","45"},
                {"32","FF","65","76"},
                {"11","87","82","91"}
        };

        Integer[][] result1 =  parseStringMatrixToInteger(correct);
//        Integer[][] result2 = parseStringMatrixToInteger(incorrect1);
//        Integer[][] result3 = parseStringMatrixToInteger(incorrect2);


        //DISPLAY RESULT
        int sum = 0;
        for(Integer[] arr: result1){
            for (Integer i: arr){
                sum += i;
            }
        }
        System.out.println("sum of all:"+sum);



    }

    public static void checkMatrixDimention(String[][] matrix){
        if (matrix.length!=DEPTH) throw new MyArraySizeException("incorrect amount of arrays");
        for (int i = 0; i < DEPTH; i++) {
            if (matrix[i].length!=DEPTH) throw new MyException(String.format("incorrect length of %d array",i));
        }
    }

    public static Integer[][] parseStringMatrixToInteger(String[][] matrix) {
        Integer[][] result = new Integer[4][4];
        checkMatrixDimention(matrix);
        for (int i = 0; i < DEPTH; i++) {
            for (int j = 0; j < DEPTH; j++) {
                try{
                    result[i][j] = Integer.parseInt(matrix[i][j]);
                }catch (NumberFormatException ex){
                    throw new MyArrayDataException(String.format("incorrect parsing in: %d line,  %d col",i,j),ex);
                }
            }
        }

        return result;
    }

}
