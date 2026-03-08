package org.example;


public class PrixTotalKia {
    private double prixTotal;

    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Prix total KIA : " + prixTotal;
    }
}
