import java.util.Scanner;

public class ex6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of the map's height: ");
        int matrixHeight = input.nextInt();

        System.out.print("Enter the length of the map's length: ");
        int matrixLength = input.nextInt();

        String[][] matrix = new String[matrixHeight][matrixLength];
        fillMatrixData(input, matrix, matrixHeight, matrixLength);

        System.out.println();
        printMatrix(matrix, matrixLength, matrixHeight);
        System.out.print("Enter the player's X coordinate on the map: ");
        int xCoordinate = input.nextInt();
        System.out.print("Enter the player's Y coordinate on the map: ");
        int yCoordinate = input.nextInt();

    }

    public static void fillMatrixData(Scanner input, String[][] matrix, int height, int length) {

        System.out.println("Enter the map's roads (X = wall, . = road): ");

        for (int col = 0; col < height; col++) {
            for (int row = 0; row < length; row++) {
                matrix[col][row] = input.next();
            }
        }
    }

    public static void printMatrix(String[][] matrix, int length, int height) {
        for (int col = 0; col < height; col++) {
            for (int row = 0; row < length; row++) {
                System.out.print(matrix[col][row] + "\t");
            }
            System.out.println();
        }
    }

}
