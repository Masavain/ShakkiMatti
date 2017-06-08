package shakkimatti.logiikka;

/**
 * päälogiikkaluokka shakkipelin vuorojen kontrollointiin sekä pelin voittoehtojen
 * tarkastamiseen.
 *
 * @author Masavain
 */
public class Paalogiikka {

    private Pelilauta pelilauta;
    private int vuoro;

    public Paalogiikka() {
        this.pelilauta = new Pelilauta();
        pelilauta.alustus();
        this.vuoro = 1;
    }
    
    

//    pelin voitto?!

    public Pelilauta getPelilauta() {
        return pelilauta;
    }


    public int getVuoro() {
        return vuoro;
    }

}
