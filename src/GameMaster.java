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
        Guessword = new MysteryWord();
        Errors = 0;
      }
      else{
        break;
      }
    }
  }

  public void RunGame(){
    System.out.println(this.Guessword.GuessWord);
    while (this.Guessword.BlankWord.contains(("_"))) {
      Guessword.LetterGuesser();
      System.out.println(this.Guessword.BlankWord);
      System.out.println(this.Guessword.Guesses);
    }
  }
}
