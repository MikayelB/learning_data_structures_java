public class ex1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{30, 56, 30, 43};

//        example(arr1, arr2);
        exampleEff(arr1, arr2);

    }

    ///////////////// Below is the original code
    // the Big-O complexity is O(n^2) since there are 2 for loops one inside another depending on n's value

//    Returns the number of times second array stores sum of suffix sums form first
    public static int example(int[] first, int[] second){
        //assume equal-length arrays
        int n = first.length, count = 0, total = 0;
        for(int j = n - 1; j >= 0; j--)              // loop from n-1 to 0
            for(int k = n - 1; k >= j; k--)          // loop from n-1 to j
                total += first[k];

        for (int i = 0; i < n; i++)                  // loop from 0 to n-1
            if(second[i] == total) count++;

        System.out.println("There are " + count + " matches");
        return count;
    }

    ///////////////// Below is my, more efficient, code
    // the Big-O complexity of this one is O(n)

    public static int exampleEff(int[] first, int[] second){
        int n = first.length, count = 0, total = 0;

        for(int i = 0; i < n; i++){
            total += (i + 1) * first[i];
        }

        for (int i = 0; i < n; i++)
            if(second[i] == total) count++;

        System.out.println("There are " + count + " matches");
        return count;
    }

}

