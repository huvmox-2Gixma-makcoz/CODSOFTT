import java.util.*;

public class Guess1to100 {
    static final int MAX_ATTEMPTS = 4;
    static final int MIN = 1;
    static final int MAX = 100;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🎯 Welcome to the 1 to 100 Number Guessing Game!");
        int totalScore = 0;
        int roundsPlayed = 0;

        boolean playAgain;
        do {
            roundsPlayed++;
            int target = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\n🔁 Round " + roundsPlayed + " begins!");
            System.out.println("Guess a number between 1 and 100. You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Your guess: ");
                int guess = getValidInput();
                attempts++;

                if (guess == target) {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    int roundScore = (MAX_ATTEMPTS - attempts + 1) * 10;
                    totalScore += roundScore;
                    guessed = true;
                    break;
                } else if (guess < target) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessed) {
                System.out.println("❌ Sorry, you're out of attempts! The correct number was: " + target);
            }

            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\n🏁 Game Over!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total score: " + totalScore + " points");
        System.out.println("👋 Thanks for playing!");
    }

    static int getValidInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= MIN && input <= MAX) return input;
                else System.out.print("🚫 Enter a number between 1 and 100: ");
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Invalid input. Enter a number: ");
            }
        }
    }
}
