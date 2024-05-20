import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordAmount = scanner.nextInt();
        scanner.nextLine();
        String[] words = scanner.nextLine().split(" ");
        
        for (int i = 0; i < words.length; i++) {
            words[i] = sortString(words[i]);
        }

        Arrays.sort(words);
        int count = 0;
        
        for (int i = 0; i < wordAmount; ) {
            for (int j = i; j < wordAmount; j++) {
                if (!words[i].equals(words[j])) {
                    i = j;
                    break;
                }
                if (j == wordAmount - 1) {
                    i = wordAmount;
                }
            }
            count++;
        }

        System.out.println(count);
        scanner.close();        
    }

    public static String sortString(String string) {
        char[] temp = string.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}
