package com.example.projet_version1;

import java.util.Random;

public class Joueur extends Personnages{


    public int XP;
    public Boolean epee;
    public int Nb_Potions;
    public int position;

    public Joueur() {
        super(1, 2, 20, 20);
        this.epee = Boolean.FALSE;
        Nb_Potions = 1;
        this.position = 0;
    }


    @Override
    void Attaquer(Personnages m) {
        super.Attaquer(m);
        if (m.PV <= 0) {
            System.out.println("Tu as gagné " + m.LVL + 1 + " points d'expérience");
            this.XP = this.XP + (m.LVL + 1);
            if (this.XP >= this.LVL * this.LVL) {
                this.XP = this.XP - this.XP * this.XP;
                this.LVL_up();
            }
            System.out.println("Tu as " + this.XP + " points d'expérience");
            System.out.println("Plus que " + (this.XP * this.XP - this.XP) + "pour passer au niveau " + (this.LVL + 1));
            m.Mourir();
        }
        else{
            System.out.println("Le monstre est encore vivant, il lui reste " + m.PV + " points de vie");
        }
    }

    void Prendre_Potion(){
        if( Nb_Potions <= 0){
            System.out.println("Tu n'as plus de potions boloss");
        }
        else{
        Nb_Potions = Nb_Potions - 1;
        this.PV = this.PV + 20;
        if (this.PV > this.PV_max) {
            this.PV = this.PV_max;
        }
        }
    }

    void LVL_up(){
        this.Force = this.Force + 1;
        this.PV = this.PV + 5;
        this.PV_max = this.PV_max + 5;
    }

    void Fuir(){
        if (this.position <= 2){
            this.position = 0;
        }
        else{
            this.position = this.position - 3;
        }
        System.out.println("Le joueur recule de 3 cases");
    }

    @Override
    void Mourir() {
        super.Mourir();
        System.out.println("Le joueur est mort, Game Over");
    }

    void Se_deplacer(){
        Random rand = new Random();
        int d = rand.nextInt(2) + 1;
        this.position = this.position + d;
        System.out.println("Le joueur avance de " + d +" cases");
    }

    void New_Potion(){
        this.Nb_Potions = this.Nb_Potions + 1;
        System.out.println("Bravo tu as trouvé une potion");
    }

    void New_epee(){
        this.epee = Boolean.TRUE;
        this.Force = this.Force + 1;
        System.out.println("Bravo tu as trouvé une épée");
    }


}
