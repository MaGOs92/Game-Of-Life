package Modele;

import java.awt.Color;
import java.awt.Graphics;

public class Cellule extends Case {

	public boolean estVivante;
	public boolean etatDeTransit;
	private Cellule[] voisines;
	
	public Cellule(int xIndice, int yIndice, boolean estVivante){
		super(xIndice, yIndice);
		this.estVivante = estVivante;
	}
	
	public void estEnVie(){
		
		int nbVoisinesVivantes = 0;
		
		for (int i = 0; i < 8; i ++){
			if (voisines[i] != null){
				if (voisines[i].estVivante){
					nbVoisinesVivantes++;
				}
			}
		}
		if (nbVoisinesVivantes == 3 ){
			this.etatDeTransit = true;
		}
		else if (nbVoisinesVivantes == 2 && this.estVivante){
			this.etatDeTransit = true;
		}
		else {
			this.etatDeTransit = false;
		}
	}
	
	public void remplirVoisines(Cellule[] tab){
		this.voisines = new Cellule[8];
	 	int compteur = 0;
		for (int i = 0; i<9; i++){
			if (i != 4){
				this.voisines[compteur] = tab[i];
				compteur ++;
			}
		}
	}
	
	public void changerEtat(){
		this.estVivante = this.etatDeTransit;
	}
	
	public void affichage(Graphics g) {
		if (this.estVivante){
		    g.setColor(Color.GREEN);
		}
		else {
		    g.setColor(Color.WHITE);
		}

	    g.fillRect(getX() + 2, getY() + 2, getLargeur() - 4, getHauteur() - 4);
	}
	
}
