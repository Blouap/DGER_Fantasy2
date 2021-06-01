package com.example.projet_version1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ProgressBar pbPv;
    private ProgressBar pbNiv;
    private ProgressBar pbFrc;

    public int Nb_tours = 0;
    public Boolean case_active = Boolean.FALSE;
    Joueur joueur = new Joueur();


    void Decouverte_Case(){
        double proba = Math.random();
        if (proba < 0.25){
            case_active = Boolean.FALSE;
            Decouverte_Objet();
        }
        else{
            case_active = Boolean.TRUE;
            Apparition_monstre();
        }
    }

    void Decouverte_Objet(){
        System.out.println("Le joueur découvre un objet");
        if (joueur.epee = Boolean.TRUE){
            joueur.New_Potion();
        }
        else{
            double prob = Math.random();
            if (prob < 0.75){
                joueur.New_Potion();
            }
            else{
                joueur.New_epee();
            }
        }
    }

    public static ArrayList<Monstre> listeMonstres = new ArrayList<>();

    void Apparition_monstre() {
        System.out.println("Oh non un gros méchant monstre se dresse devant toi");
        Monstre monstre = new Monstre(joueur.LVL);
        listeMonstres.add(monstre);
    }

    void Victoire(){
        System.out.println("Bravo tu as gagné");
    }

    void Defaite(){
        System.out.println("Dommage tu est mort, veux tu recommencer une partie?");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        while (Nb_tours < 200){

            pbPv = (ProgressBar)findViewById(R.id.pbPv);
            pbPv.setProgress(Nb_tours);
            pbPv.setMin(0);
            pbPv.setMax(30);
            Nb_tours = Nb_tours + 1;
            System.out.println("Tu es au tour " + Nb_tours);
            System.out.println("Le joueur va avancer");
            joueur.Se_deplacer();

            if (joueur.position >= 30){
                Victoire();
                break;
            }

            Decouverte_Case();

            while (case_active = Boolean.TRUE){
                String choix = "";
                Monstre monstre_actif = listeMonstres.get(listeMonstres.size()-1);
                System.out.println("Que voulez vous faire?");


                if (choix == "TAPER"){
                    joueur.Attaquer(monstre_actif);
                    if (monstre_actif.PV <= 0) {
                        case_active = Boolean.FALSE;
                    }
                }

                if (choix == "POTION"){
                    joueur.Prendre_Potion();
                }

                if (choix == "FUIR"){
                    joueur.Fuir();
                    case_active = Boolean.FALSE;
                }

                monstre_actif.Attaquer(joueur);
                if (joueur.PV <= 0){
                    System.out.println("T'es mort boloss");
                    Defaite();
                    break;
                }
            }


        }
    }


}