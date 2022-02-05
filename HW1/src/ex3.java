import java.nio.file.LinkPermission;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the matrix's side (must be odd): ");
        int matrixLength = input.nextInt();

        int[][] matrix = new int[matrixLength][matrixLength];
        fillMatrixData(input, matrix, matrixLength);
        printMatrix(matrix, matrixLength);

        int middle = (int)Math.ceil((matrixLength / 2));
        System.out.println(middle);
        int matrixMid = matrix[middle][middle];
        System.out.println(matrixMid);

        movingToCenter(matrix, matrixLength, middle);
        printMatrix(matrix, matrixLength);


    }

    public static int[][] movingToCenter(int[][] matrix, int size, int mid){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrix[i][j] ==  0){
                    if(j < mid){
                        int temp = matrix[i][j+1];
                        matrix[i][j+1] = matrix[i][j];
                        matrix[i][j] = temp;
                    }
                    if(j > mid){
                        int temp = matrix[i][j-1];
                        matrix[i][j-1] = matrix[i][j];
                        matrix[i][j] = temp;
                        j-= 2;
                    }
                }
            }
        }

        return matrix;

    }

    public static void fillMatrixData(Scanner input, int[][] matrix, int size){
        System.out.println("Enter the matrix's data: ");

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
    }

    public static void printMatrix(int[][] matrix, int size){
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
