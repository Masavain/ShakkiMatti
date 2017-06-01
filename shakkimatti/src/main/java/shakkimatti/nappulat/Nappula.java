package shakkimatti.nappulat;

import java.util.*;

public abstract class Nappula {

    public int x, y, color;
    public String merkki;

    public Nappula(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void liiku(int xMihin, int yMihin, Nappula[][] lauta) {
        List<String> mahdSiirrot = this.mahdollisetSiirrot(lauta);
        List<String> mahdSyonnit = this.mahdollisetSyonnit(lauta);
        if (mahdSiirrot.contains(xMihin + "," + yMihin) || mahdSyonnit.contains(xMihin + "," + yMihin)) {
            setX(xMihin);
            setY(yMihin);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return merkki;
    }

    public abstract List<String> mahdollisetSiirrot(Nappula[][] tilanne);

    public abstract List<String> mahdollisetSyonnit(Nappula[][] tilanne);

}
