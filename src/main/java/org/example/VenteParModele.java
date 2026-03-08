package org.example;

public class VenteParModele {
    private int nbreGetz;
    private int nbrePride;
    private int nbreLacetti;

    public int getNbreGetz() { return nbreGetz; }
    public void setNbreGetz(int nbreGetz) {
        this.nbreGetz = nbreGetz;
    }

    public int getNbrePride() { return nbrePride; }
    public void setNbrePride(int nbrePride) {
        this.nbrePride = nbrePride;
    }

    public int getNbreLacetti() { return nbreLacetti; }
    public void setNbreLacetti(int nbreLacetti) {
        this.nbreLacetti = nbreLacetti;
    }

    @Override
    public String toString() {
        return nbreGetz + " | " + nbrePride + " | " + nbreLacetti;
    }
}
