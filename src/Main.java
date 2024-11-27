import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        FireGenerator generator = new FireGenerator();

        // Paramètres de connexion à la base (actuellement inutilisés)
        /*
         * String url = "jdbc:postgresql://127.0.0.1:5432/fire";
         * String user = "postgres";
         * String password = "postgres";
         * String insertSQL =
         * "INSERT INTO feu (intensite, latitude, longitude, temperature, etatFeu, typeFeu) VALUES (?, ?, ?, ?, ?, ?)"
         * ;
         */

        // Connexion à la base désactivée pour l'instant
        /*
         * try (Connection conn = DriverManager.getConnection(url, user, password)) {
         * System.out.println("Connexion à la base PostgreSQL réussie.");
         */

        while (true) {
            // Génération d'un feu aléatoire
            Fire fire = generator.generateRandomFire();

            // Affichage des informations du feu généré
            System.out.println("Feu généré :");
            System.out.println("Latitude : " + fire.getLatitude());
            System.out.println("Longitude : " + fire.getLongitude());
            System.out.println("Température : " + fire.getTemperature() + "°C");
            System.out.println("Intensité : " + fire.getIntensity());
            System.out.println("Fréquence : " + fire.getFrequency() + " secondes");
            System.out.println("Pompiers nécessaires : " + fire.getPompier_necessaire());
            System.out.println("Pompiers sur place : " + fire.getPompier_sur_place());
            System.out.println("-----------------------------------");

            // Partie base de données commentée
            /*
             * try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
             * stmt.setString(1, fire.getIntensity()); // Intensité
             * stmt.setDouble(2, fire.getLatitude()); // Latitude
             * stmt.setDouble(3, fire.getLongitude()); // Longitude
             * stmt.setDouble(4, 30.0 + Math.random() * 10); // Température aléatoire entre
             * 30 et 40
             * stmt.setString(5, "En cours"); // État du feu par défaut
             * stmt.setString(6, "Vegetaux"); // Type de feu par défaut
             * stmt.executeUpdate();
             * System.out.println("Feu inséré dans la base de données.");
             * } catch (SQLException e) {
             * System.out.println("Erreur lors de l'insertion dans la base : " +
             * e.getMessage());
             * }
             */

            // Attente avant de générer le prochain feu, selon la fréquence du feu
            try {
                Thread.sleep(fire.getFrequency() * 1000L); // Convertir les secondes en millisecondes
            } catch (InterruptedException e) {
                System.out.println("Interruption du délai d'attente : " + e.getMessage());
                break; // Quitter la boucle en cas d'interruption
            }
        }
        /*
         * } catch (SQLException e) {
         * System.out.println("Erreur de connexion à la base PostgreSQL : " +
         * e.getMessage());
         * }
         */
    }
}
