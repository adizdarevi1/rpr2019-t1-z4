package ba.unsa.etf.rpr;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArtiklTest {
    @Test
    void provjeraKonstruktoraArtikla(){
        Artikl a = new Artikl("biciklo69",690,"69");
        Assertions.assertAll(() -> assertEquals("biciklo69",a.getNaziv()),
                () -> assertEquals(690,a.getCijena()),
                () -> assertEquals("69",a.getKod()));
    }
    @Test
    void dodajArtiklKorpa(){
        Korpa korpa = new Korpa();
        Artikl a = new Artikl("biciklo69",690,"69");
        assertTrue(korpa.dodajArtikl(a));
    }
    @Test
    void dodajArtiklSupermarket(){
        Supermarket supermarket = new Supermarket();
        Artikl a = new Artikl("biciklo69",690,"69");
        assertTrue(supermarket.dodajArtikl(a));
    }
    @Test
    void dodajArtiklKorpaFalse(){
        Korpa korpa = new Korpa();
        Artikl a = new Artikl("biciklo69",690,"69");
        for (int i = 0; i < 50; i++) {
            korpa.dodajArtikl(a);
        }
        assertFalse(korpa.dodajArtikl(a));
    }
    @Test
    void dodajArtiklSupermarketFalse(){
        Supermarket supermarket = new Supermarket();
        Artikl a = new Artikl("biciklo69",690,"69");
        for (int i = 0; i < 1000; i++) {
            supermarket.dodajArtikl(a);
        }
        assertFalse(supermarket.dodajArtikl(a));
    }
    @Test
    void izbaciArtiklSaKodomSupermarketTrue(){
        Supermarket supermarket = new Supermarket();
        Artikl a = new Artikl("biciklo69",690,"69");
        Artikl b = new Artikl("biciklo70",700,"70");
        Artikl c = new Artikl("biciklo71",710,"71");
        supermarket.dodajArtikl(a);
        supermarket.dodajArtikl(b);
        supermarket.dodajArtikl(c);
        Artikl d = supermarket.izbaciArtiklSaKodom("70");
        Assertions.assertAll(
                () -> assertEquals(d.getCijena(),b.getCijena()),
                () -> assertEquals(d.getKod(),b.getKod()),
                () -> assertEquals(d.getNaziv(),b.getNaziv()));
    }
    @Test
    void izbaciArtiklSaKodomSupermarketFalse(){
        Supermarket supermarket = new Supermarket();
        Artikl a = new Artikl("biciklo69",690,"69");
        Artikl b = new Artikl("biciklo70",700,"70");
        Artikl c = new Artikl("biciklo71",710,"71");
        supermarket.dodajArtikl(a);
        supermarket.dodajArtikl(b);
        supermarket.dodajArtikl(c);
        assertEquals(null,(Artikl) supermarket.izbaciArtiklSaKodom("90"));
    }@Test
    void izbaciArtiklSaKodomKorpaTrue(){
        Korpa korpa = new Korpa();
        Artikl a = new Artikl("biciklo69",690,"69");
        Artikl b = new Artikl("biciklo70",700,"70");
        Artikl c = new Artikl("biciklo71",710,"71");
        korpa.dodajArtikl(a);
        korpa.dodajArtikl(b);
        korpa.dodajArtikl(c);
        Artikl d = korpa.izbaciArtiklSaKodom("70");
        Assertions.assertAll(
                () -> assertEquals(d.getCijena(),b.getCijena()),
                () -> assertEquals(d.getKod(),b.getKod()),
                () -> assertEquals(d.getNaziv(),b.getNaziv()));
    }
    @Test
    void izbaciArtiklSaKodomKorpaFalse(){
        Korpa korpa = new Korpa();
        Artikl a = new Artikl("biciklo69",690,"69");
        Artikl b = new Artikl("biciklo70",700,"70");
        Artikl c = new Artikl("biciklo71",710,"71");
        korpa.dodajArtikl(a);
        korpa.dodajArtikl(b);
        korpa.dodajArtikl(c);
        assertEquals(null,(Artikl) korpa.izbaciArtiklSaKodom("90"));
    }
    @Test
    void dajUkupnuCijenuArtikala(){
        Korpa korpa = new Korpa();
        Artikl a = new Artikl("biciklo69",690,"69");
        Artikl b = new Artikl("biciklo70",700,"70");
        Artikl c = new Artikl("biciklo71",710,"71");
        korpa.dodajArtikl(a);
        korpa.dodajArtikl(b);
        korpa.dodajArtikl(c);
        assertEquals(690+700+710,korpa.dajUkupnuCijenuArtikala());
    }
}