package com.example.projet_version1;

public class Monstre extends Personnages{

    public Monstre(int LVL) {
        super(LVL, (LVL+1)/2, LVL + 4, LVL + 4);
    }

    @Override
    void Attaquer(Personnages j) {
        super.Attaquer(j);
        if (j.PV <= 0){
            j.Mourir();
        }
        else{
            System.out.println("Le monstre t'as mis un sale coup, il t'as retiré " + this.Force + " points de vie");
            System.out.println("Il te reste " + j.PV + " points de vie");
        }
    }

    @Override
    void Mourir() {
        super.Mourir();
        System.out.println("Le monstre est mort");
    }

}
