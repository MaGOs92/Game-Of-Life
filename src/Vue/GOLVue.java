package Vue;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Modele.GOLModele;
import java.awt.Graphics;
import Modele.Constantes;

public class GOLVue extends JFrame implements Constantes {
	
	private GOLModele modele;

    public GOLVue() {
        super("Game of life");
        this.modele = new GOLModele();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        final JPanel content = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                  super.paintComponent(g);
                  // affichage du modèle du jeu
                  modele.affichage(g);
            }
      };
      
        content.setPreferredSize(new Dimension(NBRE_DE_COLONNES * CASE_EN_PIXELS, NBRE_DE_LIGNES * CASE_EN_PIXELS));
        setContentPane(content);
        
        // Thread infini
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                  while (true) {
                	  modele.calculDeLaVie();
                	  content.repaint();
                	  
                      try {
                          Thread.sleep(500);
                      } 
                      catch (InterruptedException e) {
                    	  
                      }
                	  GOLModele.numGeneration++;
                  }
            }
      });
      // lancer le thread
      thread.start();

  }
  

  public static void main(String[] args) {
	  	GOLVue fenetre = new GOLVue();
        // dimensionnement de la fenêre "au plus juste" suivant
        // la taille des composants qu'elle contient
        fenetre.pack();
        // centrage sur l'écran
        fenetre.setLocationRelativeTo(null);
        // affichage
        fenetre.setVisible(true);
  }
}
