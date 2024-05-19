import java.lang.System;
import java.util.Scanner;

public class GameSimulator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int player = Integer.parseInt(scanner.nextLine());
        String seeker = scanner.nextLine();
        HideNSeek game = new HideNSeek(seeker, player);
        System.out.println("Game dimulai dengan " + player + " pemain, seeker adalah " + seeker);
        boolean ongoing = true;
        while (ongoing){
            int input = Integer.parseInt(scanner.nextLine());
            if (input == game.getPlayerFound()+1){
                System.out.println(input + " Pemain ditemukan");
                game.foundPlayer();
            }
            if (game.getPlayerFound() == game.getPlayer()-1){
                ongoing = false;
                System.out.println("Semua pemain telah ditemukan, permainan selesai.");
            }
        }
        scanner.close();
    }
}
