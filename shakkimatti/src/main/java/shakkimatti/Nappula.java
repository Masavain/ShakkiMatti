
package shakkimatti;

public abstract class Nappula {
    
    private int x, y, color;

    public Nappula(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    
    public void liiku(int x, int y) {
        this.x = x;
        this.y = y;
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
    
    
}
