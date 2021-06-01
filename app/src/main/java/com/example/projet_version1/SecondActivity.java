package com.example.projet_version1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    public ProgressBar pbPv;
    public TextView NbrNiv;
    public TextView NbrPv;


    public int Nb_tours = 0;
    public Boolean case_active = Boolean.FALSE;
    public Joueur joueur;



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
        Joueur joueur = new Joueur();

        pbPv = (ProgressBar)findViewById(R.id.pbPv);
        pbPv.setProgress(joueur.PV);
        pbPv.setMin(0);
        pbPv.setMax(joueur.PV_max);

        NbrNiv = (TextView)findViewById(R.id.NbrNiv);
        NbrNiv.setText(String.valueOf(joueur.LVL));

        NbrPv = (TextView)findViewById(R.id.NrbPv);
        NbrPv.setText(String.valueOf(joueur.PV)+"/"+String.valueOf(joueur.PV_max));







    }


}