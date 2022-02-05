
import java.util.Scanner;

public class ex4 {
    public static char[] vowels = new char[]{'e', 'i'};
    public static char[] consonants = new char[]{'f', 'g', 'h'};
    public static char[] both = new char[]{'e', 'i', 'f', 'g', 'h'};

    public static void main(String[] args) {
        System.out.println("Enter the length: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        recursiveString(n, 0, both, "");
    }

    public static void recursiveString(int n, int pointer, char[] array, String result) {
        if (pointer < n) {
            for (char c : array) {
                String newLine = result + c;

                if (result.equals("")) {
                    recursiveString(n, pointer + 1, both, newLine);
                } else if (new String(vowels).contains(result.charAt(result.length() - 1) + "")) {
                    if (new String(vowels).contains(c + "")) {
                        recursiveString(n, pointer + 1, consonants, newLine);
                    } else {
                        recursiveString(n, pointer + 1, both, newLine);
                    }
                } else if (new String(consonants).contains(result.charAt(result.length() - 1) + "")) {
                    if (new String(consonants).contains(c + "")) {
                        recursiveString(n, pointer + 1, vowels, newLine);
                    } else {
                        recursiveString(n, pointer + 1, both, newLine);
                    }
                }
            }
        } else {
            System.out.println(result);
        }
    }
    
}
