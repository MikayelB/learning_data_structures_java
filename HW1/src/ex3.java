import java.nio.file.LinkPermission;
import java.util.Scanner;

public class ex3 {

    ///-----------Below is my non-efficient way (which took way too much time), the correct way to solve this is lower

    /*
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the matrix's side (must be odd): ");
        int matrixLength = input.nextInt();

        int[][] matrix = new int[matrixLength][matrixLength];
        fillMatrixData(input, matrix, matrixLength);
//        printMatrix(matrix, matrixLength);             // to print the inputted matrix

        int middle = (int) Math.ceil((matrixLength / 2));
        int matrixMid = matrix[middle][middle];

        System.out.println(movingToCenter(matrix, matrixLength, middle));
//        printMatrix(matrix, matrixLength);             // to print the finished matrix


    }

    public static int movingToCenter(int[][] matrix, int size, int mid) {
        int stepCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 0) {
                    if (j < mid) {
                        int temp = matrix[i][j + 1];
                        matrix[i][j + 1] = matrix[i][j];
                        matrix[i][j] = temp;
                        stepCount++;

                    }
                    if (j > mid) {
                        int temp = matrix[i][j - 1];
                        matrix[i][j - 1] = matrix[i][j];
                        matrix[i][j] = temp;
                        j -= 2;              // since the loop is moving forward we need this to get the j back on track
                        stepCount++;

                    }
                }
            }
            if (matrix[i][mid] == 0) {
                if (i < mid) {
                    int temp = matrix[i + 1][mid];
                    matrix[i + 1][mid] = matrix[i][mid];
                    matrix[i][mid] = temp;
                    stepCount++;

                }
                if (i > mid) {
                    int temp = matrix[i - 1][mid];
                    matrix[i - 1][mid] = matrix[i][mid];
                    matrix[i][mid] = temp;
                    stepCount++;

                }
            }
        }

        return stepCount;

    }

    public static void fillMatrixData(Scanner input, int[][] matrix, int size) {
        System.out.println("Enter the matrix's data (must have only one 0): ");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

*/


    ///-----------Below is the correct way, I assume, which I realized after solving the problem with the first way
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the matrix's side (must be odd): ");
        int matrixLength = input.nextInt();

        int[][] matrix = new int[matrixLength][matrixLength];
        fillMatrixData(input, matrix, matrixLength);

        System.out.println(stepCoutner(matrix, matrixLength));

    }

    public static void fillMatrixData(Scanner input, int[][] matrix, int size) {

        System.out.println("Enter the matrix's data (must have only one 0): ");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
    }

    public static int stepCoutner(int[][] matrix, int matrixLength){

        int middle = (int) Math.ceil((matrixLength / 2));
        int stepCount = 0;


        for(int i = 0; i < matrixLength; i++){
            for(int j = 0; j < matrixLength; j++){
                if(matrix[i][j] == 0){
                    if(i != middle){
                        stepCount += Math.abs(middle - i);
                    }
                    if(j != middle){
                        stepCount += Math.abs(middle - j);
                    }
                }
            }
        }
        return stepCount;
    }

// tight-bound = O(n^2)
// worst case complexity = O(n^2)
// when the 0 is in the end of the matrix (bottom right) and there have been many iterations done just to reach that point
}
