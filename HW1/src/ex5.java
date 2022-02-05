public class ex5 {


    public static void rec_print(int n, int row, int pointer) {
       if(row < n - 1) {
           if (pointer < n - row - 1) {
               System.out.print(" ");
               rec_print(n, row, pointer + 1);
           } else if (pointer == n + row - 1) {
               System.out.print("*\n");
               rec_print(n, row + 1, 0);
           } else if (pointer == n - 1 || pointer == n - row - 1) {
               System.out.print("*");
               rec_print(n, row, pointer + 1);
           } else {
               System.out.print(" ");
               rec_print(n, row, pointer + 1);
           }
       } else if(row == n - 1){
           if(pointer < 2 * n - 1){
               System.out.print("*");
               rec_print(n, row, pointer + 1);
           }else{
               System.out.print("\n");
               rec_print(n, row + 1, 0);
           }
       } else if(row < 2 * n - 1){
           if (pointer < row - n + 1) {
               System.out.print(" ");
               rec_print(n, row, pointer + 1);
           } else if (pointer == 3 * n - row - 3) {
               System.out.print("*\n");
               rec_print(n, row + 1, 0);
           } else if (pointer == n - 1 || pointer == row - n + 1) {
               System.out.print("*");
               rec_print(n, row, pointer + 1);
           } else {
               System.out.print(" ");
               rec_print(n, row, pointer + 1);
           }
       }
    }

    public static void printFigure(int n){
        rec_print(n, 0, 0);
    }

    public static void main(String[] args){
        printFigure(8);
    };
}
