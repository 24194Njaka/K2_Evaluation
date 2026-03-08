package org.example;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public List<VenteParMarque> findVentesParMarque() {
        List<VenteParMarque> list = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                    SELECT mv.marque, COALESCE(SUM(v.quantite), 0) AS nbre_piece
                    FROM Modele_voiture mv
                    LEFT JOIN Piece_auto pa ON pa.id_modele_voiture = mv.id
                    LEFT JOIN Vente v ON v.id_piece_auto = pa.id
                    GROUP BY mv.marque
                    ORDER BY mv.marque
                    """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                VenteParMarque vente = new VenteParMarque();
                // setters
                vente.setMarque(resultSet.getString("marque"));
                vente.setNbrePiece(resultSet.getInt("nbre_piece"));
                list.add(vente);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public VenteParModele findVentesParModele() {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                    SELECT
                        SUM(CASE WHEN mv.modele = 'GETZ'    THEN v.quantite ELSE 0 END) AS nbre_getz,
                        SUM(CASE WHEN mv.modele = 'PRIDE'   THEN v.quantite ELSE 0 END) AS nbre_pride,
                        SUM(CASE WHEN mv.modele = 'LACETTI' THEN v.quantite ELSE 0 END) AS nbre_lacetti
                    FROM Vente v
                    JOIN Piece_auto pa ON pa.id = v.id_piece_auto
                    JOIN Modele_voiture mv ON mv.id = pa.id_modele_voiture
                    """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                VenteParModele vente = new VenteParModele();
                // setters
                vente.setNbreGetz(resultSet.getInt("nbre_getz"));
                vente.setNbrePride(resultSet.getInt("nbre_pride"));
                vente.setNbreLacetti(resultSet.getInt("nbre_lacetti"));
                return vente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PrixTotalKia findPrixTotalKia() {
        try (Connection connection = DBConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    """
                    SELECT SUM(pa.prix * v.quantite) AS prix_total
                    FROM Vente v
                    JOIN Piece_auto pa ON pa.id = v.id_piece_auto
                    JOIN Modele_voiture mv ON mv.id = pa.id_modele_voiture
                    WHERE mv.marque = 'KIA'
                    """
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PrixTotalKia prixTotalKia = new PrixTotalKia();
                // setter
                prixTotalKia.setPrixTotal(resultSet.getDouble("prix_total"));
                return prixTotalKia;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}