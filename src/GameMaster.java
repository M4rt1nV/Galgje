import java.util.Scanner;

public class GameMaster {
  MysteryWord Guessword;
  int Errors;
  public GameMaster(){
    Guessword = new MysteryWord();
    Errors = 0;
  }


  public void PlayGame(){
    Scanner GameOn = new Scanner(System.in);
    System.out.println("Do you want to play a game? (yes / no)");
    String Gaming = GameOn.nextLine().toUpperCase();
    while(Gaming.equals("YES")){
      RunGame();
      System.out.println("Would you like to go again?");
      Gaming = GameOn.nextLine().toUpperCase();
      if (Gaming.equals("YES")) {
        this.Guessword.Reset();
        this.Errors = 0;
      }
      else{
        break;
      }
    }
  }

  public void RunGame(){
    System.out.println(this.Guessword.GuessWord);
    System.out.println(this.Guessword.BlankWord);
    while (this.Guessword.BlankWord.contains(("_")) && this.Errors < 10) {
      this.LetterGuesser();
      System.out.println(this.Guessword.BlankWord);
      System.out.println(this.Guessword.Guesses);
      System.out.println("You have made " + this.Errors + " / 10 errors");
    }
    if(this.Guessword.BlankWord.contains(("_")) || this.Errors >= 10){
      System.out.println("You did not guess the word, it was " + this.Guessword.GuessWord.toLowerCase());
    }
    if(!this.Guessword.BlankWord.contains("_")){
      System.out.println("Congratulations, you guessed the word " + this.Guessword.GuessWord.toLowerCase());
    }
  }

  public boolean WordCheck(String Letter){
    return this.Guessword.GuessWord.contains(Letter.toUpperCase());
  }

  public void LetterGuesser() {
    // Asks the user for a letter input
    Scanner MyScan = new Scanner(System.in);
    System.out.println("Guess a letter:");
    String Letter = MyScan.nextLine().toLowerCase();
    if (this.Guessword.LetterChecker(Letter)) {
      this.Guessword.GuessFiller(Letter);
      if (this.WordCheck(Letter)){
        this.Guessword.BlankChange(Letter.toUpperCase());
      }
      else {
        this.Errors++;
      }
    }

  }
}
