public class Fire {
    private double latitude;
    private double longitude;
    private String intensity;
    private int frequency;

    // Constructeur
    public Fire(double latitude, double longitude, String intensity, int frequency) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.intensity = intensity;
        this.frequency = frequency;
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
}
