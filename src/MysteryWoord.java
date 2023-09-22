public class MysteryWoord {
  String RaadWoord;
  String BlancoWoord;

  public MysteryWoord() {
    RaadWoord = Woord();
    BlancoWoord = Blanco(this.RaadWoord);
  }

  public String Woord(){
    // Genereert een te raden woord (nu nog een), uit een lijst
    return "Aapjes";
  }

  public String Blanco(String woord){
    // Maakt het te raden woord blanco
    return "_".repeat(woord.length());
  }

  public void WoordCheck(String letter){
    // Checkt of een letter in het te raden woord zit
    if (RaadWoord.contains(letter)){
      BlancoChange(letter);
    }

  }

  public void BlancoChange(String letter){
    // Past het Blanco woord aan met goed geraden letter
    for (int i = 0; i <= this.RaadWoord.length(); i++){
      if(){

      }

    }
  }

}
