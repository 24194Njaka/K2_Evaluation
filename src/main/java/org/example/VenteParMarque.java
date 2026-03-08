package org.example;

public class VenteParMarque {
    private Marque marque;
    private int nbrePiece;

    public Marque getMarque() { return marque; }
    public void setMarque(String marque) {
        this.marque = Marque.valueOf(marque);
    }

    public int getNbrePiece() { return nbrePiece; }
    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    @Override
    public String toString() {
        return marque + " | " + nbrePiece;
    }
}
