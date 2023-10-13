import java.util.Scanner;

public class GameMaster {
  MysteryWord Guessword;

  public GameMaster(){
    Guessword = new MysteryWord();
  }


  public void PlayGame(){
    Scanner GameOn = new Scanner(System.in);
    System.out.println("Do you want to play a game? (yes / no)");
    String Gaming = GameOn.nextLine().toUpperCase();
    if(Gaming.equals("YES")){
      RunGame();
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
