import java.util.Scanner;
import java.util.Random;

public class Wordle {

    final static String BG_GREEN = "\u001b[42m";
    final static String BG_YELLOW = "\u001b[43m";
    final static String BG_RESET = "\u001b[0m";
    
    public static void main(String [] args){

        Random random = new Random();
        int x = random.nextInt(4);
        int counter = 7;
        boolean dupChar = false;

        System.out.println("WORDLE!! ");

        String [] correctWords = {"GRAPE", "RADIO", "TIMER", "RIVER", "CLOUD"};
        String correct = correctWords[x];
        String guess = "PURGE";

        System.out.print("Guess the five letter word: ");
        Scanner in = new Scanner(System.in);
        guess = in.nextLine().toUpperCase().replace(" ", "");

        while(counter > 0){

            while(guess.length() < correct.length()){
                System.out.println("Longer guess required");
                guess = in.nextLine().toUpperCase().replace(" ", "");
            }

            for (int i = 0; i < 5; i++){
                if(guess.substring(i,i+1).equals(correct.substring(i, i+1))){
                    System.out.print(BG_GREEN + guess.substring(i, i+1) + BG_RESET);

                } else if (correct.contains(guess.substring(i, i+1))) {
                    for (int j = 0; j < 5; j++){
                        if(correct.substring(i, i+1).equals(guess.substring(j, j+1)));
                            System.out.print(BG_RESET + guess.substring(i, i+1) + BG_RESET);
                            dupChar = true;
                            break;
                    }

                    if(dupChar = true){
                        continue;
                    }
                    System.out.print(BG_YELLOW + guess.substring(i, i+1) + BG_RESET);

                } else {
                    System.out.print(guess.substring(i, i+1));
                }
            }
            System.out.println("");
            if (guess.equalsIgnoreCase(correct)){
                System.out.println("You got it correct!");
                break;
            }

            counter--;
            System.out.print(counter + " left! Guess again!: ");
            guess = in.nextLine().toUpperCase().replace(" ", "");
        }
    }
}