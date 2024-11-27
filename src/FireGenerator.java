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

        int temperature = 20 + random.nextInt(71);
        int frequency;
        int pompier_necessaire;

        if (temperature < 50) {
            frequency = 5;
            pompier_necessaire = 5;
        } else if (temperature < 75) {
            frequency = 10;
            pompier_necessaire = 10;
        } else {
            frequency = 15;
            pompier_necessaire = 15;
        }

        return new Fire(latitude, longitude, temperature, frequency, pompier_necessaire);
    }
}
