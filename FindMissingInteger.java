import java.util.Scanner;

public class FindMissingInteger {

    private static void PrintMissingInt(int[] copy) {


    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        s.nextLine(); // throw away the newline.

        int[] numbers = new int[count];
        Scanner numScanner = new Scanner(s.nextLine());
        for (int i = 0; i < count; i++) {
            if (numScanner.hasNextInt()) {
                numbers[i] = numScanner.nextInt();
            }
            else {
                System.out.println("You didn't provide enough numbers");
                break;
            }
        }

        PrintMissingInt(numbers);

    }

}
