import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MysteryWord {
  String GuessWord;
  String BlankWord;
  char[] BlankArray;
  char[] WordArray;
  char[] Guesses;
  String[] Wordlist;

  public MysteryWord() {
    GuessWord = Word().toUpperCase();
    WordArray = this.GuessWord.toCharArray();
    BlankWord = Blank(this.GuessWord);
    BlankArray = this.BlankWord.toCharArray();
    Guesses = new char[0];
//    Wordlist = new String[0];
  }

  public String Word(){
    if(this.Wordlist == null) {
      try {
        this.Wordlist = new String[0];
        InputStream is = MysteryWord.class.getClassLoader().getResourceAsStream("Woordlijst.txt");
        Scanner ListScanner = new Scanner(is);
        while (ListScanner.hasNext()) {
          String data = ListScanner.nextLine();
//          String data = ListScanner.next();
          this.Wordlist = Arrays.copyOf(this.Wordlist, this.Wordlist.length + 1);
          this.Wordlist[this.Wordlist.length - 1] = data;
        }
        return this.Wordlist[ThreadLocalRandom.current().nextInt(this.Wordlist.length)];
      } catch (Exception e) {
        System.out.println("File wasn't found, somehow");
      }
      return "aapjes";
    }
    else{
      return Wordlist[ThreadLocalRandom.current().nextInt(Wordlist.length)];
    }
  }

  public String Blank(String Word){
    // Creates a blank from the to guess word
    return "_".repeat(Word.length());
  }

  public void BlankChange(String Letter){
    // Edits the blank word if the letter is in the word
    for (int i = 0; i < this.WordArray.length; i++) {
      if (this.WordArray[i] == Letter.charAt(0)) {
        this.BlankArray[i] = Letter.charAt(0);
      }
    }
    this.BlankWord = new String(BlankArray);
  }

  public void GuessFiller(String Letter){
    // Fills the Guesses character array with guessed letters
    this.Guesses = Arrays.copyOf(this.Guesses, this.Guesses.length + 1);
    this.Guesses[this.Guesses.length - 1] = Letter.charAt(0);
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

  public void Reset(){
    GuessWord = Word().toUpperCase();
    WordArray = this.GuessWord.toCharArray();
    BlankWord = Blank(this.GuessWord);
    BlankArray = this.BlankWord.toCharArray();
    Guesses = new char[0];
  }

}
