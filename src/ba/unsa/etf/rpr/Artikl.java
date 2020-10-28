package ba.unsa.etf.rpr;

public class Artikl {
    private String nazivArtikla;
    private int cijenaArtikla;
    private String kodArtikla;
    public Artikl(String nazivArtikla, int cijenaArtikla, String kodArtikla){
        this.nazivArtikla=nazivArtikla;
        this.cijenaArtikla=cijenaArtikla;
        this.kodArtikla=kodArtikla;
    }
    public String getNaziv(){return nazivArtikla;}
    public int getCijena(){return cijenaArtikla;}
    public String getKod(){return kodArtikla;}
}
