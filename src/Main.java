import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        FireGenerator generator = new FireGenerator();

        // Paramètres de connexion à la base
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        String insertSQL = "INSERT INTO \"feu\" (\"intensity\", \"latitude\", \"longitude\", \"temperature\", \"frequency\", \"pompier_necessaire\", \"pompier_sur_place\", \"etatfeu\", \"typefeu\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion à la base PostgreSQL réussie.");
            String test = "Select * from \"feu\"";
            try(PreparedStatement pstmt = conn.prepareStatement(test)){
                pstmt.executeQuery();
                System.out.println("Requete reussie");
            }catch(SQLException e){
                System.out.println("Erreur lors de la requete : " + e.getMessage());
            }

            while (true) {
                // Génération d'un feu aléatoire
                Fire fire = generator.generateRandomFire();

                // Affichage des informations du feu généré
//                System.out.println("Feu généré :");
//                System.out.println("Latitude : " + fire.getLatitude());
//                System.out.println("Longitude : " + fire.getLongitude());
//                System.out.println("Température : " + fire.getTemperature() + "°C");
//                System.out.println("Intensité : " + fire.getIntensity());
//                System.out.println("Fréquence : " + fire.getFrequency() + " secondes");
//                System.out.println("Pompiers nécessaires : " + fire.getPompier_necessaire());
//                System.out.println("Pompiers sur place : " + fire.getPompier_sur_place());
//                System.out.println("-----------------------------------");

                // Insertion dans la base de données
                try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                    stmt.setString(1, fire.getIntensity());
                    stmt.setDouble(2, fire.getLatitude());
                    stmt.setDouble(3, fire.getLongitude());
                    stmt.setInt(4, fire.getTemperature());
                    stmt.setInt(5, fire.getFrequency());
                    stmt.setInt(6, fire.getPompier_necessaire());
                    stmt.setInt(7, fire.getPompier_sur_place());
                    stmt.setString(8, "En cours");
                    stmt.setString(9, "Vegetaux");
                    stmt.executeUpdate();
                    System.out.println("Feu inséré dans la base de données.");
                } catch (SQLException e) {
                    System.out.println("Erreur lors de l'insertion dans la base : " + e.getMessage());
                }

                // Attente avant de générer le prochain feu, selon la fréquence du feu
                try {
                    Thread.sleep(fire.getFrequency() * 1000L); // Convertir les secondes en millisecondes
                } catch (InterruptedException e) {
                    System.out.println("Interruption du délai d'attente : " + e.getMessage());
                    break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base PostgreSQL : " + e.getMessage());
        }
    }
}
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Main {
//    public static void main(String[] args) {
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String user = "postgres";
//        String password = "postgres";
//
//        String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password);
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery()) {
//
//            System.out.println("Liste des tables dans le schéma public :");
//            while (rs.next()) {
//                String tableName = rs.getString("table_name");
//                System.out.println("- " + tableName);
//            }
//        } catch (SQLException e) {
//            System.out.println("Erreur lors de la requête : " + e.getMessage());
//        }
//    }
//}
