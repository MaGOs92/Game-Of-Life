package Modele;

public class Case implements Constantes {

      private int xIndice;
      private int yIndice;
      
      public Case(int xIndice, int yIndice) {
            this.xIndice = xIndice;
            this.yIndice = yIndice;
      }

      // indice horizontal
      public void setIndiceX(int x) {
            this.xIndice = x;
      }

      // indice horizontal
      public int getIndiceX() {
            return this.xIndice;
      }

      // indice vertical
      public void setIndiceY(int y) {
            this.yIndice = y;
      }

      // indice vertical
      public int getIndiceY() {
            return this.yIndice;
      }

      // coordonnée horizontale en pixels
      public int getX() {
            return this.xIndice * CASE_EN_PIXELS;
      }

      // coordonnée verticale en pixels
      public int getY() {
            return this.yIndice * CASE_EN_PIXELS;
      }

      public int getLargeur() {
            return CASE_EN_PIXELS;
      }

      public int getHauteur() {
            return CASE_EN_PIXELS;
      }
      
}