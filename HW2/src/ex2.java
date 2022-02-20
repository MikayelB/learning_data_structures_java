import java.util.Arrays;
import java.util.Scanner;

public class ex2 {

    public static void main(String[] args) {

        // input section-------------------------------------
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of columns: ");
        int colNumber = input.nextInt();

        int [] eachColumn = new int[colNumber];
        for(int i = 0; i < eachColumn.length; i++){
            System.out.println("Enter the number of blocks in column " + (i + 1) + ": ");
            int n = input.nextInt();
            eachColumn[i] = n;
        }
        //----------------------------------------------------


        // printing the original array of cubes in columns
        System.out.println("The initial cube count in each column is: ");
        printTheArray(eachColumn);

        // Sorting        the runtime is O(nlogn)
        mergeSort(eachColumn);

        // printing the final array of cubes in columns
        System.out.println("The final cube count in each column is: ");
        printTheArray(eachColumn);


    }
    // array printing function
    public static void printTheArray(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.println("Column " + (i + 1) + ": " + arr[i] + " cubes");
        }
    }

    
    // Merge Sort        the runtime is O(nlogn)
    public static void mergeSort(int[] arrOriginal){

        int length = arrOriginal.length;

        if( length < 2) return;

        // divide
        int mid = length / 2;
        int [] arr1 = Arrays.copyOfRange(arrOriginal, 0, mid);
        int [] arr2 = Arrays.copyOfRange(arrOriginal, mid, length);

        // conquer
        mergeSort(arr1);
        mergeSort(arr2);
        // merge
        merge(arr1, arr2, arrOriginal);
    }


    // Merge
    public static void merge(int[] arr1, int[] arr2, int[] arrFullSized) {
        int i = 0;
        int j = 0;

        while (i + j < arrFullSized.length) {
            if (j == arr2.length || (i < arr1.length && arr1[i] > arr2[j])) {
                arrFullSized[i + j] = arr1[i];   // if the above statement is true the i-th element is filled in the final array
                i++;  // increment to compare the next element
            } else {
                arrFullSized[i + j] = arr2[j];  // if the statement in if, is false the j-th element is filled in the final array
                j++;  // increment to compare the next element
            }
        }
    }
}
