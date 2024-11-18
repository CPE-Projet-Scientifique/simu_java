import java.util.Random;

public class FireGenerator {
    private Random random = new Random();

    public Fire generateRandomFire(int mapWidth, int mapHeight) {
        int x = random.nextInt(mapWidth);
        int y = random.nextInt(mapHeight);

        // Génération de l'intensité aléatoire
        int intensityChance = random.nextInt(100);
        String intensity;
        int frequency;

        if (intensityChance < 60) { // 60% de chance
            intensity = "faible";
            frequency = 5; // Feux faibles toutes les 5 secondes
        } else if (intensityChance < 90) { // 30% de chance
            intensity = "moyenne";
            frequency = 10; // Feux moyens toutes les 10 secondes
        } else { // 10% de chance
            intensity = "forte";
            frequency = 15; // Feux forts toutes les 15 secondes
        }

        return new Fire(x, y, intensity, frequency);
    }
}
