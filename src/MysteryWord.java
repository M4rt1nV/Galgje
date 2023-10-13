import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MysteryWord {
  String GuessWord;
  String BlankWord;
  char[] BlankArray;
  char[] WordArray;
  char[] Guesses;
  int Errors;
  String[] Wordlist;

  public MysteryWord() {
    GuessWord = Word().toUpperCase();
    WordArray = this.GuessWord.toCharArray();
    BlankWord = Blank(this.GuessWord);
    BlankArray = this.BlankWord.toCharArray();
    Guesses = new char[0];
    Errors = 0;
    Wordlist = new String[0];
  }

  public String Word(){
    // Generates a word to guess from a list
    try {
      File WordFile = new File("Woordlijst.txt");
      Scanner ListScanner = new Scanner(WordFile);
      System.out.print(ListScanner);
      while (ListScanner.hasNext()) {
        String data = ListScanner.nextLine();
        this.Wordlist = Arrays.copyOf(this.Wordlist, this.Wordlist.length + 1);
        this.Wordlist[this.Wordlist.length - 1] = data;
      }
//      ListScanner.close();
      return this.Wordlist[ThreadLocalRandom.current().nextInt(Wordlist.length)];
    }
    catch (FileNotFoundException e){
      System.out.println("File wasn't found, somehow");
    }
    return "aapjes";
  }

  public String Blank(String Word){
    // Creates a blank from the to guess word
    return "_".repeat(Word.length());
  }

  public void BlankChange(String Letter){
    // Edits the blank word if the letter is in the word
    if(this.GuessWord.contains(Letter)) {
      for (int i = 0; i < this.WordArray.length; i++) {
        if (this.WordArray[i] == Letter.charAt(0)) {
          this.BlankArray[i] = Letter.charAt(0);
        }
      }
      this.BlankWord = new String(BlankArray);
    }
    else {
      this.Errors++;
      System.out.println("That letter is not in the word");
    }
  }

  public void GuessFiller(String Letter){
    // Fills the Guesses character array with guessed letters
    this.Guesses = Arrays.copyOf(this.Guesses, this.Guesses.length + 1);
    this.Guesses[this.Guesses.length - 1] = Letter.charAt(0);
  }

  public void LetterGuesser(){
    // Asks the user for a letter input
    Scanner MyScan = new Scanner(System.in);
    System.out.println("Guess a letter:");
    String Letter = MyScan.nextLine().toLowerCase();
    if(this.LetterChecker(Letter)){
      this.GuessFiller(Letter);
      this.BlankChange(Letter.toUpperCase());
    }
  }

  public boolean LetterChecker(String Letter){
    // Checks whether a guessed letter is one letter, a letter and an un-guessed letter
    if(Letter.length() > 1){
      System.out.println("Only one letter please");
      return false;
    }
    for(char i : Letter.toCharArray())
      if(!Character.isLetter(i)){
        System.out.println("Only input a letter please");
        return false;
      }
    for(char c : this.Guesses){
      if(c == Letter.charAt(0)){
        System.out.println("Letter has been guessed already");
        return false;
      }
    }
    return true;
  }

}
