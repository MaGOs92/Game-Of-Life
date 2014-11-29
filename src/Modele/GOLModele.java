package Modele;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class GOLModele implements Constantes {
	
	public static int numGeneration = 0;
	private Cellule grilleDeCellules[][];
	
	public GOLModele(){
		genererGrilleCellule();
		remplirLesVoisines();
	}
	
	private void genererGrilleCellule(){
		
		this.grilleDeCellules = new Cellule[NBRE_DE_COLONNES][NBRE_DE_LIGNES];
		
		Random rd = new Random();
		boolean vivant;
		
		for (int i=0; i<NBRE_DE_COLONNES; i++){
			for (int j=0; j<NBRE_DE_LIGNES; j++){
				
				int n = rd.nextInt(100) + 1;
				
				if ( n < CHANCE_VIE){
					vivant = true;
				}
				else {
					vivant = false;
				}
				
				this.grilleDeCellules[i][j] = new Cellule(i, j, vivant);
			}
		}
	}
	
	private void remplirLesVoisines(){
		for (int i=0; i<NBRE_DE_COLONNES; i++){
			for (int j=0; j<NBRE_DE_LIGNES; j++){
				Cellule[] tabVoisine = new Cellule[9];
				int compteur = 0;
				for(int k=-1; k<2; k++){
					for(int l=-1; l<2; l++){
						int indTempX = this.grilleDeCellules[i][j].getIndiceX() + k;
						int indTempY = this.grilleDeCellules[i][j].getIndiceY() + l;
						if (indTempX < 0 || indTempX >= NBRE_DE_COLONNES ||
								indTempY < 0 || indTempY >= NBRE_DE_LIGNES){
							tabVoisine[compteur] = null;
						}
						else {
							tabVoisine[compteur] = this.grilleDeCellules[indTempX][indTempY];
						}
						compteur ++;
					}
				}
				this.grilleDeCellules[i][j].remplirVoisines(tabVoisine);
			}
		}
	}

      // le calcul du jeu
	
      public void calculDeLaVie() {
  		for (int i=0; i<NBRE_DE_COLONNES; i++){
			for (int j=0; j<NBRE_DE_LIGNES; j++){
				this.grilleDeCellules[i][j].estEnVie();
			}
		}
  		
  		for (int i=0; i<NBRE_DE_COLONNES; i++){
			for (int j=0; j<NBRE_DE_LIGNES; j++){
				this.grilleDeCellules[i][j].changerEtat();
			}
		}
  		
      }
      
      // le dessin graphique du jeu
      
      public void affichage(Graphics g) {

    		for (int i=0; i<NBRE_DE_COLONNES; i++){
    			for (int j=0; j<NBRE_DE_LIGNES; j++){
    				this.grilleDeCellules[i][j].affichage(g);
    			}
    		}
            
            // affichage de la gŽnŽration
    		String genstr = "GŽnŽration de cellule : ";
            g.setColor(Color.BLUE);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            g.drawString(genstr + numGeneration, 5, 25);
            
            
      }
      
}
