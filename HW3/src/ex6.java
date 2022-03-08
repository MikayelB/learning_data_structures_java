import sources.ArrayList;

public class ex6 {

    // quickSortInplace taken from the slides slightly edited
    public static void quickSortInPlace(ArrayList<Integer> S, int a, int b) {
        if (a >= b) return;

        int left = a + 1;
        int right = b;
        int pivot = S.get(a);
        int temp;

        while (left <= right) {
            while (left <= right && S.get(left) < pivot) left++;
            while (left <= right && S.get(right) > pivot) right--;
            if (left <= right) {

                temp = S.get(left);
                S.set(left, S.get(right));
                S.set(right, temp);

                left++;
                right--;
            }
        }
        temp = S.get(left);
        S.set(right, S.get(left);
        S.set(b, temp);

        quickSortInPlace(S, a, right - 1);
        quickSortInPlace(S, right + 1, b);

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(5);

//        ArrayList.add(4);
//        ArrayList.add(6);
//        ArrayList.add(2);
    }
}
