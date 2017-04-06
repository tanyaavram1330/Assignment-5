/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignemnt5;

import java.util.Scanner;

/**
 *
 * @author anisoaraavram
 */
public class A5Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //create a scanner 
        Scanner input = new Scanner(System.in);

        //telling the two users how to play the game
        System.out.println("This is a two player hangman game. The first player will "
                + "input their word of choice.");
        System.out.println("After the first player inputed their word of choice several "
                + "lines will appear to help ");
        System.out.println("the second player to determin how many letters there are "
                + "within the word. The second ");
        System.out.println("player will try to guess the word by inputing a letter "
                + "into the computer. If the ");
        System.out.println("second player guesses the letter correctly then it'll "
                + "appear within the lines. If ");
        System.out.println("guessed incorrectly the second player will lose a life. "
                + "The guessing player has ");
        System.out.println("a maximum of six lives. Good luck.");

        String answer = "yes";

        while (answer.equals("yes")) {
            //Statment if the game is going to play again or not
            int replay = 0;

            //creating a counter
            int counter = 1;

            //how many lives the user has
            int lives = 6;

            //counter to guess how many letters that the user gets correct
            int correct = 0;

            //creating a boolean to cheack if game is done
            boolean finished = false;

            //blank space
            System.out.println("");

            //telling the first user to enter in word for the second user to guess
            System.out.println("Player 1: Enter in a word for the second player to guess.");

            //allowing the first user to input a word
            String word = input.nextLine();

            //converting all uppercase words into lower case
            word = word.toLowerCase();

            //chnging the word into a string
            String tempWord = word;

            //finding the length of the word
            int length = word.length();

            //defining a temporary character
            char temp = 0;

            //detecting certain characters inputed by the user
            for (int i = 0; i < length; i++) {
                char character = word.charAt(i);
                temp = word.charAt(i);
                //making sure to not allow the user to input these characters
                if (character == '1' || character == '2' || character == '3'
                        || character == '4' || character == '5' || character == '6'
                        || character == '7' || character == '8' || character == '9'
                        || character == '0') {

                    //telling the user that these characters aren't allowed
                    System.out.println("Sorry, that's not a word. Please retype in a word.");

                    //restarting the code
                    word = input.nextLine();
                    length = word.length();
                    i = -1;
                }

                //making sure to not allow the user to input these characters
                if (character == '!' || character == '@' || character == '#'
                        || character == '$' || character == '%' || character == '^'
                        || character == '&' || character == '*' || character == '('
                        || character == ')' || character == '~' || character == '{'
                        || character == '}' || character == '[' || character == ']'
                        || character == '`' || character == '<' || character == '>'
                        || character == '.' || character == ',' || character == '?'
                        || character == '/' || character == '"' || character == ';'
                        || character == '|' || character == '-' || character == '+'
                        || character == '=' || character == '_') {

                    //telling the user that these characters aren't allowed
                    System.out.println("Sorry, that's not a word. Please retype in a word.");

                    //restarting the code
                    word = input.nextLine();
                    length = word.length();
                    i = -1;
                }
            }

            //for statement to relpace the words with '-'
            for (int i = 0; i < length; i++) {
                String temporary = tempWord.substring(i, i + 1);
                char temp1 = temporary.charAt(0);

                //replacing the word with '-'
                word = word.replace(temp1, '-');
            }

            //blank spaces
            for (int i = 0; i < 30; i++) {
                System.out.println("");
            }

            //creating a stringbuilder to help where the strings can't, smarter than strings
            StringBuilder Build = new StringBuilder(word);

            //while loop on running the game [second user plays]
            while (lives > 0 && finished == false) {

                //for loop used to print out all letters in the hidden word
                for (int i = 0; i < word.length(); i++) {
                    System.out.print(Build.charAt(i) + " ");
                }

                //telling the second user to type
                System.out.println("");
                System.out.println("Player 2, you have " + lives + " lives left. "
                        + "Please enter in a letter.");
                //allowing the user to input
                String guess = input.nextLine();

                //if user inouts more than one letter. It only accepts the first one
                char firstWord = tempWord.charAt(0);

                //loop that goes and checks each letter
                for (int i = 0; i < word.length();) {
                    char letter = tempWord.charAt(i);

                    //if letter equals to the guess[coverted to char bc it doesn't like string]
                    if (letter == guess.charAt(0)) {

                        //sets 'i' into the guesed letter and checks if it's right to the letter
                        Build.setCharAt(i, letter);

                        //decreasing the counter
                        counter--;

                        correct++;
                    }

                    //increasing the counter
                    counter++;

                    //if the user inputs a wrong letter
                    if (counter > word.length()) {
                        //decrease number of lives 
                        lives--;
                        //output to user amount of lives left
                        System.out.println("Darn, wrong letter. You have " + lives + " lives left.");

                        //starting their 'hangman' death image
                        if (lives == 5) {
                            System.out.println("    +---+");
                            System.out.println("    |   |");
                            System.out.println("    0   |");
                            System.out.println("        |");
                            System.out.println("        |");
                            System.out.println("        |");
                            System.out.println("    =====");
                        }

                        //shows their 'hangman' second build
                        if (lives == 4) {
                            System.out.println("    +---+");
                            System.out.println("    |   |");
                            System.out.println("    0   |");
                            System.out.println("    |   |");
                            System.out.println("        |");
                            System.out.println("        |");
                            System.out.println("    =====");
                        }

                        //shows their 'hangman' semi-built
                        if (lives == 3) {
                            System.out.println("    +---+");
                            System.out.println("    |   |");
                            System.out.println("    0   |");
                            System.out.println("    |)  |");
                            System.out.println("        |");
                            System.out.println("        |");
                            System.out.println("    =====");
                        }

                        //shows their 'hangman' more semi-built
                        if (lives == 2) {
                            System.out.println("    +---+");
                            System.out.println("    |   |");
                            System.out.println("    0   |");
                            System.out.println("   (|)  |");
                            System.out.println("        |");
                            System.out.println("        |");
                            System.out.println("    =====");
                        }

                        //shows their 'hangman' almost dead
                        if (lives == 1) {
                            System.out.println("    +---+");
                            System.out.println("    |   |");
                            System.out.println("    0   |");
                            System.out.println("   (|)  |");
                            System.out.println("     )  |");
                            System.out.println("        |");
                            System.out.println("    =====");
                        }
                    }
                    //making i to move on to the next letter in the word.
                    i++;
                }

                //for loop used to print out all letters in the hidden word
                for (int i = 0; i < word.length(); i++) {
                    System.out.print(Build.charAt(i) + " ");
                }

                // blank space
                System.out.println("");

                //resets the counter back to 1 at the end of every cycle (Move)
                counter = 1;

                //blank space
                System.out.println("");

                //telling the user that they lost the game
                if (lives == 0) {
                    System.out.println("Oh no! You ran out of lives. Game Over.");

                    //Shows their 'hangman' finsihed
                    if (lives == 0) {
                        System.out.println("    +---+");
                        System.out.println("    |   |");
                        System.out.println("    0   |");
                        System.out.println("   (|)  |");
                        System.out.println("   ( )  |");
                        System.out.println("        |");
                        System.out.println("    =====");
                    }

                    System.out.println("The word that the first user has inputed was '"
                            + tempWord + "'.");

                    //asking the user if they want to play again
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Do you want to play again?");
                    System.out.println("Yes or no?");

                    //allowing the user to input their answer
                    answer = input.nextLine();

                    //changing the words into lower case
                    answer = answer.toLowerCase();

                    //easter egg within the code
                    if (answer.equals("easter bunny") || answer.equals("bunny")
                            || answer.equals("easter")) {

                        System.out.println("");
                        System.out.println(" (|_/)");
                        System.out.println(" (˚∆˚)");
                        System.out.println("©(∂ ∂)");
                        System.out.println("you found me");

                        finished = true;

                        break;
                    }

                    //Asking the user if they want to quit or not
                    //what heppens if they quit
                    if (answer.equals("no")) {
                        //tells the user that they quit
                        System.out.println("You quit the game!");
                        //stops the game
                        break;
                    }

                    //not allowing the user to type in any other answer than yes or no
                    while (!(answer.equals("yes"))) {
                        System.out.println("");
                        System.out.println("Why did you type that?");
                        System.out.println("");
                        System.out.println("Do you want to play again?");
                        System.out.println("Yes or no?");

                        //allowing the user to input their answer
                        answer = input.nextLine();

                        //changing the words into lower case
                        answer = answer.toLowerCase();

                        //Asking the user if they want to quit or not
                        //what heppens if they quit
                        if (answer.equals("no")) {
                            //tells the user that they quit
                            System.out.println("You quit the game!");

                            //stops the game by making the statment true
                            finished = true;

                            //stops the game
                            break;
                        }
                    }

                    //what happens if the user wants to continue the game
                    if (answer.equals("yes")) {
                        //telling the user that they have to restart the program to start again
                        System.out.println("Game restarted.");
                    }
                }

                //stating what happens if the correct words == to the length of the word
                if (correct == length) {

                    //printing out that the user won
                    System.out.println("Nice job! You win!");

                    //asking the user if they want to play again
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Do you want to play again?");
                    System.out.println("Yes or no?");
                    //allowing the user to input their answer
                    answer = input.nextLine();

                    //changing the words into lower case
                    answer = answer.toLowerCase();

                    //easter egg within the code
                    if (answer.equals("easter bunny") || answer.equals("bunny")
                            || answer.equals("easter")) {

                        System.out.println("");
                        System.out.println(" (|_/)");
                        System.out.println(" (˚∆˚)");
                        System.out.println("©(∂ ∂)");
                        System.out.println("you found me");

                        //stops the game by making the statment true
                        finished = true;

                        //stops the game
                        break;
                    }

                    //Asking the user if they want to quit or not
                    //what heppens if they quit
                    if (answer.equals("no")) {
                        //tells the user that they quit
                        System.out.println("You quit the game!");
                        //stops the game
                        break;
                    }

                    //not allowing the user to type in any other answer than yes or no
                    while (!(answer.equals("yes"))) {

                        System.out.println("");
                        System.out.println("Why did you type that?");
                        System.out.println("");
                        System.out.println("Do you want to play again?");
                        System.out.println("Yes or no?");

                        //allowing the user to input their answer
                        answer = input.nextLine();

                        //changing the words into lower case
                        answer = answer.toLowerCase();

                        //Asking the user if they want to quit or not
                        //what heppens if they quit
                        if (answer.equals("no")) {
                            //tells the user that they quit
                            System.out.println("You quit the game!");

                            //stops the game by making the statment true
                            finished = true;

                            //stops the game
                            break;
                        }

                    }

                    //what happens if the user wants to continue the game
                    if (answer.equals("yes")) {

                        //telling the user that they have to restart the program to start again
                        System.out.println("Game restarted.");
                        break;
                    }
                }
            }
        }
    }
}
