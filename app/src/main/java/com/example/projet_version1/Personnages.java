package com.example.projet_version1;

public class Personnages {
    public int LVL;
    public int Force;
    public int PV_max;
    public int PV;

    public Personnages(int LVL, int force, int PV_max, int PV) {
        this.LVL = LVL;
        this.Force = force;
        this.PV_max = PV_max;
        this.PV = PV;
    }

    void Attaquer(Personnages p){
        p.PV = p.PV - this.Force;
    }

    void Mourir(){

    }



}