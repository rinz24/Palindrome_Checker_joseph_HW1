import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

// Reffrence https://bradfieldcs.com/algos/deques/palindrome-checker/ , https://www.programiz.com/java-programming/examples/palindrome-number , https://www.baeldung.com/java-palindrome , https://beginnersbook.com/2014/01/java-program-to-check-palindrome-string/

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");
        String input = scanner.nextLine();

        // Using stack to check palindrome
        if (isPalindromeStack(input)) {
            System.out.println("YEUP....THAT IS A PALINDROME! (Using Stack)");
        } else {
            System.out.println("NOPE THAT AINT A PALINDROME! (Using Stack)");
        }

        // Using queue to check palindrome
        if (isPalindromeQueue(input)) {
            System.out.println("NOICE,THAT IS A PALINDROME! (Using Queue)");
        } else {
            System.out.println("E..OOO WRONGGG THATS NOT A PALINDROME! (Using Queue)");
        }

        // Close the Scanner
        scanner.close();
    }

    // Method to check palindrome using stack
    public static boolean isPalindromeStack(String input) {
        Stack<Character> stack = new Stack<>();
        int length = input.length();
        int mid = length / 2;

        // Pushing the first half of the characters onto the stack
        for (int i = 0; i < mid; i++) {
            stack.push(input.charAt(i));
        }

        int start;
        if (length % 2 == 0) {
            start = mid;
        } else {
            start = mid + 1;
        }

        // Checking the second half of the characters against the stack
        // using stack pop to remove the last half of the characters
        for (int i = start; i < length; i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Method to check palindrome using queue
    public static boolean isPalindromeQueue(String input) {
        Queue<Character> queue = new LinkedList<>();
        int length = input.length();

        // Adding characters in reverse order to the queue
        for (int i = length - 1; i >= 0; i--) {
            queue.add(input.charAt(i));
        }

        // Comparing characters from the original string with characters from the queue
        for (int i = 0; i < length; i++) {
            if (input.charAt(i) != queue.remove()) {
                return false;
            }
        }

        return true;
    }
}
// belongs to arin / ris 
// you can input words or numbers