public class Fire {
    private double latitude;
    private double longitude;
    private int temperature;
    private String intensity;
    private int frequency;
    private int pompier_necessaire;
    private int pompier_sur_place;

    // Constructeur
    public Fire(double latitude, double longitude, int temperature, int frequency, int pompier_necessaire) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.frequency = frequency;
        this.intensity = calculateIntensity(temperature);
        this.pompier_necessaire = pompier_necessaire;
        this.pompier_sur_place = 0;
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

    public int getPompier_necessaire() {
        return pompier_necessaire;
    }

    public int getPompier_sur_place() {
        return pompier_sur_place;
    }
}
