public class Fire {
    private double latitude;
    private double longitude;
    private int temperature;
    private String intensity;
    private int frequency;

    // Constructeur
    public Fire(double latitude, double longitude, int temperature, int frequency) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.frequency = frequency;
        this.intensity = calculateIntensity(temperature);
    }

    // Méthode pour calculer l'intensité en fonction de la température
    private String calculateIntensity(double temperature) {
        if (temperature < 50) {
            return "Faible";
        } else if (temperature < 75) {
            return "Modérée";
        } else {
            return "Forte";
        }
    }

    // Getters pour les propriétés
    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getIntensity() {
        return intensity;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getTemperature() {
        return temperature;
    }
}
