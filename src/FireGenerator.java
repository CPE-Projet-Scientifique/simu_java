import java.util.Random;

public class FireGenerator {
    private Random random = new Random();

    public Fire generateRandomFire() {
        double minLatitude = 45.70;
        double maxLatitude = 45.80;
        double minLongitude = 4.80;
        double maxLongitude = 4.90;

        double latitude = minLatitude + (maxLatitude - minLatitude) * random.nextDouble();
        double longitude = minLongitude + (maxLongitude - minLongitude) * random.nextDouble();

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
        return new Fire(latitude, longitude, intensity, frequency);
    }
}
