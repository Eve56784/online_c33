package Task_GuessTheWord;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    private static boolean experience = false;

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            welcome();
            System.out.println("Do you want to play again? (y/n)");
            char playAgain = scanner.next().charAt(0);
            if (playAgain != 'y') {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
        }
    }

    public static void welcome() {
        Scanner scanner = new Scanner(System.in);
        if (!experience) {
            System.out.println("\u001B[35mHello, stranger. Are you familiar with the concept of GuessTheWord games? (y/n)");
            char choiceInstr = scanner.next().charAt(0);
            scanner.nextLine();
            if (choiceInstr == 'y') {
                System.out.println("Great! Let's get started.\u001B[0m");
            } else {
                System.out.println("The rules are simple: you choose difficulty and start guessing letters.");
                System.out.println("\u001B[33mNote: space symbol is also something you have to guess ;)\u001B[35m");
                System.out.println("As soon as you're confident enough, you can enter the word.");
                System.out.println("But\u001B[31m remember\u001B[35m, attempts are limited!\u001B[0m");
            }
            experience = true;
        }
        char[] hiddenWord = getHiddenWord().toCharArray();
        char[] openWord = new char[hiddenWord.length];

        Arrays.fill(openWord, '*');
        playGame(hiddenWord, openWord);
    }

    public static String[] getArrayOfWords() {
        return new String[]{
                "Fran bow",
                "Sally face",
                "Yandere sim",
                "Minecraft",
                "Fortnite",
                "Overwatch",
                "Stardew Valley",
                "Among Us",
                "Cyberpunk",
                "The Witcher",
                "Dark Souls",
                "Pocket Love",
                "Solitaire",
                "Undertale",
                "Pony Town"
        };
    }

    public static String getHiddenWord() {
        String[] hiddenWord = getArrayOfWords();
        return hiddenWord[new Random().nextInt(hiddenWord.length)];
    }

    public static void printWord(char[] word) {
        for (char element : word) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void playGame(char[] hiddenWord, char[] openWord) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hey, stay alert! You need to choose your difficulty.");
        System.out.print("Press n for \u001B[32mNoob\u001B[0m, i for \u001B[33mIntermediate\u001B[0m, and p for \u001B[31mPro:\u001B[0m");
        char diff = scanner.next().charAt(0);
        scanner.nextLine();
        int attempts;
        switch (diff){
            case 'n':
                attempts = 33;
                break;
            case 'i':
                attempts = 15;
                break;
            case 'p':
                attempts = 5;
                break;
            default:
                System.out.println("Something went wrong. Try again and be more careful with that keyboard of yours.");
                return;
        }
        String hiddenWordLower = new String(hiddenWord).toLowerCase();

        while (attempts > 0) {
            System.out.println("\nCurrent word: ");
            printWord(openWord);
            System.out.println("Attempts left: " + attempts + "\nEnter a letter or guess the word: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.length() == 1) {
                char userGuess = userInput.charAt(0);
                boolean correctGuess = false;
                for (int i = 0; i < hiddenWord.length; i++) {
                    if (hiddenWordLower.charAt(i) == userGuess) {
                        openWord[i] = hiddenWord[i];
                        correctGuess = true;
                    }
                }
                if (!correctGuess) {
                    attempts--;
                }
            } else if (userInput.equals(hiddenWordLower)) {
                System.out.println("Congrats! You've guessed the word: " + new String(hiddenWord));
                return;
            } else {
                attempts--;
            }

            if (Arrays.equals(hiddenWord, openWord)) {
                System.out.println("Congrats! You won!");
                return;
            }
        }
        System.out.println("You've run out of attempts, bud :( The word was: " + new String(hiddenWord));
    }
}
