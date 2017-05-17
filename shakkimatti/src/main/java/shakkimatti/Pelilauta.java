package shakkimatti;

import java.util.*;

public class Pelilauta {
    
    private char[][] lauta;
    
    public Pelilauta() {
        this.lauta = new char[8][8];
        alustus();
    }
    
    public void alustus() {
        for (int i = 0; i < 8; i++) {
            this.lauta[i][6]='S';
            this.lauta[i][1]='S';
        }
        
        this.lauta[4][7]='K';
        this.lauta[3][7]='Q';
        this.lauta[4][0]='K';
        this.lauta[3][0]='Q';
        
        this.lauta[0][0]='T';
        this.lauta[7][0]='T';
        this.lauta[0][7]='T';
        this.lauta[7][7]='T';
        
        this.lauta[1][7]='R';
        this.lauta[6][7]='R';
        this.lauta[1][0]='R';
        this.lauta[6][0]='R';
        
        this.lauta[2][7]='L';
        this.lauta[5][7]='L';
        this.lauta[2][0]='L';
        this.lauta[5][0]='L';
        
        
    }
    
    public void tulosta(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(this.lauta[j][i]);
            }
            System.out.println("");
        }
    }
    
}
