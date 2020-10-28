package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli=new Artikl[1000];
    private int brojArtikala = 0;
    public boolean dodajArtikl(Artikl a){ //da li je supermarket pun? : neupjesno, dodaj
        if(brojArtikala<1000){
            artikli[brojArtikala] = new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
            brojArtikala = brojArtikala + 1;
            return true;
        }
        return false;
    }
    public Artikl[] getArtikli(){return artikli;}

    public Artikl izbaciArtiklSaKodom(String kod){ // da li uopste ima ista u supermarketu? : izbaci trazeni, prekini
        for (int i = 0; i < brojArtikala; i++) {
            if(artikli[i].getKod().equals(kod)){
                Artikl izbacen = new Artikl(artikli[i].getNaziv(),artikli[i].getCijena(),artikli[i].getKod());
                artikli[i] = null;
                for (; i < brojArtikala; i++) {
                    artikli[i] = artikli[i+1];
                }
                artikli[brojArtikala] = null;
                brojArtikala = brojArtikala - 1;
                return izbacen;
            }
        } return null;
    }

}
