 import java.util.Random;
import java.util.Scanner;

public class AssignmentEleven {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    String[]wordList = {"apple","orange","grapes","mango"};

    System.out.println("Welcome to the word scramble game");
    System.out.println("Unscramble the word");

    int score=0;
    boolean keepPlaying = true;

    while (keepPlaying) {
        String word = wordList[random.nextInt(wordList.length)];
        String scrambleWord = scrambleWord(word,random);
        System.out.println("The Scrambled word is : " + scrambleWord);

      boolean wordGuessed = false;
      int attempts = 3;
      while (attempts > 0 && !wordGuessed){
        System.out.println("Guess the word");
        String userGuess = sc.nextLine();
        if(userGuess.equalsIgnoreCase(word)){
          System.out.println("Correct! Your guessed the right");
          score++;
          wordGuessed = true;
        }else{
          attempts--;
          System.out.println("Wrong! you have " + attempts + "attempts left");
        }
      }

      if (!wordGuessed){
        System.out.println("The correct word was: " + word);
      }
      System.out.println("Your current score is : " + score);
      System.out.println("Do you want to play again? (yes/no)");
      String response = sc.nextLine();
      keepPlaying = response.equalsIgnoreCase("yes");
    }
    System.out.println("Thank you for playing.Your final score is : " + score);
        }
          public static String scrambleWord(String word, Random random){
            char[]letters = word.toCharArray();
            for(int i=0; i<letters.length;i++){
                int j = random.nextInt(letters.length);
                char temp = letters[i];
                letters[i] = letters[j];
                letters[j] = temp;

            }
            return new String(letters);

          }

    }

    