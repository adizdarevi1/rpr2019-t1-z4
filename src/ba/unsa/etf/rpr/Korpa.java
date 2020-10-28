package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] artikli=new Artikl[50];
    private int brojArtikalaUKorpi = 0;
    public boolean dodajArtikl(Artikl a) {//da li je dodavanje uspjesno? : dodaj, vrati u supermarket
        if(brojArtikalaUKorpi<50){
            artikli[brojArtikalaUKorpi] = new Artikl(
                    a.getNaziv(),a.getCijena(),a.getKod());
            brojArtikalaUKorpi = brojArtikalaUKorpi + 1;
            return true;
        }
        return false;
    }
    public Artikl izbaciArtiklSaKodom(String kod) {//da li je dodavanje uspjesno? : dodaj, vrati u supermarket
        for (int i = 0; i < brojArtikalaUKorpi; i++) {
            if(artikli[i].getKod().equals(kod)){
                Artikl izbacen = new Artikl(
                        artikli[i].getNaziv(),artikli[i].getCijena(),artikli[i].getKod());
                artikli[i]=null; //obrisati artikal iz korpe

                for (; i < brojArtikalaUKorpi; i++) { //pomjeriti artikle u nizu
                    artikli[i] = artikli[i+1];
                }
                artikli[brojArtikalaUKorpi] = null;
                brojArtikalaUKorpi = brojArtikalaUKorpi - 1;
                return izbacen;
            }
        }
        return null; //nije pronadjen takav artikl
    }
    public int dajUkupnuCijenuArtikala(){
        int cijena = 0;
        for (int i = 0; i < brojArtikalaUKorpi; i++) {
            cijena = cijena + artikli[i].getCijena();
        }
        return cijena;
    }
    public Artikl[] getArtikli(){
        return artikli;
    }
}
