package com.medassi.pacmanfx;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class PrimaryController implements Initializable {
    @FXML
    private Canvas canvas;
    private Image imgFantome;
    private Image imgMur;
    private Image imgVide;
    private Image imgPacman;
    private Position pPacman = new Position();//Stocke la position du Pacman de la matrice
    private Position[] pFantomes = new Position[Config.nbFantomes];//Stocke la position des fantômes de la matrice
    private final Image[][] map = new Image[Config.hauteur][Config.largeur];//La matrice d'image
    boolean start = false; //est-ce que la partie a commencé ?
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {//Terminé
        imgFantome = new Image(getClass().getResourceAsStream("img/fantome.png"));
        imgMur = new Image(getClass().getResourceAsStream("img/mur.png"));
        imgVide = new Image(getClass().getResourceAsStream("img/vide.png"));
        imgPacman = new Image(getClass().getResourceAsStream("img/pacman.png"));
        loadMapFromTextFile(); //extrait le fichier texte pour valoriser la map et les positions du Pacman et des fantômes
        printMap();// affiche la map dans le canvas
    }

    private void loadMapFromTextFile() {//A Faire
        Scanner sc = new Scanner(getClass().getResourceAsStream("map.txt"));
        int y = 0;
        int nbF = 0;
        while (sc.hasNext()) {//parcours de chaque ligne
            String ligne = sc.nextLine();
            for (int x = 0; x < ligne.length(); x++) {//parcours de chaque caractère de la ligne
                if (x < Config.largeur && y < Config.hauteur) {
                    switch (ligne.charAt(x)) {
                        case 'M':
                            //A Faire : On positionne l'image du mur dans la map
                            break;
                        case 'F':
                            //A Faire : On positionne l'image du fantome dans la map
                            //A Faire : on stocke la position du nouveau fantome
                            break;
                        case 'P':
                            //A Faire : On positionne l'image du Pacman dans la map
                            //A Faire : on stocke la position du Pacman
                            break;
                        case ' ':
                            //A Faire : On positionne l'image du vide dans la map
                            break;
                    }
                }
            }
            y++;
        }
    }

    @FXML
    private void onKeyPressed(KeyEvent event) {//A faire
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //A Faire : Si la partie n'est pas encore lancée, alors on la lance et on demarre les fantomes
        switch (event.getCode()) {
            case UP:
                //A Faire : on deplace le Pacman vers le haut si c'est possible
                break;
            case DOWN:
                //A Faire : on deplace le Pacman vers le bas si c'est possible
                break;
            case LEFT:
                //A Faire : on deplace le Pacman vers la gauche si c'est possible
                break;
            case RIGHT:
                //A Faire : on deplace le Pacman vers la droite si c'est possible
                break;
        }
        //A Faire : On redessine les images qui ont changé (gauche ou droite ou haut ou bas.
    }

    private void printMap() {//A Faire
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //A Faire : on dessine les 800 images de la map sur le canvas (gc)
    }

    private void startTimerFantomes() {//Terminé
        //demarrage des fantomes. La procédure moveFantomes sera appelée toutes les 200ms
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        moveFantomes();
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 200);
    }

    private void moveFantomes() {//A Faire
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //A Faire : On parcourt chaque fantome et on le deplace aleéatoirement 
        //d'une case à gauche, ou à droite ou en haut ou en bas. 
        //On le déplace forcément car il ne peut pas être coincé (en théorie)
        //Une fois que le déplacement est effectué, on redessine les cases modifiées
    }
}
